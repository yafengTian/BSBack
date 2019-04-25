package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Collection;
import model.Ticket;

/*
 * 有关门票的接口
 * */
public interface Tickets {
	/*
	 * @return 返回系统中所有景区的门票
	 * */
	
	public List<Ticket> showAllTickets();
	
	/*
	 * @param tId :用户想要查看的门票的id
	 * @return 门票信息
	 * */
	public Ticket detail(int tId);
	
	/*
	 * 用户付款下单
	 *@param tId:门票的id
	 *@param count:门票数目
	 *@param openid:用户唯一标识
	 *@param flag:订单状态 
	 * */
	public int pay_order(@Param("tId") int tId,@Param("count")int count,@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 * 用户购买门票之后，更改已经售出的门票数目
	 * */
	public int update_saleCount(@Param("count")int count,@Param("tId") int tId);
	
	/*
	 *根据不同分类，查找门票
	 * @param catagory
	 * @return ArryList<Ticket>
	 * */
	public List<Ticket> catagory(int catagory);
	
	/*
	 * 收藏门票或取消收藏
	 * @param id:门票id
	 * @param openid:用户唯一标识
	 * */
	public int collect(@Param("id") int id,@Param("openid")String openid);
	
	/*
	 * 用户取消收藏门票
	 * @param id:门票id
	 * @param openid:用户唯一标识
	 * */
	public int cancleCollect(@Param("id") int id,@Param("openid")String openid);
	
	/*
	 * 展示用户得所有收藏
	 * @return 返回用户收藏得所有门票
	 * */
	public List<Ticket> show_collection(String openid);
	
	/*根据id 和openid,判断用户有没有收藏该门票
	 * @param id:门票id
	 * @param openid:用户唯一标识
	 * */
	public Collection is_collection(@Param("id") int id,@Param("openid")String openid);
}
