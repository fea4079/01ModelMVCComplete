package com.model2.mvc.service.product.impl;

import java.util.HashMap;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.service.product.dao.ProductDAO;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.ProductService;

public class ProductServletImpl implements ProductService{
	
	private ProductDAO productDAO;
	
	public ProductServletImpl() {
		productDAO = new ProductDAO();
	}

	public void addProduct(ProductVO productVO) throws Exception {
		productDAO.insertProduct(productVO);
		System.out.println("P_S_Impl :"+productVO);
	}
	
	public ProductVO getProduct(int prodNo) throws Exception {
		return productDAO.findProduct(prodNo);
	}
	

	public HashMap<String,Object> getProductList(SearchVO searchVO) throws Exception {
		return productDAO.getProductList(searchVO);
	}

	public void updateProduct(ProductVO productVO) throws Exception {
		productDAO.updateProduct(productVO);
	}


}