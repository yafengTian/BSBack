package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.User;
import model.UserInfo;

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
	
	/*
	 * 保存用户信息
	 * @param openid:用户唯一标识
	 * @param nickName 微信名
	 * @param province:用户省份
	 * @param city:用户所在城市
	 * */
	public int saveInfo(@Param("openid")String openid,@Param("nickName")String nickName,@Param("avatarUrl")String avatarUrl,@Param("province")String province,@Param("city")String city);
	
	/*
	 * 获取用户信息
	 * */
	public List<UserInfo> getInfo(String openid);
	
	/*
	 * 退出登录
	 * */
	public int logout(String openid);
}
