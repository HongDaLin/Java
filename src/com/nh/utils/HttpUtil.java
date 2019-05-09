package com.nh.utils;

import javax.servlet.http.HttpServletRequest;

public class HttpUtil {
	public static int getIntPara(HttpServletRequest request,String pName,int defaultValue){
		if(request.getParameter(pName)==null){
			return defaultValue;
		}
		else{
			return Integer.parseInt(request.getParameter(pName));
		}
	}
	public static String getStringPara(HttpServletRequest request,String pName,String defaultValue){
		String result=request.getParameter(pName)==null?defaultValue:request.getParameter(pName);
		return result;
		}
	public static String nl2br(String str){
		String result=str.replaceAll("\\n", "<br/>");
		return result;
	}
	public static String nl2p(String str){
		str="<p>"+str+"</p>";
		String result=str.replaceAll("\\n", "<p/><p>");
		return result;
	}
	public static String escapeHtml(String str){
	       if( str == null ){
	             return null;
	       }
	       int len = str.length();
	       StringBuffer sb = new StringBuffer(len);
	       for(int i=0; i<len; i++){
	             char c = str.charAt(i);
	             switch( c ){
	                  case ' ':
	                      sb.append("&nbsp;");
	                      break;
	                  case '<':
	                      sb.append("&lt;");
	                      break;
	                  case '>':
	                      sb.append("&gt;");
	                      break;
	                  case '&':
	                      sb.append("&amp;");
	                      break;
	                  case '"':
	                      sb.append("&quot;");
	                      break;
	                  default:
	                      sb.append(c);
	             }
	       }
	       return sb.toString();
	}
}
