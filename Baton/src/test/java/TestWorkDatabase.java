import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Test;

import entities.Bottle;
import entities.MarksDetail;
import entities.Student;

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
        
        
        session.beginTransaction();
        
        Student studentObj = new Student("Java", "Geek",  "javageek@javacodegeeks.com", "0123456789");
        session.save(studentObj);

        //Set<MarksDetail> itemsSet = new HashSet<MarksDetail>();
        
        MarksDetail marksObj1 = new MarksDetail("English", "100", "90",  "Pass");  
        marksObj1.setStudent(studentObj);
        session.save(marksObj1);
        
        MarksDetail marksObj2 = new MarksDetail("Maths", "100", "99",  "Pass");  
        marksObj2.setStudent(studentObj);
        session.save(marksObj2);

        MarksDetail marksObj3 = new MarksDetail("Science", "100", "94",  "Pass");  
        marksObj3.setStudent(studentObj);
        session.save(marksObj3);
        // Committing The Transactions To The Database
        session.getTransaction().commit();

        
        
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
