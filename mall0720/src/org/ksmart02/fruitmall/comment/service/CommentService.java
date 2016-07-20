package org.ksmart02.fruitmall.comment.service;

import java.util.ArrayList;
import java.util.Map;

import org.ksmart02.fruitmall.comment.model.Comment;
import org.ksmart02.fruitmall.comment.model.CommentDao;
import org.ksmart02.fruitmall.util.PageHelper;

public class CommentService {
	
	private CommentDao commentDao;
	private Comment comment;
	private Comment comment2;
	
	//commentAvgStar 평균별점
	public int commentAvgStarService(Comment comment){
		int avgStar = 0;
		commentDao = new CommentDao();
		try {
			avgStar = commentDao.starAvg(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return avgStar;
	}
	
	
	//listCommentByItemNoAndMemberId 출력
	public int commentListServiceByItemNoAndMemberId(Comment comment){
		int result = 0;
		commentDao = new CommentDao();
		try {
			result = commentDao.listCommentByItemNoAndMemberId(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//listComment출력
	public Map<String,Object> commentListService(Map map){
		
		commentDao = new CommentDao();
		
		ArrayList<Comment> listComment = new ArrayList<Comment>();
		try {
			
			int totalCount = commentDao.countComment(map);
			int nowPage = (int)map.get("nowPage");
			int limitList = (int)map.get("limitList");
			int limitLink = (int)map.get("limitLink");
			int movePage = (int)map.get("movePage");
			System.out.println("CommentService totalCount :" + totalCount);
			System.out.println("CommentService nowPage :" + nowPage);
			System.out.println("CommentService limitList :" + limitList);
			System.out.println("CommentService limitLink :" + limitLink);
			System.out.println("CommentService movePage :" + movePage);
			PageHelper pageHelper = new PageHelper(nowPage,totalCount,limitList,limitLink,movePage);
			
			listComment = commentDao.listComment(pageHelper, map);
			
			map.put("listComment", listComment);
			map.put("pageHelper", pageHelper);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return map;
	}
		
	
	//addComment 추가
	public int commentAddService(Comment comment){
		System.out.println("commentAddService comment :"+ comment);
		int result = 0;
		commentDao = new CommentDao();
		try {
			result = commentDao.addComment(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	//delComment 삭제
	public int commentDelService(Comment comment){
		int result = 0;
		commentDao = new CommentDao();
		try {
			commentDao.delComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//updateFormComment 수정폼으로
	public Comment commentUpdateFormService(Comment comment){
		commentDao = new CommentDao();
		comment2 = new Comment();
		try {
			comment2 = commentDao.updateFormComment(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return comment2;
	}
	
	//updateComment 수정
	public int commentUpdateService(Comment comment){
		int result = 0;
		commentDao = new CommentDao();
		try {
			result = commentDao.updateComment(comment);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
