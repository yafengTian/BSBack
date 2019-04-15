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
	
	public Ticket(int id, int price, String descration, String image, String introducation) {
		super();
		this.id = id;
		this.price = price;
		this.descration = descration;
		this.image = image;
		this.introducation = introducation;
	}
	public Ticket() {}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", descration=" + descration + ", image=" + image
				+ ", introducation=" + introducation + "]";
	}
	
	
	
	
}
