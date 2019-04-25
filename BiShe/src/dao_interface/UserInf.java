package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.User;
import model.UserInfo;

public interface UserInf {
	/*
	 * �û���½
	 * @param account���û��˺�
	 * @param password:�û�����
	 * @return �����û���Ϣ
	 * */
	public User login(@Param("account")String account,@Param("password")String password);
	
	/*
	 * �û�ע��
	 * @param User:�û�����
	 * @return ���ش���0������ʾע��ɹ�������ʧ��
	 * */
	public int register(User user);
	
	/*
	 * �����û���openid�ж��û��Ƿ��ǵ�һ�ε�½�����ǵ�һ�������ȥע��
	 * ���򷵻��û���Ϣ
	 * @return flag;��½��ʶ��falg=1��ʾ�ѵ�½��flag=0��ʾδ��¼
	 * */
	public int is_login(String openid);
	
	/*
	 * �����û���Ϣ
	 * @param openid:�û�Ψһ��ʶ
	 * @param nickName ΢����
	 * @param province:�û�ʡ��
	 * @param city:�û����ڳ���
	 * */
	public int saveInfo(@Param("openid")String openid,@Param("nickName")String nickName,@Param("avatarUrl")String avatarUrl,@Param("province")String province,@Param("city")String city);
	
	/*
	 * ��ȡ�û���Ϣ
	 * */
	public List<UserInfo> getInfo(String openid);
	
	/*
	 * �˳���¼
	 * */
	public int logout(String openid);
}
