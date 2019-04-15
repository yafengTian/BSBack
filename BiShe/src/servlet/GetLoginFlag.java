package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import util.Util;

@SuppressWarnings("serial")
public class GetLoginFlag extends HttpServlet{
	private String appid="wx7406e5c03f9977ce";
	private String secretKey="c4a67f63478f3449074b477d134077fa";
	private static UserDao user_dao=new UserDao();


	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  
	      // 设置响应内容类型
		  String flag="0";//登陆状态
	      response.setContentType("text/html");
		  String operFlag=request.getParameter("operFlag");
		  String result="";
		  if("getOpenid".equals(operFlag)) {
			  String code = request.getParameter("code");
			  //通过微信API获取openid和session——key
			  String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid + "&secret=" + secretKey
	                    + "&js_code=" + code + "&grant_type=authorization_code"; 
			  result=Util.sendGetReq(url);
			  System.out.println(result);
		  }
		  	response.setContentType("application/json;charset=UTF-8");
	        response.setHeader("catch-control", "no-catch");
	        PrintWriter out = response.getWriter();
	        out.write(result);
	        out.flush();
	        out.close();
	  }
	  public void doPost(HttpServletRequest request,
              HttpServletResponse response) throws IOException, ServletException {
		  doGet(request, response);
	  }
	    
}
