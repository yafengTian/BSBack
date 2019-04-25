package model;

public class Collection {
int id;
int tId;
String openid;
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
public String getOpenid() {
	return openid;
}
public void setOpenid(String openid) {
	this.openid = openid;
}
public Collection(int id, int tId, String openid) {
	super();
	this.id = id;
	this.tId = tId;
	this.openid = openid;
}
public Collection() {}
@Override
public String toString() {
	return "Collection [id=" + id + ", tId=" + tId + ", openid=" + openid + "]";
}

}
