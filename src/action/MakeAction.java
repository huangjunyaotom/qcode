package action;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.opensymphony.xwork2.ActionSupport;

import entity.Qcode;

public class MakeAction extends ActionSupport{
	private Integer num;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
	public String execute() {
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session sess=sf.openSession();
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
		sf.close();
		return SUCCESS;
	}
	
//	public static void main(String[] args) {
//		MakeAction ma=new MakeAction();
//		ma.setNum(100);
//		ma.execute();
//	}
}
