package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommentInf {
	/*
	 * 用户对某景区评价
	 * */
	public int comment(@Param("tId")int tId,@Param("nickName")String nickName,@Param("avatarUrl")String avatarUrl,@Param("start")int start,@Param("time")String time,@Param("content")String content);
	
	/*
	 *显示用户的评价 
	 * */
	public List<model.Comment> showComment(int tId);
}
