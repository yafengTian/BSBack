package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 获取门票详情servlet
 * */
import dao.TicketDao;
import model.Ticket;
import net.sf.json.JSONArray;
import util.Util;

@SuppressWarnings("serial")
public class Detail extends HttpServlet {
	private TicketDao dao=new TicketDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String id=request.getParameter("tId");
		 System.out.println(id);
		 int tId=0;
		 Ticket ticket=null;
		 if(!"".equals(id))
		 {
			 	tId=Integer.parseInt(id); 
				ticket=dao.detail(tId);
				String imagesUrl=Util.url;
				ticket.setImage(imagesUrl+ticket.getImage());
		 }
		JSONArray json=JSONArray.fromObject(ticket);
		response.setContentType("text/json;chartset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		out.write(json.toString());
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
