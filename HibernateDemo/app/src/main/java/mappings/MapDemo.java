package mappings;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());
		SessionFactory factory = cfg.buildSessionFactory(builder.build());

		// Creating Question
		Question question = new Question();
		question.setQuestionId(1);
		question.setQuestion("What is Java");

		// Creating Answer
		Answer answer = new Answer();
		answer.setAnswerId(24);
		answer.setAnswer("Java is a Programming Language");
		answer.setQuestion(question);

		// Creating Answer
		Answer answer1 = new Answer();
		answer1.setAnswerId(45);
		answer1.setAnswer("Java is an Object Oriented Programming Language");
		answer1.setQuestion(question);

		// Creating Answer
		Answer answer2 = new Answer();
		answer2.setAnswerId(67);
		answer2.setAnswer("We can make web applications through Java");
		answer2.setQuestion(question);
		
		
		//Creating List of answers
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(answer);
		list.add(answer1);
		list.add(answer2);
		
		question.setAnswers(list);

//		question.setAnswer(answer);

		// Creating Question
//		Question question1 = new Question();
//		question1.setQuestionId(2);
//		question1.setQuestion("What is API");

		// Creating Answer
//		Answer answer1 = new Answer();
//		answer1.setAnswerId(45);
//		answer1.setAnswer("API is Application Programming Interface");

//		question1.setAnswer(answer1);
//		answer1.setQuestion(question1);
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(question);
//		session.save(question1);

		session.save(answer);
		session.save(answer1);
		session.save(answer2);
		session.getTransaction().commit();

		// Fetching details
//		Question newQuestion = (Question) session.get(Question.class, 1);
//		System.out.println(newQuestion.getQuestion() + " : " + newQuestion.getAnswer().getAnswer());
		
		
		//Fetching Details of ManyToOne
		Question q=(Question) session.get(Question.class, 1);
		System.out.println(q.getQuestion()+": ");
		
		//Lazy Loading when you'll call answers then it'll fetch answers
		System.out.println(q.getAnswers().size());
		
		
//		for(Answer a:q.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}
		session.close();
		factory.close();

	}

}
