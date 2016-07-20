package org.ksmart02.fruitmall.item.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.ksmart02.fruitmall.item.model.Item;
import org.ksmart02.fruitmall.item.model.ItemDao;
import org.ksmart02.fruitmall.util.PageHelper;

public class ItemService {
	
	private ItemDao itemDao;
	private Item item;
	
	public void modifyItem(Item item){
		try {
			itemDao = new ItemDao();
			itemDao.updateItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//아이템 목록 등록하는 메서드 (최초 기입 이한녕)
	public int addItem(Item item){
		int result =0;
		try {
			itemDao = new ItemDao();
			result = itemDao.insertItem(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//상품 목록을 보여주는 메서드(최초 기입 이한녕)+페이징 수정(0717 박종무)
	public Map<String,Object> itemList(String categoryKeyWord, String searchKeyWord, int nowPage, int limitList, int limitLink, int movePage){
		System.out.println("ItemService의 itemList실행");
		Map<String,Object> map = new HashMap<String,Object>();
		itemDao 					= new ItemDao();
		ArrayList<Item> itemList 	= null;
		PageHelper pageHelper = null;
		int totalCount = itemDao.countList();
		try {
			pageHelper = new PageHelper(nowPage,totalCount,limitList,limitLink,movePage);
			itemList = new ArrayList<Item>();
			
			itemList = itemDao.selectItemAll(categoryKeyWord,searchKeyWord,pageHelper);
			
			map.put("itemList", itemList);
			map.put("pageHelper", pageHelper);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		return map;
	}
	
	
	//상품 한 개의 상세를 보여주는 메서드(최초 기입 박종무)
	public Item itemDetail(int itemNo){
		System.out.println("ItemService의 itemDetail실행");
		
		itemDao		= new ItemDao();
		item 		= new Item();
		try {
			item 	= itemDao.selectItemByItemNo(itemNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
		
	}
	
	public void itemDelete(Item item) {
		System.out.println("ItemService의 itemDelete 실행");
		itemDao		= new ItemDao();
		try {
			itemDao.updateItemByItemOut(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	



}
