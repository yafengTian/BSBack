package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDao;
import model.Ticket;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import util.Util;

/**
 * Servlet implementation class HomeImage
 */
@SuppressWarnings("serial")
public class HomeImage extends HttpServlet {
     private TicketDao dao=new TicketDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<Ticket> tickets=dao.showAllTickets();
			//String imagesUrl="http://154.8.136.60:8080/userImage/";
			String imagesUrl=Util.url;

			for(int i=0;i<tickets.size();i++)
			{
			//Æ´½ÓÍ¼Æ¬µÄurl
			tickets.get(i).setImage(imagesUrl+tickets.get(i).getImage());
			}
		JSONArray json=JSONArray.fromObject(tickets);
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
