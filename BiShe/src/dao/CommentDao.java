package dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import dao_interface.CommentInf;
import model.Comment;

public class CommentDao implements CommentInf{
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession session;
	private static Reader reader;
	static {
		try {
			reader=Resources.getResourceAsReader("config.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public int comment(int tId,String nickName, String avatarUrl, int start, String time, String content) {
		session=sqlSessionFactory.openSession();
		CommentInf commentInf=session.getMapper(CommentInf.class);
		int success=commentInf.comment(tId,nickName, avatarUrl, start, time, content);
		session.commit();
		return success;
	}

	@Override
	public List<Comment> showComment(int tId) {
		session=sqlSessionFactory.openSession();
		CommentInf commentInf=session.getMapper(CommentInf.class);
		return commentInf.showComment(tId);
	}

}
