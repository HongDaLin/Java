package com.nh.bll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nh.utils.PageSet;

public class Product extends BLLBase {
    public int addProduct(String pname,float pprice,int pcid,String pcontent,String ppic,int phot,int pnew,int pcheap){
    	String sql="insert into product(pname,pprice,pcid,pcontent,ppic,phot,pnew,pcheap) values(?,?,?,?,?,?,?,?)";
    	List<Object> paras=new ArrayList<Object>();
    	paras.add(pname);
    	paras.add(pprice);
    	paras.add(pcid);
    	paras.add(pcontent);
    	paras.add(ppic);
    	paras.add(phot);
    	paras.add(pnew);
    	paras.add(pcheap);
    	return jdbcUtils.update(sql, paras);
    }
    public PageSet getProductlist(int pno,int pageSize){
    	String sql="select pid,pname,ppic,cname from product inner join category on pcid=cid order by pdate desc";
    	return jdbcUtils.queryPage(sql, null, pno, pageSize);
    }
    public PageSet getProductlist(int pno,int pageSize,int cid){
    	String sql="select pid,pname,ppic,cname from product inner join category on pcid=cid where cid=? order by pdate desc";
    	List<Object> paras=new ArrayList<Object>();
    	paras.add(cid);
    	return jdbcUtils.queryPage(sql, paras, pno, pageSize);
    }
    public int deleteProduct(int pid){
    	String sql="delete from product where pid=?";
    	List<Object> paras=new ArrayList<Object>();
    	paras.add(pid);
    	return jdbcUtils.update(sql, paras);
    }
    public Map<String,Object> getProduct(int pid){
    	String sql="select * from product inner join category on pcid=cid where pid=?";
    	List<Object> paras=new ArrayList<Object>();
    	paras.add(pid);
    	return jdbcUtils.queryOneRow(sql, paras);
    }
    public int modifyproduct(String pname,float pprice,int pcid,String pcontent,String ppic,int pid,int phot,int pnew,int pcheap){
    	String sql="update product set pname=?,pprice=?,pcid=?,pcontent=?,ppic=?,phot=?,pnew=?,pcheap=? where pid=?";
    	List<Object> paras=new ArrayList<Object>();
    	paras.add(pname);
    	paras.add(pprice);
    	paras.add(pcid);
    	paras.add(pcontent);
    	paras.add(ppic);
    	paras.add(pid);
    	paras.add(phot);
    	paras.add(pnew);
    	paras.add(pcheap);
    	return jdbcUtils.update(sql, paras);
    }
    public List<Map<String,Object>> getHomeProductList(String pType){
    	String fileName="";
    	if(pType.equalsIgnoreCase("hot")){
    		fileName="phot";
    	}
    	else if(pType.equalsIgnoreCase("new")){
    		fileName="pnew";
    	}
    	else if(pType.equalsIgnoreCase("cheap")){
    		fileName="pcheap";
    	}
    	String sql="select pid,ppic,pname,pprice from product where "+fileName+"=1 order by pdate desc limit 0,4";
    	return jdbcUtils.query(sql);
    }
}
