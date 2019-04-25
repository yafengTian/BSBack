package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao_interface.AddressInf;
import model.Address;

public class AddressDao implements AddressInf{
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession session;
	private static Reader reader;
	static {
		try {
			reader=Resources.getResourceAsReader("config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Address> showAddress(String openid) {
		session=sqlSessionFactory.openSession();
		AddressInf addressInf=session.getMapper(AddressInf.class);
		return addressInf.showAddress(openid);
		
	}
	@Override
	public int addAddress(String username, String phonenumber, String openid, int moren, String area, String address) {
		session=sqlSessionFactory.openSession();
		AddressInf addressInf=session.getMapper(AddressInf.class);
		int sucess=addressInf.addAddress(username, phonenumber, openid, moren, area, address);
		session.commit();
		return sucess;
	}
}
