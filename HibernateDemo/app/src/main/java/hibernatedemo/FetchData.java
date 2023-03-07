package hibernatedemo;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {
		// Get and Load 
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		SessionFactory factory=cfg.buildSessionFactory(builder.build());
		
		Session session=factory.openSession();
		//Get from Studentdetails of id=52
		
		Student student=(Student) session.get(Student.class,52);
		System.out.println(student);
		session.close();
		factory.close();
	}

}
