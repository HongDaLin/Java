package com.nh.bll;

import java.util.ArrayList;
import java.util.List;

import com.nh.utils.PageSet;

public class Message extends BLLBase{
	
	public int addMessage(String mname,String mtitle,String mcontent){
		String sql="insert into message(mname,mtitle,mcontent,mdate) values(?,?,?,now())";
		List<Object> paras=new ArrayList<Object>();
		paras.add(mname);
		paras.add(mtitle);
		paras.add(mcontent);
		return jdbcUtils.update(sql, paras);
	}
	public PageSet getMessageList(int pno,int pageSize){
		String sql="select * from message order by mid desc";
		return jdbcUtils.queryPage(sql,null,pno,pageSize);
	}
}
