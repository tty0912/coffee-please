package main.java.model.product;

import java.util.ArrayList;

public class SearchList {

	private ArrayList<BeansDO> items;
	private int beansNum;
	private int currentPage;
	private int maxPageNum;
	
	public SearchList() {
		
	}
	
	public SearchList(int beansNum, ArrayList<BeansDO> searchList) {
		this.setBeansNum(beansNum);
		this.setItems(searchList);
	}

	public ArrayList<BeansDO> getItems() {
		return items;
	}

	public void setItems(ArrayList<BeansDO> items) {
		this.items = items;
	}

	public int getBeansNum() {
		return beansNum;
	}

	public void setBeansNum(int beansNum) {
		this.beansNum = beansNum;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getMaxPageNum() {
		return maxPageNum;
	}

	public void setMaxPageNum(int maxPageNum) {
		this.maxPageNum = maxPageNum;
	}	
}
