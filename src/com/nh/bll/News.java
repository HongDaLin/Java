package com.nh.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nh.utils.PageSet;
public class News extends BLLBase{
	/*
	 * 获取一条新闻
	 */
   public Map<String,Object> getNews(int nid){
		String sql="select * from news where nid=?";
		List<Object> paras=new ArrayList<Object>();
		paras.add(nid);
		return jdbcUtils.queryOneRow(sql, paras);
   }
   /*获取新闻列表*/
   public PageSet getNewsList(int pno,int pageSize,String key){
	   String sql="select nid,ntitle,ndate from news where ntitle like ? order by nid desc";
	   List<Object> paras=new ArrayList<Object>();
	   try{
	   key=new String(key.getBytes("ISO-8859-1"),"utf8");
	   paras.add("%"+key+"%");
   }catch(Exception e){
		 e.printStackTrace();
	 }
    return jdbcUtils.queryPage(sql,paras,pno,pageSize);
}
}
