package model;

/*
 * 门票实体类
 * */
public class Ticket {
	int id;
	int price;
	String descration;
	String image;
	String introducation;
	String ticketName;
	int catagory;
	String address;
	int saleCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescration() {
		return descration;
	}
	public void setDescration(String descration) {
		this.descration = descration;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getIntroducation() {
		return introducation;
	}
	public void setIntroducation(String introducation) {
		this.introducation = introducation;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public int getCatagory() {
		return catagory;
	}
	public void setCatagory(int catagory) {
		this.catagory = catagory;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	public Ticket(int id, int price, String descration, String image, String introducation, String ticketName,
			int catagory, String address, int saleCount) {
		super();
		this.id = id;
		this.price = price;
		this.descration = descration;
		this.image = image;
		this.introducation = introducation;
		this.ticketName = ticketName;
		this.catagory = catagory;
		this.address = address;
		this.saleCount = saleCount;
	}
	public Ticket() {}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", descration=" + descration + ", image=" + image
				+ ", introducation=" + introducation + ", ticketName=" + ticketName + ", catagory=" + catagory
				+ ", address=" + address + ", saleCount=" + saleCount + "]";
	}
	
	
}
