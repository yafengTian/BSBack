package model;
/*
 * 
 *openid: getApp().globalData.openid,
 *nickName: e.detail.userInfo.nickName,
 *avatarUrl: e.detail.userInfo.avatarUrl,
 *province: e.detail.userInfo.province,
 *city: e.detail.userInfo.city
 * */
public class UserInfo {
	int id;
	String openid;
	String nickName;
	String avatarUrl;
	String province;
	String city;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public UserInfo(int id, String openid, String nickName, String avatarUrl, String province, String city) {
		super();
		this.id = id;
		this.openid = openid;
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
		this.province = province;
		this.city = city;
	}
	public UserInfo() {}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", openid=" + openid + ", nickName=" + nickName + ", avatarUrl=" + avatarUrl
				+ ", province=" + province + ", city=" + city + "]";
	}
	
}
