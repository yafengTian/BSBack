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
 * Servlet implementation class Pay
 */
@WebServlet("/Pay")
public class Pay extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	TicketDao dao = new TicketDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tId = request.getParameter("tId");
		String count = request.getParameter("count");
		String openid=request.getParameter("openid");
		String upay=request.getParameter("flag");//unpay=0表示未付款
		String success="false";
		int flag=3;//已经付款，待使用
		if(tId!=null&&count!=null&&openid!=null)
		{
			int id=Integer.parseInt(tId);
			int number=Integer.parseInt(count);
			int unpay=Integer.parseInt(upay);//未付款
			if(unpay==0)
			{
				flag=2;//订单未付款
			}
			success=(dao.orders(id, number, openid,flag))>0?"true":"false";
		}
		PrintWriter out=response.getWriter();
		out.write(success);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
