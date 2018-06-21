package task;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import entity.Qcode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		SessionFactory sf=ac.getBean("sessionFactory",SessionFactory.class);
		Session s=sf.openSession();
		
		CriteriaBuilder cb=s.getCriteriaBuilder();
		CriteriaQuery<Qcode> cq=cb.createQuery(Qcode.class);
		
		Root<Qcode> root=cq.from(Qcode.class);
		String[] params= {"code_no","1aa545ec5e584d4dac7164d2e4cb798a"};
		Predicate p=cb.equal(root.get(params[0]), params[1]);
		cq.where(p);
		TypedQuery<Qcode> typedQuery = s.createQuery(cq);
		
		Qcode q=typedQuery.getSingleResult();
//		Qcode q=(Qcode)s.createCriteria(Qcode.class)
//				.add(Restrictions.eq("code_no", "1aa545ec5e584d4dac7164d2e4cb798a"))
//				.uniqueResult();
		System.out.println(q.getFile_path());		
	}

}
