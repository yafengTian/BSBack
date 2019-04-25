package servlet;
/*
 * 判断用户是否收藏某个门票
 * */
import java.io.IOException;
import model.Collection;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDao;

/**
 * Servlet implementation class GetCollection
 */
@WebServlet("/GetCollection")
public class GetCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao dao = new TicketDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=request.getParameter("openid");
		String tId="0";
		tId=request.getParameter("id");
		int id = Integer.parseInt(tId);
		Collection collection=dao.is_collection(id, openid);
		String success=collection!=null?"true":"false";
		PrintWriter out = response.getWriter();
		out.write(success);
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
