package com.nh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nh.bll.Cart;
import com.nh.utils.HttpUtil;
import com.nh.utils.JsUtils;

public class addcartServlet extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		int pid=HttpUtil.getIntPara(request, "pid", 0);
		int num=1;
		if(request.getSession().getAttribute("sUser")==null){
			JsUtils.jsAlertGo(out, "ÇëÏÈµÇÂ¼","login");
			return;
		}
		Map<String,Object> sUser=(Map<String,Object>)request.getSession().getAttribute("sUser");
		int uid=Integer.valueOf(sUser.get("uid").toString());
		if(pid>0){
			Cart cart=new Cart();
			cart.add(pid,num,uid);
			response.sendRedirect("showcart");
		}
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

		doGet(request,response);
	}

}
