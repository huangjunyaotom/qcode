package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Qcode;

public class QcodeDaoImpl  implements QcodeDao {
	
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



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
	@Transactional
	public List<Qcode> getUnPrinted() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession()
				.createQuery("from Qcode where is_printed = '0' ")
				.list();
	}



	@Override
	@Transactional
	public void update(Qcode q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(q);
		
	}

	

	
	

}
