package test;

import java.util.List;

import dao.TicketDao;
import model.Ticket;

public class Test {
	public static void main(String[] args) {
		TicketDao dao = new TicketDao();
		 List<Ticket> ti=dao.showAllTickets();
		System.out.println(ti);
	}

}
