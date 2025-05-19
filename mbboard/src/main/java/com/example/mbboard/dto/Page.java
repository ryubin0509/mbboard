package com.example.mbboard.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Page {
	private int rowPerPage;
	private int currentPage;
	private int totalCount;
	private int beginRow;
	private int lastPage;
	private String searchWord;

	public Page(int rowPerPage, int currentPage, int totalCount, String searchWord) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.beginRow = (currentPage-1) * rowPerPage;
		this.searchWord = searchWord;
	}
	
	public Page(int rowPerPage, int currentPage, int totalCount) {
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.beginRow = (currentPage-1) * rowPerPage;
		
	}
	
	public int getLastPage() {
		lastPage =  this.totalCount / this.rowPerPage;
		if(this.totalCount % this.rowPerPage != 0) {
			lastPage += 1;
		}
		
		return lastPage;
	}
}
