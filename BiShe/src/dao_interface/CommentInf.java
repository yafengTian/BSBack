package dao_interface;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CommentInf {
	/*
	 * �û���ĳ��������
	 * */
	public int comment(@Param("tId")int tId,@Param("nickName")String nickName,@Param("avatarUrl")String avatarUrl,@Param("start")int start,@Param("time")String time,@Param("content")String content);
	
	/*
	 *��ʾ�û������� 
	 * */
	public List<model.Comment> showComment(int tId);
}
