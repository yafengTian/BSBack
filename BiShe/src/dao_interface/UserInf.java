package dao_interface;

import org.apache.ibatis.annotations.Param;

import model.User;

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
	
}
