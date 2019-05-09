package com.nh.bll;

import java.util.List;
import java.util.Map;

public class Category extends BLLBase {
    public List<Map<String, Object>> getCartgoryList(){
    	String sql="select * from category";
    	return jdbcUtils.query(sql);
    }
}
