package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Collection;
import model.Ticket;

/*
 * �й���Ʊ�Ľӿ�
 * */
public interface Tickets {
	/*
	 * @return ����ϵͳ�����о�������Ʊ
	 * */
	
	public List<Ticket> showAllTickets();
	
	/*
	 * @param tId :�û���Ҫ�鿴����Ʊ��id
	 * @return ��Ʊ��Ϣ
	 * */
	public Ticket detail(int tId);
	
	/*
	 * �û������µ�
	 *@param tId:��Ʊ��id
	 *@param count:��Ʊ��Ŀ
	 *@param openid:�û�Ψһ��ʶ
	 *@param flag:����״̬ 
	 * */
	public int pay_order(@Param("tId") int tId,@Param("count")int count,@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 * �û�������Ʊ֮�󣬸����Ѿ��۳�����Ʊ��Ŀ
	 * */
	public int update_saleCount(@Param("count")int count,@Param("tId") int tId);
	
	/*
	 *���ݲ�ͬ���࣬������Ʊ
	 * @param catagory
	 * @return ArryList<Ticket>
	 * */
	public List<Ticket> catagory(int catagory);
	
	/*
	 * �ղ���Ʊ��ȡ���ղ�
	 * @param id:��Ʊid
	 * @param openid:�û�Ψһ��ʶ
	 * */
	public int collect(@Param("id") int id,@Param("openid")String openid);
	
	/*
	 * �û�ȡ���ղ���Ʊ
	 * @param id:��Ʊid
	 * @param openid:�û�Ψһ��ʶ
	 * */
	public int cancleCollect(@Param("id") int id,@Param("openid")String openid);
	
	/*
	 * չʾ�û��������ղ�
	 * @return �����û��ղص�������Ʊ
	 * */
	public List<Ticket> show_collection(String openid);
	
	/*����id ��openid,�ж��û���û���ղظ���Ʊ
	 * @param id:��Ʊid
	 * @param openid:�û�Ψһ��ʶ
	 * */
	public Collection is_collection(@Param("id") int id,@Param("openid")String openid);
}
