package com.nh.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Users extends BLLBase {
	 public  Map<String,Object> checkuser(String uname,String upwd){
		 String sql="select  uid from users where uname=? and  upwd=?";
		 List<Object> paras=new ArrayList<Object>();
		 paras.add(uname);
		 paras.add(upwd);
		 return jdbcUtils.queryOneRow(sql, paras);
	 }
}
