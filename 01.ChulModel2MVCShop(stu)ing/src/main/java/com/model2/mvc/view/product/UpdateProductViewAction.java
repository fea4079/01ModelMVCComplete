package com.model2.mvc.view.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.impl.ProductServletImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.ProductService;



public class UpdateProductViewAction extends Action{


	public String execute(	HttpServletRequest request,	HttpServletResponse response) throws Exception {
//		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		ProductVO productVO = new ProductVO(); 
		productVO = (ProductVO)request.getAttribute("ProductVO");
		ProductService service=new ProductServletImpl();
//		ProductVO productVO=service.getProduct(prodNo);
		
		String menu = request.getParameter("menu");
		System.out.println("UpdateProductViewAction menu="+menu);	
		request.setAttribute("PorductVO", productVO);
		System.out.println("UpdateProductViewAction 555555555555555555555555555555555555");
		return "forward:/product/updateProductView.jsp";
	}
}
