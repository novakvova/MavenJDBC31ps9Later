import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Test;

import entities.Bottle;

public class TestWorkDatabase {
	@Test
    public void crud() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		SessionFactory sessionFactory = new MetadataSources( registry )
				.buildMetadata().buildSessionFactory();
		
        Session session = sessionFactory.openSession();
        //запускаем тест, в случае если список expected и actual не будут равны
        //тест будет провален, о результатах теста читаем в консоли
        
        create(session);
        create(session);
        create(session);
        long count= count(session);
        Assert.assertEquals(count, 3);
        
        session.close();
	}
	
	private void create(Session session) {
        System.out.println("Creating car records...");
        Bottle bottle = new Bottle();
        bottle.setName("Зубровка");
        bottle.setPrice(50.12);
         
        session.beginTransaction();
        session.save(bottle);
        session.getTransaction().commit();
    }
	private long count(Session session)
	{
		long count = (Long)session.createQuery("select count(*) from Bottle").uniqueResult();
		return count;
	}
	
	
}
