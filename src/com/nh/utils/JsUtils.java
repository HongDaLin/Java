package com.nh.utils;
import java.io.IOException;
import java.io.PrintWriter;
public class JsUtils {  
	
   public static void jsAlertBack(PrintWriter out,String msg) throws IOException{
	   out.println("<script language='JavaScript'>alert('"+msg+"');history.back();</script>");
   }
   public static void jsAlertGo(PrintWriter out,String msg,String url) throws IOException{
	   out.println("<script language='JavaScript'>alert('"+msg+"');location.href='"+url+"';</script>");
   }
   
	
	
}
