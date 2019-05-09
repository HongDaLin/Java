package com.nh.bll;

import com.nh.utils.JdbcUtils;

public class BLLBase {
	protected JdbcUtils jdbcUtils;
	public BLLBase(){
		jdbcUtils=new JdbcUtils();
	}
}
