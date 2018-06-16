package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Qcode;

public class QcodeDaoImpl  implements QcodeDao {
	
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

//	public Session getSession() {
//		// TODO Auto-generated method stub
////		ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
////        SessionFactory sessionFactory = (SessionFactory)ctx.getBean("sessionFactory");
////		Session session=getSessionFactory().getCurrentSession();
////		if(session==null) {
////			session=getSessionFactory().openSession();
////		}
//		return getSessionFactory().getCurrentSession();
//	}

	@Override
	@Transactional(readOnly=true)
	public Qcode getByUuid(String uuid) {
		// TODO Auto-generated method stub
		String hql="from Qcode q where q.code_no = :uuid ";
		
		return (Qcode)this.sessionFactory.getCurrentSession()
				.createQuery(hql).setParameter("uuid", uuid).uniqueResult();
	}

	@Override
	@Transactional
	public void deleteByUuid(Qcode q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(q);
	}

	@Override
	@Transactional
	public void updateFilePathByUuid(Qcode q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(q);
	}

	@Override
	@Transactional
	public void save(Qcode q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(q);
	}

	@Override
	public Session getSession() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession();
	}

}
