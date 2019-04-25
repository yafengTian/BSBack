package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDao;
import net.sf.json.JSONArray;
import util.Util;

/**
 * Servlet implementation class GetTicketByCatagory
 */
@WebServlet("/GetTicketByCatagory")
public class GetTicketByCatagory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TicketDao dao=new TicketDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param="0";
		param=request.getParameter("catagory");
		int catagory=Integer.parseInt(param);
		List<model.Ticket> tickets=dao.catagory(catagory);
		for(int i=0;i<tickets.size();i++)
		{
			tickets.get(i).setImage(Util.url+tickets.get(i).getImage());
		}
		response.setContentType("text/json;chartset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		JSONArray json=JSONArray.fromObject(tickets);
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
