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
	      // ������Ӧ��������
	      response.setContentType("text/html");

	      // ʵ�ʵ��߼���������
	      PrintWriter out = response.getWriter();
	      out.write(acccount+" "+pwd);
	      out.flush();
	      out.close();
	      System.out.println(acccount+" "+pwd);
	  }
	  
	  public void destroy()
	  {
	      // ʲôҲ����
	  }
}
