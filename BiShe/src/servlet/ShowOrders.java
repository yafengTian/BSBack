package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import model.Order;
import model.Ticket;
import model.TicketOrder;
import net.sf.json.JSONArray;
import util.Util;

/**
 * Servlet implementation class ShowOrders
 */
@WebServlet("/ShowOrders")
public class ShowOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderDao dao=new OrderDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String openid=request.getParameter("openid");
		String catagory=request.getParameter("flag");
		int flag=0;
		response.setContentType("text/json;chartset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		List<Order> orders=new ArrayList<>();
		if("1".equals(catagory))//所有订单
		{
			orders=dao.allList(openid);
		}
		else if("2".equals(catagory))//未付款订单
		{
			flag=Integer.parseInt(catagory);
			orders=dao.unPayList(openid, flag);
		}
		else if("3".equals(catagory))
		{
			flag=Integer.parseInt(catagory);
			orders=dao.unUseList(openid, flag);
		}
		else if("4".equals(catagory))
		{
			flag=Integer.parseInt(catagory);
			orders=dao.useList(openid, flag);
		}
		else if("5".equals(catagory))
		{
			flag=Integer.parseInt(catagory);
			orders=dao.uncomment(openid,flag);
		}
		OrderDao dao =new OrderDao();
		List<TicketOrder> ticketOrders=new ArrayList<>();
		Order order;
		String imagesUrl=Util.url;
		for(int i=0;i<orders.size();i++)
		{
			order=orders.get(i);
			Ticket ticket=order.getTikets().get(0);
			int count=order.getCount();
			int f=order.getFlag();
			int tId=order.gettId();
			String ticketName=ticket.getTicketName();
			String descration=ticket.getDescration();
			String image=imagesUrl+ticket.getImage();
			int price=ticket.getPrice();
			int money=count*price;
			TicketOrder ticketOrder=new TicketOrder(count, money, f, tId, ticketName, descration, image, price);
			Util.setStatus(ticketOrder, ticketOrder.getFlag());//设置用户订单状态
			ticketOrders.add(ticketOrder);
		}
		JSONArray json=JSONArray.fromObject(ticketOrders);
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
