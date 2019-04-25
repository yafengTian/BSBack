package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserInfo;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetInfo
 */
@WebServlet("/GetInfo")
public class GetInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UserDao dao = new UserDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=request.getParameter("openid");
		model.UserInfo uf=new UserInfo(0, "fail", "fail", "fail", "fail", "fail");
		List<model.UserInfo> userInfo = dao.getInfo(openid);
		JSONObject json;
		if(userInfo!=null)
		{
			json=JSONObject.fromObject(userInfo.get(0));
		}
		else
		{
			json=JSONObject.fromObject(uf);
		}
		response.setContentType("text/json;chartset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out =response.getWriter();
		out.write(json.toString());
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
