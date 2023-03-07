package mappings1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());
		SessionFactory factory = cfg.buildSessionFactory(builder.build());

		// Creating First Employee
		Employee employee = new Employee();
		employee.setEid(1);
		employee.setName("Akshat");

		// Creating Second Employee
		Employee employee2 = new Employee();
		employee2.setEid(2);
		employee2.setName("Nikhil");

		// Creating First Project
		Project project = new Project();
		project.setPid(3);
		project.setPname("Chatbot");

		// Creating Second Project
		Project project2 = new Project();
		project2.setPid(4);
		project2.setPname("Library Management System");

		List<Employee> list1 = new ArrayList<Employee>();
		List<Project> list2 = new ArrayList<Project>();

		list1.add(employee);
		list1.add(employee2);

		list2.add(project);
		list2.add(project2);

		employee.setProjects(list2);
		project2.setEmployees(list1);

		Session session = factory.openSession();

		session.beginTransaction();

		session.save(employee);
		session.save(employee2);
		session.save(project);
		session.save(project2);

		session.getTransaction().commit();

		session.close();

		factory.close();

	}

}
