package com.nh.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart extends BLLBase {
	public void add(int cpid,int cnum,int cuid){
		if(checkCart(cpid,cuid)){
			updateNum(cpid,cnum,cuid);
		}else{
			addcart(cpid,cnum,cuid);
		}	
	}
	/*
	 * 判断该用户是否已购买该汽车
	 */
	public boolean checkCart(int cpid,int cuid){
		String sql="select count(*) from cart where cpid=? and cuid=?";
		List<Object> paras= new ArrayList<Object>();
		paras.add(cpid);
		paras.add(cuid);
		int num=Integer.valueOf(jdbcUtils.queryOne(sql, paras).toString());
		return num>0;
	}
	/*
	 * 判断用户所购买的产品ID更新数量
	 * 
	 */
	public int updateNum(int cpid,int cnum,int cuid){
		String sql="update cart set cnum=cnum+? where cpid=? and cuid=?";
		List<Object> paras= new ArrayList<Object>();
		paras.add(cnum);
		paras.add(cpid);
		paras.add(cuid);
		return jdbcUtils.update(sql, paras);
	}
	/*
	 * 添加一个购物项
	 * 
	 */
	public int addcart(int cpid,int cnum,int cuid){
		String sql="insert into cart(cpid,cnum,cuid) values(?,?,?)";
		List<Object> paras= new ArrayList<Object>();
		paras.add(cpid);
		paras.add(cnum);
		paras.add(cuid);
		return jdbcUtils.update(sql, paras);
	}
	public List<Map<String,Object>> getCartList(int uid){
		String sql ="select cid,cnum,pid,pname,ppic,pprice from cart inner join product on cpid=pid where cuid=?";
		List<Object> paras= new ArrayList<Object>();
		paras.add(uid);
		return jdbcUtils.query(sql, paras);
	}
	public void update(String[] nums,String[] cids){
		for(int i=0;i<nums.length;i++){
			int num=Integer.valueOf(nums[i]);
			int cid=Integer.valueOf(cids[i]);
			updateNum(num,cid);
		}
	}
	public void updateNum(int num,int cid){
		String sql="update cart set cnum=? where cid=?";
		List<Object> paras= new ArrayList<Object>();
		paras.add(num);
		paras.add(cid);
		jdbcUtils.update(sql, paras);
	}
}
