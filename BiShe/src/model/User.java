package model;

public class User {

	int id;
	String userName;
	String password;
	String openid;//微信用户是否存在的唯一标识
	String nickName;
	String phoneNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public User(int id, String userName, String password, String openid, String nickName, String phoneNumber) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.openid = openid;
		this.nickName = nickName;
		this.phoneNumber = phoneNumber;
	}
	public User() {}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", openid=" + openid
				+ ", nickName=" + nickName + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
