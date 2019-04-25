package model;

/*
 * �������ݿ���ȡ�õĶ�����Ϣ��ʽ�����Լ���Ҫ����ʽ
 * */
public class TicketOrder {
	int count;// ������������Ʊ��Ŀ
	int money;// �������ܽ��
	int flag;// ����״̬
	int tId;// ��Ʊid
	String status;// ����״̬
	String ticketName;
	String descration;// ��������
	String image;// ����ͼƬ��url��ַ
	int price;// ��Ʊ����

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public TicketOrder() {
	};
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TicketOrder(int count, int money, int flag, int tId, String ticketName, String descration, String image,
			int price) {
		super();
		this.count = count;
		this.money = money;
		this.flag = flag;
		this.tId = tId;
		this.ticketName = ticketName;
		this.descration = descration;
		this.image = image;
		this.price = price;
	}

	@Override
	public String toString() {
		return "TicketOrder [count=" + count + ", money=" + money + ", flag=" + flag + ", tId=" + tId + ", ticketName="
				+ ticketName + ", descration=" + descration + ", image=" + image + ", price=" + price + "]";
	}

}
