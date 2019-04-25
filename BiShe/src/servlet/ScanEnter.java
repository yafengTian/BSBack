package servlet;
/*
 * 景区系统通过扫码，判断用户的票是否合法，若合法则让该用户进入景区，否则拒绝进入
 * */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;

/**
 * Servlet implementation class ScanEnter
 */
@WebServlet("/ScanEnter")
public class ScanEnter extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderDao dao=new OrderDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanEnter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid="null";
		openid=request.getParameter("openid");
		String id="0";
		int tId=0;
		id=request.getParameter("tId");
		if(id!=""&&id!=null)
		{
			tId=Integer.parseInt(id);
		}
		
		String success= dao.scanEntr(openid,tId);
		response.setContentType("text/json;chartset=UTF-8");
		response.setCharacterEncoding("UtF-8");
		PrintWriter out = response.getWriter();
		out.write(success);
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//String openid=request.getParameter("openid");
		//System.out.println(openid);
	}

}
