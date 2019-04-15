package dao_interface;

import org.apache.ibatis.annotations.Param;

import model.User;

public interface UserInf {
	/*
	 * 用户登陆
	 * @param account：用户账号
	 * @param password:用户密码
	 * @return 返回用户信息
	 * */
	public User login(@Param("account")String account,@Param("password")String password);
	
	/*
	 * 用户注册
	 * @param User:用户对象
	 * @return 返回大于0的数表示注册成功，否则失败
	 * */
	public int register(User user);
	
	/*
	 * 根据用户的openid判断用户是否是第一次登陆，若是第一次则该先去注册
	 * 否则返回用户信息
	 * @return flag;登陆标识，falg=1表示已登陆，flag=0表示未登录
	 * */
	public int is_login(String openid);
	
}
