package org.ksmart02.fruitmall.seller.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ksmart02.fruitmall.seller.service.SellerService;
import org.ksmart02.fruitmall.util.PageHelper;

@WebServlet("/SellerItemListController")
public class SellerItemListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SellerService sellerService;
	/**
	 * get으로 요청 받아서 request에서 sellerNo을 받아서
	 * sellerService로 넘겨줍니다.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nowPage 	= 1;
		int movePage 	= 1;
		int limitLink 	= 5;
		int limitList 	= 5;
		int sellerNo 	= Integer.parseInt(request.getParameter("sellerNo"));
		sellerService 	= new SellerService();
		if(request.getParameter("nowPage") != null){
			nowPage 	= Integer.parseInt(request.getParameter("nowPage"));
		}
		if(request.getParameter("movePage") != null){
			movePage 	= Integer.parseInt(request.getParameter("movePage"));
		}
		if(request.getParameter("limitLink") != null){
			limitLink 	= Integer.parseInt(request.getParameter("limitLink"));
		}
		if(request.getParameter("limitList") != null){
			limitList 	= Integer.parseInt(request.getParameter("limitList"));
		}
		
		Map<String, Object> map 	= sellerService.sellerItemList(sellerNo,nowPage,movePage,limitLink,limitList);
		
		request.setAttribute("map", map);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/seller/sellerItemList.jsp");
		rd.forward(request, response);
	}
}
