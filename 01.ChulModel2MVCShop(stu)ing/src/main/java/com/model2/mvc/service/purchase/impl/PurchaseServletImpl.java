package com.model2.mvc.service.purchase.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.purchase.dao.*;
import com.model2.mvc.service.purchase.vo.*;
import com.model2.mvc.service.user.PurchaseService;

public class PurchaseServletImpl implements PurchaseService{
	
	private PurchaseDAO purchaseDAO;
	
	public PurchaseServletImpl() {
		purchaseDAO = new PurchaseDAO();
	}


	@Override
	public void addPurchase(PurchaseVO purchaseVO) throws Exception {
		purchaseDAO.insertPurchase(purchaseVO);
		System.out.println("P_S_Impl :"+purchaseVO);
	}

	@Override
	public PurchaseVO getPurchase(int tranNo) throws Exception {
		return purchaseDAO.findPurchase(tranNo);
	}

	@Override
	public HashMap<String, Object> getPurchaseList(SearchVO searchVO) throws Exception {
		return purchaseDAO.getPurchaseList(searchVO);
	}

	@Override
	public HashMap<String, Object> getSaleList(SearchVO searchVO) throws Exception {
		return purchaseDAO.getSaleList(searchVO);
	}

	@Override
	public void updatePurchase(PurchaseVO purchaseVO) throws Exception {
	}

	@Override
	public void updateTranCode(PurchaseVO purchaseVO) throws Exception {
	}


}