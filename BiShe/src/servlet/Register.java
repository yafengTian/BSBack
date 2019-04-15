package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	String acccount;
	String pwd;

	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  acccount=request.getParameter("account");
		  pwd=request.getParameter("password");
	      // 设置响应内容类型
	      response.setContentType("text/html");

	      // 实际的逻辑是在这里
	      PrintWriter out = response.getWriter();
	      out.write(acccount+" "+pwd);
	      out.flush();
	      out.close();
	      System.out.println(acccount+" "+pwd);
	  }
	  
	  public void destroy()
	  {
	      // 什么也不做
	  }
}
