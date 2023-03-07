package states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import hibernatedemo.Certificate;
import hibernatedemo.Student;


public class StateDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		SessionFactory factory=cfg.buildSessionFactory(builder.build());
		
		
		Student student=new Student();
		student.setId(23);
		student.setName("New name");
		student.setCity("Jaipur");
		student.setCertificate(new Certificate("Hibernate Course","45 hours"));
		
		//Student in Transient State now
		
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(student);
		
		//Student object is now in Persistent state
		
		student.setName("Rohan");// It can update in persistent State
		session.getTransaction().commit();
		
		session.close();
		// Student is now in detached state
		
		student.setName("Sachin"); // It will not update as we have already closed the session and it's in detached state
		factory.close();

	}

}
