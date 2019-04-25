package model;
/*
 * 用户评论实体类
 * */
public class Comment {
	int id;
	int tId;
	String nickName;
	String avatarUrl;
	int start;
	String time;
	String content;
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
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Comment(int id, String nickName, String avatarUrl, int start, String time, String content,int tId) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.avatarUrl = avatarUrl;
		this.start = start;
		this.time = time;
		this.content = content;
		this.tId=tId;
	}
	public Comment() {}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", nickName=" + nickName + ", avatarUrl=" + avatarUrl + ", start=" + start
				+ ", time=" + time + ", content=" + content + "]";
	}
	
}
