package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao_interface.Tickets;
import model.Collection;
import model.Ticket;

/*
 * 门票的dao类
 * */
public class TicketDao implements Tickets{
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession session;
	static {
		try {
			reader=Resources.getResourceAsReader("config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public  List<Ticket> showAllTickets() {
		session=sqlSessionFactory.openSession();
		Tickets tickets=session.getMapper(Tickets.class);
		 List<Ticket> ticket = tickets.showAllTickets();
		return ticket;
	}
	@Override
	public Ticket detail(int tId) {
		session=sqlSessionFactory.openSession();
		Tickets tickets=session.getMapper(Tickets.class);
		Ticket ticket=tickets.detail(tId);
		return ticket;
	}
	@Override
	public int pay_order(int tId, @Param("count")int count,String openid,int flag) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		int success = tickets.pay_order(tId,count,openid,flag);
		session.commit();
		return success;
	}
	@Override
	public List<Ticket> catagory(int catagory) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		return tickets.catagory(catagory);
	}
	@Override
	public int collect(int id, String openid) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		int success=tickets.collect(id,openid);
		session.commit();
		return success;
	}
	@Override
	public int cancleCollect(int id, String openid) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		int success=tickets.cancleCollect(id,openid);
		session.commit();
		return success;
	}
	@Override
	public List<Ticket> show_collection(String openid) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		List<model.Ticket> collection=tickets.show_collection(openid);
		session.commit();
		return collection;
	}
	@Override
	public Collection is_collection(int id, String openid) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		return tickets.is_collection(id, openid);	
	}
	@Override
	public int update_saleCount(int count, int tId) {
		session = sqlSessionFactory.openSession();
		Tickets tickets = session.getMapper(Tickets.class);
		int success=tickets.update_saleCount(count, tId);
		session.commit();
		return success;
	}
	/*
	 * 用户付款购买门票，同时更新已经售出的门票数目
	 * */
	public int orders(int tId,int count,String openid,int flag) {
		int pay=this.pay_order(tId,count, openid, flag);
		int update=this.update_saleCount(count, tId);
		return pay*update;
	}

}
