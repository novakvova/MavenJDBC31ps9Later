import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import entities.Category;
import entities.Post;

public class MainApp {
	private static SessionFactory sessionFactory=null;
	
	public static void main(String[] args) {
		
		//System.out.println("Hello");
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			System.out.println("-----Connection succes------");
			Session session = sessionFactory.openSession();
//			CategoryService cs = new CategoryService(session);
//			Long id = cs.Add("Hello");
//			List<Category> list = cs.GetAll();
//			System.out.println("----Add list------");
//			for (Category category : list) {
//				System.out.println(category);
//			}
//			
//			cs.Delete(id);
//			System.out.println("----Remove by id list------");
//			list = cs.GetAll();
//			for (Category category : list) {
//				System.out.println(category);
//			}
		
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
}
