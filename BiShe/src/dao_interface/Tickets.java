package dao_interface;

import java.util.List;

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
}
