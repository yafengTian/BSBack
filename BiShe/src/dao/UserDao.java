package dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao_interface.UserInf;
import model.User;
import model.UserInfo;

public class UserDao implements UserInf{
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private static SqlSession session;
    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
    
	@Override
	public User login(String account,String password) {
		session=sqlSessionFactory.openSession();
		UserInf userMapper=session.getMapper(UserInf.class);
		User user = userMapper.login(account, password);
		return user;
	}

	@Override
	public int register(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	 * 获取用户的登陆状态
	 * */
	@Override
	public int is_login(String openid) {
		session=sqlSessionFactory.openSession();
		UserInf userMapper=session.getMapper(UserInf.class);
		int flag=userMapper.is_login(openid);
		return flag;
	}

	@Override
	public int saveInfo(String openid, String nickName, String avatarUrl, String province, String city) {
		session=sqlSessionFactory.openSession();
		UserInf userMapper=session.getMapper(UserInf.class);
		int flag=userMapper.saveInfo(openid, nickName,avatarUrl, province, city);
		session.commit();
		return flag;
	}

	@Override
	public List<UserInfo> getInfo(String openid) {
		session=sqlSessionFactory.openSession();
		UserInf userMapper=session.getMapper(UserInf.class);
		List<UserInfo> userInfo=userMapper.getInfo(openid);
		return userInfo;
	}

	@Override
	public int logout(String openid) {
		session=sqlSessionFactory.openSession();
		UserInf userMapper=session.getMapper(UserInf.class);
		int x= userMapper.logout(openid);
		session.commit();
		return x;
	}
	
}
