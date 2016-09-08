package org.zerock.domain;

public class Criteria {
	private int page;
	private int perPageNum;
	
	public Criteria(){
		this.page=1;
		this.perPageNum=5;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0){
			this.page=1;
			return;
		}
		
		this.page = page;
	}
	
	//method for MyBatis SQL Mapper
	public int getPageStart(){
		return (this.page-1)*perPageNum;
	}

	public int getPerPageNum() {
		
		return perPageNum;
	}
	
	//method for MyBatis SQL Mapper
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <=0||perPageNum>100){
			this.perPageNum=5;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public String toString(){
		return "Criteria [page="+page+","+"perPageNum="+perPageNum+"]";
	}
	
	
}
