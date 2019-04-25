package dao_interface;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import model.Order;
public interface OrderInf {
	/*
	 * 通过扫描用户的二维码，获取其openid,然后判断其二维码是否有效
	 * @return count:表示用户购买门票的数目，若count>=1时说明二维码有效，否则无效，并且在扫描一次后后count应该减少1
	 * */
	public int scan(@Param("openid")String openid,@Param("tId")int tId);
	
	/*
	 * 用户扫码成功后，应该更新其门票的数目
	 * */
	//public int updateCount(@Param("openid")String openid,@Param("tId")int tId);
	
	/*
	 * 显示用户所有订单
	 * */
	public List<Order> allList(String openid);
	
	/*
	 * 显示用户还未付款的订单
	 * operation=1表示所有订单，operation=2表示未付款订单，operation=3表示待使用订单，operation=4代表已使用订单
	 * */
	public List<Order> unPayList(@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 * 显示用户未使用订单
	 * */
	public List<Order> unUseList(@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 *显示用户已经使用的订单
	 * */
	public List<Order> useList(@Param("openid")String openid,@Param("flag")int flag);
	
	/*
	 * 未评价的订单
	 * */
	public List<Order> uncomment(@Param("openid")String openid,@Param("flag")int flag);
	/*
	 * 修改用户订单状态
	 * */
	public int set_status(@Param("tId")int tId,@Param("openid")String openid,@Param("flag")int flag);
}
