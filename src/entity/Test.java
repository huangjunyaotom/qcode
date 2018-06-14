package entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		
		String hql=" delete Qcode q where q.id > 10";
		sess.createQuery(hql).executeUpdate();
		tx.commit();
		sess.close();
		sf.close();
	}

}
