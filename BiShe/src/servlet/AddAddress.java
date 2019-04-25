package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AddressDao;

/**
 * Servlet implementation class AddAddress
 */
@WebServlet("/AddAddress")
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddressDao dao=new AddressDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid="null";
		String address="null";
		String flag="0";
		String username="null";
		String myarea="null";
		String phonenumber="null";
		String success="false";
		address=request.getParameter("address");
		flag=request.getParameter("moren");
		username=request.getParameter("username");
		myarea=request.getParameter("area");
		phonenumber=request.getParameter("phonenumber");
		openid=request.getParameter("openid");
		System.out.println(openid);		
		int moren=-1;
		if(!"null".equals(address)&&!"null".equals(openid)&&!"null".equals(flag)&&!"null".equals(username)&&!"null".equals(phonenumber)&&!"null".equals(myarea))
		{
			moren=Integer.parseInt(flag);
			//格式化用户地址
			String province=myarea.substring(2, 5);
			String city=myarea.substring(8,11);
			String area=myarea.substring(14,myarea.length()-2);
			String my_area=province+" "+city+" "+area;
			success=dao.addAddress(username, phonenumber, openid, moren, my_area, address)>0?"true":"false";
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
