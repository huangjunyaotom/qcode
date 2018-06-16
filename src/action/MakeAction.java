package action;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionSupport;

import dao.QcodeDao;
import entity.Qcode;

public class MakeAction extends ActionSupport{
	private Integer num;
	
	
	
	private QcodeDao qcodeDao;
	public QcodeDao getQcodeDao() {
		return qcodeDao;
	}

	public void setQcodeDao(QcodeDao qcodeDao) {
		this.qcodeDao = qcodeDao;
	}

	public MakeAction() {
		
	}

	
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String execute() {
		Session sess=qcodeDao.getSession();
		Transaction tx=sess.beginTransaction();
		
		for(int i=0;i<num;i++) {
			Qcode q=new Qcode();
			String uuid=UUID.randomUUID().toString().replace("-", "");
			q.setCode_no(uuid);
			qcodeDao.save(q);
			if(i%20==0) {
				sess.flush();
				sess.clear();
			}
		}
		
		tx.commit();
		sess.close();
		
		return SUCCESS;
	}
	
}
