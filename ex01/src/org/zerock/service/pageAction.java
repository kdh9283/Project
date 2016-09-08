package org.zerock.service;

import org.springframework.stereotype.Component;

@Component
public class pageAction {
	public String paging(int count, int pageSize, int currentPage){
		int totPage=(count/pageSize)+(count%pageSize==0?0:1);
		int blockpage=3;
		
		int startPage=((currentPage-1)/blockpage)*blockpage+1;
		int endPage=startPage+blockpage-1;
		if(endPage>totPage) endPage=totPage;
		
		StringBuffer sb=new StringBuffer();
		if(count>0){
			if(startPage>blockpage){
				sb.append("<a href='list?pageNum=");
	    		sb.append(startPage-blockpage);
	    	
	    		sb.append("'>[이전]</a>");
			}
			for(int i=startPage; i<=endPage; i++){
				if(i==currentPage){
					sb.append("["+i+"]");
				}else{
					sb.append("<a href='list?pageNum=");
		    		sb.append(i);
		    	
		    		sb.append("'>["+i+"]</a>");
				}
			}
			if(endPage<totPage){ //다음
	    		  sb.append("<a href='list?pageNum=");
	    		  sb.append(startPage+blockpage);
	    		
	    		  sb.append("'>[다음]</a>");
	    	  }
		}
		
		return sb.toString();
	}
}
