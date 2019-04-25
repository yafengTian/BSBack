package dao_interface;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Order;
public interface OrderInf {
	/*
	 * ͨ��ɨ���û��Ķ�ά�룬��ȡ��openid,Ȼ���ж����ά���Ƿ���Ч
	 * @return count:��ʾ�û�������Ʊ����Ŀ����count>=1ʱ˵����ά����Ч��������Ч��������ɨ��һ�κ��countӦ�ü���1
	 * */
	public int scan(@Param("openid")String openid,@Param("tId")int tId);
	
	/*
	 * �û�ɨ��ɹ���Ӧ�ø�������Ʊ����Ŀ
	 * */
	//public int updateCount(@Param("openid")String openid,@Param("tId")int tId);
	
	/*
	 * ��ʾ�û����ж���
	 * */
	public List<Order> allList(String openid);
	
	/*
	 * ��ʾ�û���δ����Ķ���
	 * operation=1��ʾ���ж�����operation=2��ʾδ�������operation=3��ʾ��ʹ�ö�����operation=4������ʹ�ö���
	 * */
	public List<Order> unPayList(@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 * ��ʾ�û�δʹ�ö���
	 * */
	public List<Order> unUseList(@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 *��ʾ�û��Ѿ�ʹ�õĶ���
	 * */
	public List<Order> useList(@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 * δ���۵Ķ���
	 * */
	public List<Order> uncomment(@Param("openid")String openid,@Param("flag")int flag);
	/*
	 * �޸��û�����״̬
	 * */
	public int set_status(@Param("tId")int tId,@Param("openid")String openid,@Param("flag")int flag);
}
