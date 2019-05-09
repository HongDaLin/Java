package com.nh.utils;

import javax.servlet.http.HttpServletRequest;

public class PageNaverUtils {
	private long Start=0;//起始数
	private int ListPage=2;//每页显示数
	private String Parameter="pno";//页数跳转时要带的参数
	private long Count;//总数
	private int CurrentPage=1;//当前页
	private int TotalPages;//总页数
	private int ListNumber=5;//前后显示多少
	private String Url;
	private HttpServletRequest curRequest;
	public PageNaverUtils(HttpServletRequest request){
		curRequest=request;
	}
	public long getStart() {
		return Start;
	}
	public void setListNumber(int listNumber){
		this.ListNumber=listNumber;
	}
	public void setListPage(int listPage){
		this.ListPage=listPage;
	}
	public int getListPage() {
		return ListPage;
	}
	private void CalculatePage(int currentPage)
	{
		if(currentPage<=1)
			this.CurrentPage=1;
		else
			this.CurrentPage=currentPage;
		this.Start=(this.CurrentPage-1)*this.ListPage;
	}
	private void SetTotalPages()
	{
		if(this.Count%this.ListPage==0)
			this.TotalPages=(int) (this.Count/this.ListPage);
		else
			this.TotalPages=(int) (this.Count/this.ListPage+1);
	}
	//保持其他参数同步
	private void GetParameter()
	{
		Url=curRequest.getQueryString();
		//如果没有参数
		if(Url==null){
			Url=curRequest.getRequestURI()+"?";//获取当前页面地址
		}
		else{
			//如果参数(不只p,还有其他参数)
			if(Url.indexOf(this.Parameter+"=")>=0){
				if(Url.indexOf("&"+this.Parameter+"=")>=0){
				Url=Url.substring(0,Url.indexOf("&"+this.Parameter+"="));
				Url=curRequest.getRequestURI()+"?"+Url+"&";
				}
				else{
					Url=curRequest.getRequestURI()+"?";
				}
			}
			else{
				Url=curRequest.getRequestURI()+"?"+Url+"&";//获取当前页面地址
			}
		}
	}
	//开始分页
	public String ShowPager(long count)
	{
		this.GetParameter();
		this.Count=count;
		if(curRequest.getParameter(this.Parameter)!=null){
			this.CalculatePage(Integer.parseInt(curRequest.getParameter(this.Parameter)));
		}else{
			this.CalculatePage(1);
		}
		this.SetTotalPages();
		String Page="";
		//Page=Page+this.CurrentPage+"/"+this.TotalPages+" 页";
		String a_class="class='number'";
		String current="class='number current'";
		if(this.CurrentPage-this.ListNumber>0){
			Page=Page+"  <a href='"+Url+this.Parameter+"=1' "+current+">第一页</a>";
			Page=Page+"  <a href='"+Url+this.Parameter+"="+(int)(this.CurrentPage-this.ListNumber)+"' "+current+">前"+this.ListNumber+"页</a>";
		}
		if(this.CurrentPage>1)
			Page=Page+"  <a href='"+Url+this.Parameter+"="+(int)(this.CurrentPage-1)+"' "+current+">&lt;</a>";
		if(this.CurrentPage<this.TotalPages)
			Page=Page+"  <a href='"+Url+this.Parameter+"="+(int)(this.CurrentPage+1)+"' "+current+">&gt;</a>";
		if(this.CurrentPage>1){
			String PageVo="";
			for(int i=this.CurrentPage-1;i>this.CurrentPage-this.ListNumber;i--){
				if(i<1)
					break;
				PageVo="<a href='"+Url+this.Parameter+"="+i+"' "+a_class+">"+i+"</a>"+PageVo;
			}
			Page=Page+PageVo;
		}
		if(this.CurrentPage<=this.TotalPages && this.TotalPages!=1){
			for(int i=this.CurrentPage;i<this.CurrentPage+this.ListNumber;i++){
				if(i==this.CurrentPage){
					Page=Page+"<span>"+i+"</span>";
					continue;
				}
				if(i>this.TotalPages)
					break;
				Page=Page+"<a href='"+Url+this.Parameter+"="+i+"' "+a_class+">"+i+"</a>";
			}
		}
		if(this.CurrentPage+this.ListNumber<this.TotalPages)
		{
			Page=Page+"  <a href='"+Url+this.Parameter+"="+(int)(this.CurrentPage+this.ListNumber)+"' "+current+">后"+this.ListNumber+"页</a>";
			Page=Page+"  <a href='"+Url+this.Parameter+"="+this.TotalPages+"' "+current+">最后一页</a>";
		}
		return Page;
	}
}

