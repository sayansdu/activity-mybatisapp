package kz.sayan;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class Controller {
	
	public static Blog selectOne(int i) throws IOException{
		SqlSession session =  SessionFactory.getSessionFactory();
		Blog blog;
		try {
			  blog  = session.selectOne("mapper.BlogMapper.selectBlog", i);
			} finally {
			  session.close();
			}
		return blog;
	}
	
	public static List<Blog> selectAll() throws IOException{
		SqlSession session =  SessionFactory.getSessionFactory();
		List<Blog> blogs;
		try {
			  blogs  = session.selectList("mapper.BlogMapper.selectAll");
			} finally {
			  session.close();
			}
		return blogs;
	}
	
	public static void insert(String author, String title, String text) throws IOException{
		SqlSession session =  SessionFactory.getSessionFactory();
		Blog blog = new Blog();
		blog.setAuthor(author);
		blog.setTitle(title);
		blog.setDescription(text);
		
		try {
			 session.insert("mapper.BlogMapper.insert", blog);
			 session.commit();
			} finally {
			  session.close();
			}
		return ;
	}
	
	public static void update(int id, String author, String title, String text) throws IOException{
		SqlSession session =  SessionFactory.getSessionFactory();
		Blog blog = new Blog();
		blog.setId(id);
		blog.setAuthor(author);
		blog.setTitle(title);
		blog.setDescription(text);
		
		try {
			 session.update("mapper.BlogMapper.update", blog);
			 session.commit();
			} finally {
			  session.close();
			}
		return;
	}
}
