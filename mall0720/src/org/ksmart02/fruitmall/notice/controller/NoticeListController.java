package org.ksmart02.fruitmall.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.ksmart02.fruitmall.notice.model.Notice;
import org.ksmart02.fruitmall.notice.service.NoticeService;


@WebServlet("/NoticeListController")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
ArrayList<Notice> list = new ArrayList<Notice>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		NoticeService noticeService = new NoticeService();
		Map<String, Object> map;
		try {
			map = noticeService.selectNotice(nowPage,limitList,limitLink,movePage);
			request.setAttribute("map", map);
		} catch (Exception e) {
			response.sendRedirect("/WEB-INF/Views/error.jsp");
		}
		
		HttpSession session = request.getSession();	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/notice/noticeList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
