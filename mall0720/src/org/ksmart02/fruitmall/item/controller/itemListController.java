package org.ksmart02.fruitmall.item.controller;

import java.io.IOException;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ksmart02.fruitmall.item.service.ItemService;

@WebServlet("/itemListController")
public class itemListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ItemService itemService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("itemListController의 doGet실행");
		int nowPage = 1;
		int limitList = 10;
		int limitLink = 10;
		int movePage = 1;
		if(request.getParameter("nowPage") != null){
			nowPage = Integer.parseInt(request.getParameter("nowPage"));	
		}
		if(request.getParameter("limitList") != null){
			limitList = Integer.parseInt(request.getParameter("limitList"));
		}
		if(request.getParameter("limitLink") != null){
			limitLink = Integer.parseInt(request.getParameter("limitLink"));
		}
		if(request.getParameter("movePage") != null){
			movePage = Integer.parseInt(request.getParameter("movePage"));
		}
		
		String categoryKeyWord 	= ""; 
		String searchKeyWord 	= "";
		itemService 			= new ItemService();
		
		if(request.getParameter("categoryKeyWord") != null){
			categoryKeyWord 	= request.getParameter("categoryKeyWord");
		//	System.out.println("itemListController로 넘어온 카테고리 키워드: "+categoryKeyWord);
		}
		if(request.getParameter("searchKeyWord") != null){
			searchKeyWord 		= request.getParameter("searchKeyWord");
		//	System.out.println("itemLisController로 넘어온 검색 키워드: "+searchKeyWord);
		}
		
		Map<String,Object> map = itemService.itemList(categoryKeyWord,searchKeyWord,nowPage,limitList,limitLink,movePage);
		
		request.setAttribute("map", map);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
