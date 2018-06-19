package task;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Qcode;

public class Test {

	

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		SessionFactory sf=ac.getBean("sessionFactory",SessionFactory.class);
		
		Session session=sf.openSession();
		
//		Transaction t=session.beginTransaction();
		List<Qcode> qs=(List<Qcode>)session.createQuery("from Qcode where use_time < :date ")
				.setParameter("date", Calendar.getInstance().getTime())
				.list();
		for(Qcode q:qs) {
			System.out.println(q.getUse_time());
		}
	}

}
