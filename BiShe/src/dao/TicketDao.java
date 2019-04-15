package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao_interface.Tickets;
import model.Ticket;

/*
 * √≈∆±µƒdao¿‡
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

}
