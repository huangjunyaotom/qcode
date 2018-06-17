package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import entity.Qcode;
@Repository
public class QcodeDaoImpl  implements QcodeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveOrUpdate(Qcode q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().saveOrUpdate(q);
	}



	@Override
	public void delete(Qcode q) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(q);
	}





	@SuppressWarnings("unchecked")
	public List<Qcode> getByAll(String param, Object obj) {
		// TODO Auto-generated method stub
		String hql="from Qcode  where :param = :obj ";
		
		return (List<Qcode>)this.sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("param", param)
				.setParameter("obj", obj)
				.list();
	}

	@Override
	public Qcode getByUuid(String code_no) {
		// TODO Auto-generated method stub
		String hql="from Qcode  where code_no = :obj ";
		
		return (Qcode)this.sessionFactory.getCurrentSession()
				.createQuery(hql)
				.setParameter("obj", code_no)
				.uniqueResult();
	}



	



	

	
	

}
