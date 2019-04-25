package model;
public class Address {
		 int id;
		 String username;
		 String phonenumber;
		 String area;
		 String address;
		 int moren;
		 String openid;
	    public void setUsername(String username) {
	         this.username = username;
	     }
	     public String getUsername() {
	         return username;
	     }

	    public void setPhonenumber(String phonenumber) {
	         this.phonenumber = phonenumber;
	     }
	     public String getPhonenumber() {
	         return phonenumber;
	     }

	    public void setArea(String area) {
	         this.area = area;
	     }
	     public String getArea() {
	         return area;
	     }

	    public void setAddress(String address) {
	         this.address = address;
	     }
	     public String getAddress() {
	         return address;
	     }
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public int getMoren() {
			return moren;
		}
		public void setMoren(int moren) {
			this.moren = moren;
		}
		
		public Address(int id, String openid, int moren, String username, String phonenumber,String area,
				String address) {
			super();
			this.id = id;
			this.openid = openid;
			this.moren = moren;
			this.username = username;
			this.phonenumber = phonenumber;
			this.area = area;
			this.address = address;
		}
		@Override
		public String toString() {
			return "Address [id=" + id + ", openid=" + openid + ", moren=" + moren + ", username=" + username
					+ ", phonenumber=" + phonenumber + ", area=" + area + ", address=" + address + "]";
		}
	     

}
