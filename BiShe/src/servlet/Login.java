package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;
import net.sf.json.JSONObject;


@SuppressWarnings("serial")
public class Login extends HttpServlet{
	private static UserDao user_dao=new UserDao();


	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  JSONObject json;
		  String account=request.getParameter("account");
		  String password=request.getParameter("password");
		  PrintWriter out = response.getWriter();
		  System.out.println(account+" "+password);
		  User user = user_dao.login(account, password);
		  if(user!=null)//用户登陆成功
		  {
			  json = JSONObject.fromObject(user);
		  }
		  else//登陆失败
		  {
			  User u=new User(0, "fail", "fail", "fail", "fail","fail");
			  json=JSONObject.fromObject(u);
		  }
		  	out.write(json.toString());
	        out.flush();
	        out.close();
	  }
	  public void doPost(HttpServletRequest request,
              HttpServletResponse response) throws IOException, ServletException {
		  doGet(request, response);
	  }
	    
}
