package com.nh.servlets.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nh.bll.Category;
import com.nh.bll.Product;
import com.nh.utils.JsUtils;
import com.nh.utils.UploadUtil;

public class ProductAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProductAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        //显示添加的界面
		Category category=new Category();
		request.setAttribute("catelist",category.getCartgoryList());
		request.getRequestDispatcher("productadd.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//接收数据，并添加数据库
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out=response.getWriter();	
	UploadUtil uploadUtil=new UploadUtil(getServletContext(),request);
	String pname=uploadUtil.getParameter("pname");
	float pprice=Float.valueOf(uploadUtil.getParameter("pprice"));
	int pcid=Integer.valueOf(uploadUtil.getParameter("pcid"));
	String pcontent=uploadUtil.getParameter("pcontent");
	int phot=uploadUtil.getParameter("phot")==null?0:1;
	int pnew=uploadUtil.getParameter("pnew")==null?0:1;
	int pcheap=uploadUtil.getParameter("pcheap")==null?0:1;
	if(pname.isEmpty()){
		JsUtils.jsAlertBack(out, "名称不能为空！");
		return;
	}
	if(pprice<=0){
		JsUtils.jsAlertBack(out, "价格不对！");
		return;
	}
	if(pcid<=0){
		JsUtils.jsAlertBack(out, "请选择品牌！");
		return;
	}
	if(pcontent.isEmpty()){
		JsUtils.jsAlertBack(out, "简介不能为空！");
		return;
	}
	String ppic="";
	try{
		List<String> path=uploadUtil.upload();
		ppic=path.get(0);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	Product product=new Product();
	int result=product.addProduct(pname, pprice, pcid, pcontent, ppic,phot,pnew,pcheap);
	if(result>0){
		JsUtils.jsAlertGo(out, "添加成功！", "productadd");
	}else{
		JsUtils.jsAlertBack(out, "添加失败！");
	}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
