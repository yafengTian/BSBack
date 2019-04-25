package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class UserInfo
 */
@WebServlet("/UserInfo")
public class UserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDao dao=new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=request.getParameter("openid");
		String nickName=request.getParameter("nickName");
		String province=request.getParameter("province");
		String city=request.getParameter("city");
		String avatarUrl=request.getParameter("avatarUrl");
		String succcess="false";
		if(openid!=null&&nickName!=null&&province!=null&&city!=null&&avatarUrl!=null)
		{
			succcess=(dao.saveInfo(openid, nickName, avatarUrl, province, city))>0?"true":"false";
		}
		PrintWriter out = response.getWriter();
		out.write(succcess);
		out.flush();
		out.close();
		System.out.println(province+" "+city+" "+openid+" "+nickName+" "+avatarUrl);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
