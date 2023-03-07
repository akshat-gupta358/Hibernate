package hibernatedemo;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class EmbeddDemo {

	public static void main(String[] args)  {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory factory=cfg.buildSessionFactory(builder.build());
		
		Student student1=new Student();
		student1.setId(455);
		student1.setName("Shivam");
		student1.setCity("Punjab");
		
		Certificate certi=new Certificate();
		certi.setCourse("Java Course");
		certi.setDuration("20 Hours");
		student1.setCertificate(certi);
		
		
		Student student2=new Student();
		student2.setId(234);
		student2.setName("Bhuvnesh");
		student2.setCity("Himachal");
		
		Certificate certi1=new Certificate();
		certi1.setCourse("Python Course");
		certi1.setDuration("27 Hours");
		student2.setCertificate(certi1);
		
		
		
		Session session=factory.openSession();
		
		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		
		session.close();
		factory.close();
		

	}

}
