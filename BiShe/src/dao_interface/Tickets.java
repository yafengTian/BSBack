package dao_interface;

import java.util.List;

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
}
