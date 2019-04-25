package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDao;

/**
 * Servlet implementation class Collection
 */
@WebServlet("/Collection")
public class Collection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao dao=new TicketDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tId=request.getParameter("id");
		String openid=request.getParameter("openid");
		String flag=request.getParameter("flag");
		System.out.println(flag);
		int id=0;
		String success="false";
		if(tId!=null)
		{
			id=Integer.parseInt(tId);
		}
		if("1".equals(flag))//flag==1表示收藏
		{
			success=dao.collect(id, openid)>0?"true":"false";
		}
		else if("2".equals(flag))//flag==2表示取消收藏
		{
			success=dao.cancleCollect(id, openid)>0?"true":"fasle";
		}
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
