package model;

import java.util.List;

/*
 * 用户订单实体类
 * 
 * */
public class Order {
	int id;
	int tId;
	int count;
	String openid;
	int flag;
	List<Ticket> tikets;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	
	public Order(int id, int tId, int count, String openid, int flag, List<Ticket> tikets) {
		super();
		this.id = id;
		this.tId = tId;
		this.count = count;
		this.openid = openid;
		this.flag = flag;
		this.tikets = tikets;
	}
	public Order() {}
	@Override
	public String toString() {
		return "Order [id=" + id + ", tId=" + tId + ", count=" + count + ", openid=" + openid + ", flag=" + flag
				+ ", tikets=" + tikets + "]";
	}
	public List<Ticket> getTikets() {
		return tikets;
	}
	public void setTikets(List<Ticket> tikets) {
		this.tikets = tikets;
	}	
	
	
}
