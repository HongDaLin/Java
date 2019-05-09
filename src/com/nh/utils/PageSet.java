package com.nh.utils;

import java.util.List;
import java.util.Map;
/**
 * 分页时返回的结果集
 * @author nhds
 *
 */
public class PageSet {
	private int pageSize;
	private int dataCount;
	private int start;
	
	private int pageCount;
	private int page;
	private List<Map<String,Object>> dataResult;
	public  PageSet(){
	}
	public int getStart() {
		start=(page-1)*pageSize;
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	public int getDataCount() {
		return dataCount;
	}
	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageCount() {
		if(pageSize<=0)
		pageCount=0;
		else{
			double pc=(double)dataCount/(double)pageSize;
			pageCount=(int)Math.ceil(pc);
		}
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public List<Map<String,Object>> getDataResult() {
		return dataResult;
	}
	public void setDataResult(List<Map<String,Object>> dataResult) {
		this.dataResult = dataResult;
	}

}

