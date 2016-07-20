package org.ksmart02.fruitmall.util;

import java.util.ArrayList;
import java.util.List;

public class PageHelper {
	
	//������ ����
	private int nowPage 	= 1; 	//현재 페이지
	private int linkPage;	//아래 링크 페이지(nowPage/limitLink)+1
	private List<Integer> linkPages;	//링크 1~.....10 
	private int limitLink 	= 5; 	//링크 제한
	private int movePage 	= 1;	//이전 다음 페이지 담는 변수
	
	//����Ʈ����
	private int listOne; 	//리스트에서 맨 첫번째글 
	private int limitList 	= 5; 	//리스트 제한
	
	//��Ż ����
	private int totalPage; 	//총 페이지수 ((totalList-1)/limitList)+1
	private int totalList; 	//토탈 리스트 
	
	
	
	public PageHelper(){
		
	}
	
	public PageHelper(int totalList,PageHelper pageHelper){//5,23,10,10,1
		this.totalList 	= totalList;
		this.nowPage 	= pageHelper.getNowPage();
		this.limitList 	= pageHelper.getLimitList();
		this.limitLink 	= pageHelper.getLimitLink();

		
		
		
		this.listOne 	= ((nowPage*limitList)-limitList);
		
		this.totalPage 	= ((totalList-1)/limitList)+1;//3

		
		this.linkPages 	= new ArrayList<Integer>();
		this.linkPage 	= ((nowPage/limitLink)*limitLink)+1;
		//����,���� ��ư ������ ��� now�������� ���� �����Ѵ�.
		
		//��ũ���ϱ�
		if(nowPage%limitLink != 0){
			
			for(int i=0; i<limitLink; i++){
		
				this.linkPages.add(i,this.linkPage+i);
				if(this.totalPage==this.linkPages.get(i)){
					break;
				}
			}
			this.movePage = ((nowPage/this.limitLink)*this.limitLink)+1;
		}else{
			
			for(int i=0; i<limitLink; i++){
				
				this.linkPages.add(i,this.linkPage+i-limitLink);
				if(this.totalPage==this.linkPages.get(i)){
					break;
				}
			}
			this.movePage = nowPage-limitLink+1;
		}	

	}
	
	
	
	
	
	
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNowPgae() {
		return nowPage;
	}
	public void setNowPgae(int nowPgae) {
		this.nowPage = nowPgae;
	}
	public int getLinkPage() {
		return linkPage;
	}
	public void setLinkPage(int linkPage) {
		this.linkPage = linkPage;
	}
	public List<Integer> getLinkPages() {
		return linkPages;
	}
	public void setLinkPages(List<Integer> linkPages) {
		this.linkPages = linkPages;
	}
	public int getLimitLink() {
		return limitLink;
	}
	public void setLimitLink(int limitLink) {
		this.limitLink = limitLink;
	}
	public int getListOne() {
		return listOne;
	}
	public void setListOne(int listOne) {
		this.listOne = listOne;
	}
	public int getLimitList() {
		return limitList;
	}
	public void setLimitList(int limitList) {
		this.limitList = limitList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalList() {
		return totalList;
	}
	public void setTotalList(int totalList) {
		this.totalList = totalList;
	}
	public int getMovePage() {
		return movePage;
	}
	public void setMovePage(int movePage) {
		this.movePage = movePage;
	}
}
