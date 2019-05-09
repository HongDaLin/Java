package com.nh.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nh.bll.Message;
import com.nh.utils.HttpUtil;
import com.nh.utils.JsUtils;
import com.nh.utils.PageNaverUtils;
import com.nh.utils.PageSet;

public class MessageServlet extends ServletBase {

	/**
	 * Constructor of the object.
	 */
	public MessageServlet() {
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
		int pno=HttpUtil.getIntPara(request,"pno",1);
		Message message=new Message();
		PageSet pageSet=message.getMessageList(pno,2);
		request.setAttribute("messagelist",pageSet.getDataResult());
		PageNaverUtils pageNaverUtils=new PageNaverUtils(request);
		request.setAttribute("pagenav",pageNaverUtils.ShowPager(pageSet.getDataCount()));
		request.getRequestDispatcher("message.jsp").forward(request, response);
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
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String mname=HttpUtil.escapeHtml(request.getParameter("mname"));
		String mtitle=HttpUtil.escapeHtml(request.getParameter("mtitle"));
		String mcontent=HttpUtil.escapeHtml(request.getParameter("mcontent"));
		String checkno=request.getParameter("checkno");
		if(mname.isEmpty()){
			JsUtils.jsAlertBack(out, "姓名不能为空！");
			return;
		}
		if(mtitle.isEmpty()){
			JsUtils.jsAlertBack(out, "标题不能为空！");
			return;
		}
		if(mcontent.isEmpty()){
			JsUtils.jsAlertBack(out, "内容不能为空！");
			return;
		}
		HttpSession session=request.getSession();
		String rand=String.valueOf(session.getAttribute("rand"));
		if(!checkno.equalsIgnoreCase(rand)){
			JsUtils.jsAlertBack(out, "验证码不对！");
			return;
		}
		Message message=new Message();
		int result=message.addMessage(mname, mtitle, mcontent);
		if(result>0){
			JsUtils.jsAlertGo(out, "发布成功！", "message");
		}
		else{
			JsUtils.jsAlertBack(out, "发布失败！");
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
