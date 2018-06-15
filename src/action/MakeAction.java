package action;

import java.util.UUID;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

import entity.Qcode;

public class MakeAction extends ActionSupport{
	private Integer num;
	
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String execute() {
		
		sessionFactory=new ClassPathXmlApplicationContext("classpath:applicationContext.xml").getBean("sessionFactory",SessionFactory.class);;
		
		Session sess=sessionFactory.openSession();
		Transaction tx=sess.beginTransaction();
		
		for(int i=0;i<num;i++) {
			Qcode q=new Qcode();
			String uuid=UUID.randomUUID().toString().replace("-", "");
			q.setCode_no(uuid);
			sess.save(q);
			if(i%20==0) {
				sess.flush();
				sess.clear();
			}
		}
		
		tx.commit();
		sess.close();
		sessionFactory.close();
		return SUCCESS;
	}
	
//	public static void main(String[] args) {
//		MakeAction ma=new MakeAction();
//		ma.setNum(100);
//		ma.execute();
//	}
}
