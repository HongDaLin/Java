package com.nh.bll;

import java.util.ArrayList;
import java.util.List;

public class Admin extends BLLBase{
   public int checkAdmin(String aname,String apwd){
	   String sql="select aid from admin where aname=? and apwd=?";
	   List<Object> paras=new ArrayList<Object>();
	   paras.add(aname);
	   paras.add(apwd);
	   Object oaid=jdbcUtils.queryOne(sql, paras);
	   int aid=oaid==null?0:Integer.valueOf(oaid.toString());
	   return aid;
   }
} 
