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
 * Servlet implementation class ShowCollection
 */
@WebServlet("/ShowCollection")
public class ShowCollection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    TicketDao dao=new TicketDao();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=request.getParameter("openid");
		List<model.Ticket> collection=dao.show_collection(openid);
		String imagesUrl=Util.url;

		for(int i=0;i<collection.size();i++)
		{
		//Æ´½ÓÍ¼Æ¬µÄurl
			collection.get(i).setImage(imagesUrl+collection.get(i).getImage());
		}
		JSONArray json = JSONArray.fromObject(collection);
		response.setContentType("text/jsn;chartset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
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
