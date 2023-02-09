package com.model2.mvc.service.purchase.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.common.util.DBUtil;
import com.model2.mvc.service.purchase.vo.*;

/**
 * Servlet implementation class ProductDAO
 */

public class PurchaseDAO{
	
	public PurchaseDAO() {
		
	}
	
	public PurchaseVO findPurchase(int tranNo) throws Exception{
		Connection con = DBUtil.getConnection();

		String sql = " select * from PRODUCT where PROD_NO=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, tranNo);

		ResultSet rs = stmt.executeQuery();
		System.out.println("PurchaseDAO: 제품select쿼리 입력완료");

		PurchaseVO purchaseVO = null;
		while (rs.next()) {
			purchaseVO = new PurchaseVO();
			purchaseVO.setBuyer(rs.getString("Buyer"));
			purchaseVO.setDivyAddr(rs.getString("divyadr"));
			purchaseVO.setDivyDate(rs.getString("divydate"));
			purchaseVO.setDivyRequest(rs.getString("divyrequest"));
			purchaseVO.setOrderDate(rs.getDate("orderdate"));
			purchaseVO.setPaymentOption(rs.getString("paymentoption"));
			purchaseVO.setPurchaseProd(rs.getString("paymentoption"));
			purchaseVO.setReceiverName(rs.getString("receivername"));
			purchaseVO.setReceiverPhone(rs.getString("receiverphone"));
			purchaseVO.setTranCode(rs.getString("trancode"));
			
		}
		
		con.close();

		return purchaseVO;
	}
	
	public void insertProduct(PurchaseVO purchaseVO)throws Exception{
		Connection con = DBUtil.getConnection();

		String sql = "	insert into PRODUCT(PROD_NO, PROD_NAME, PROD_DETAIL, MANUFACTURE_DAY, PRICE, IMAGE_FILE, REG_DATE) \r\n"
				+ "			    values (seq_product_prod_no.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
		
		PreparedStatement stmt = con.prepareStatement(sql);
//		stmt.setInt(1, productVO.getProdNo());
		stmt.setString(1, purchaseVO.getProdName());
		System.out.println("productVO.getProdName() :"+purchaseVO.getProdName());
		stmt.setString(2, purchaseVO.getProdDetail());
		stmt.setString(3, purchaseVO.getManuDate());
		stmt.setInt(4, purchaseVO.getPrice());
		stmt.setString(5, purchaseVO.getFileName());
//		stmt.setDate(7, productVO.getRegDate());
		stmt.executeUpdate();
		System.out.println("ProductDAO: 상품정보 insert쿼리 작동완료");
		
		con.close();
	}
	
	
	public HashMap<String,Object> getPurchaseList(SearchVO searchVO) throws Exception{
		Connection con = DBUtil.getConnection();
		
		String sql = "select * from product ";
		if (searchVO.getSearchCondition() != null) {
			if (searchVO.getSearchCondition().equals("0")) {
				sql += " where PROD_NO='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("1")) {
				sql += " where PROD_NAME='" + searchVO.getSearchKeyword()
						+ "'";
			} else if (searchVO.getSearchCondition().equals("2")) {
				sql += " where PRICE='" + searchVO.getSearchKeyword()
				+ "'";
			}
		}
		sql += " order by PROD_NO";

		PreparedStatement stmt = 
			con.prepareStatement(	sql,
														ResultSet.TYPE_SCROLL_INSENSITIVE,
														ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = stmt.executeQuery();

		rs.last();
		int total = rs.getRow();
		System.out.println("로우의 수:" + total);

		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("count", new Integer(total));

		rs.absolute(searchVO.getPage() * searchVO.getPageUnit() - searchVO.getPageUnit()+1);
		System.out.println("searchVO.getPage():" + searchVO.getPage());
		System.out.println("searchVO.getPageUnit():" + searchVO.getPageUnit());

		ArrayList<PurchaseVO> list = new ArrayList<PurchaseVO>();
		if (total > 0) {
			for (int i = 0; i < searchVO.getPageUnit(); i++) {
				PurchaseVO vo = new PurchaseVO();
				vo.setProdNo(rs.getInt("PROD_NO"));
				vo.setProdName(rs.getString("PROD_NAME"));
				vo.setProdDetail(rs.getString("PROD_DETAIL"));
				vo.setManuDate(rs.getString("MANUFACTURE_DAY"));
				vo.setPrice(rs.getInt("PRICE"));
				vo.setFileName(rs.getString("IMAGE_FILE"));
				vo.setRegDate(rs.getDate("REG_DATE"));

				list.add(vo);
				if (!rs.next())
					break;
			}
		}
		System.out.println("list.size() : "+ list.size());
		map.put("list", list);
		System.out.println("map().size() : "+ map.size());

		con.close();
			
		return map;
	}
	
	
	public void updatPurchase(PurchaseVO purchaseVO) throws Exception{
		
		Connection con = DBUtil.getConnection();

		String sql = "	update PRODUCT set PROD_NO=?, PROD_NAME=?, PROD_DETAIL=?, \r\n"
										+ "MANUFACTURE_DAY=?, PRICE=?, IMAGE_FILE=?, REG_DATE=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, purchaseVO.getProdNo());
		stmt.setString(2, purchaseVO.getProdName());
		stmt.setString(3, purchaseVO.getProdDetail());
		stmt.setString(4, purchaseVO.getManuDate());
		stmt.setInt(5, purchaseVO.getPrice());
		stmt.setString(6, purchaseVO.getFileName());
		stmt.setDate(7, purchaseVO.getRegDate());
		stmt.executeUpdate();
		System.out.println("ProductDAO: 상품 정보 update쿼리 입력완료");
		
		con.close();
	}
}