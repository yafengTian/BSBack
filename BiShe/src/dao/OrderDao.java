package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao_interface.OrderInf;
import model.Order;

public class OrderDao implements OrderInf{
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	private static SqlSession session;
	static {
		try {
			reader=Resources.getResourceAsReader("config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int scan(String openid,int tId) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		int count = orderInf.scan(openid,tId);
		session.commit();
		return count;
	}
	/*@Override
	public int updateCount(String openid,int tId) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		int count = orderInf.updateCount(openid,tId);
		session.commit();
		return count;
	}*/
	public String scanEntr(String openid,int tId) {
		int item = scan(openid,tId);//扫码判断二维码是否可用,item>0表示可用，否则不可用
		String scan_success ="false";
		if(item>0)//门票未被使用,还可以继续使用
		{
			scan_success="true";
		}
		else
		{
			int flag=4;//门票已经被使用
			set_status(tId, openid, flag);
		}
		return scan_success;
	}
	@Override
	public List<Order> allList(String openid) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		List<Order> orders=orderInf.allList(openid);
		return orders;
	}
	@Override
	public List<Order> unPayList(String openid, int flag) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		List<Order> orders=orderInf.unPayList(openid,flag);
		return orders;
	}
	@Override
	public List<Order> unUseList(String openid, int flag) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		List<Order> orders=orderInf.unUseList(openid,flag);
		return orders;
	}
	@Override
	public List<Order> useList(String openid, int flag) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		List<Order> orders=orderInf.useList(openid,flag);
		return orders;
	}
	@Override
	public List<Order> uncomment(String openid, int flag) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		List<Order> orders=orderInf.useList(openid,flag);
		return orders;
	}
	@Override
	public int set_status(int tId, String openid, int flag) {
		session=sqlSessionFactory.openSession();
		OrderInf orderInf=session.getMapper(OrderInf.class);
		int success = orderInf.set_status(tId, openid, flag);
		session.commit();
		return success;
	}

}









