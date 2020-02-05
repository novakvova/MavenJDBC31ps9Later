import java.util.List;

import org.hibernate.Session;

import entities.Category;
import entities.Post;

public class PostService {
	private Session session;

	public PostService(Session session) {
		super();
		this.session = session;
	}
	
	public Long Add(Category cat, String name) {
		session.beginTransaction();
		Post post = new Post();
		post.setName(name);
		post.setCategory(cat);
		Long id = (Long)session.save(post);
		session.getTransaction().commit();
		return id;
	}
	
	public Post GetById(long id) {
		session.beginTransaction();
		Post post =  (Post)session.get(Post.class, id);
		session.getTransaction().commit();
		return post;
	}
	
	public void Delete(long id) {
		Post post =  this.GetById(id);
		session.beginTransaction();
		session.delete(post);
		session.getTransaction().commit();
	}
	public void Update(long id, Category cat, String name) {
		Post post =  this.GetById(id);
		post.setName(name);
		post.setCategory(cat);
		session.beginTransaction();
		session.update(post);
		session.getTransaction().commit();
	}
	
	public List<Post> GetAll() {
		session.beginTransaction();
		List<Post> posts = session.createQuery("FROM Post").list();
		session.getTransaction().commit();
		return posts;
	}
}
