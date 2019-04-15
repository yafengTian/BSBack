package model;

public class LoginFlag {
	int id;
	int userId;
	int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public LoginFlag(int id, int userId, int flag) {
		super();
		this.id = id;
		this.userId = userId;
		this.flag = flag;
	}
	public LoginFlag() {}
	@Override
	public String toString() {
		return "LoginFlag [id=" + id + ", userId=" + userId + ", flag=" + flag + "]";
	}
	
}
