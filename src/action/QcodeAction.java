package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.opensymphony.xwork2.ActionSupport;

import entity.Qcode;

public class QcodeAction extends ActionSupport {
	private String uuid;
	
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String execute() {
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		
		Session sess=sf.openSession();
		Transaction tx=sess.beginTransaction();
		
		String hql="from Qcode q where q.code_no = :uuid ";
		Qcode q=(Qcode)sess.createQuery(hql).setParameter("uuid", uuid).uniqueResult();
			
			if(q!=null){
				path=q.getFile_path();
				
				if(path != null && !path.equals("")){
					//转发到展示页面
					
				
					return "show";
					
				}else{
					//转发到上传页面
//					System.out.println("upfile");
					return "upfile";
					
					
				}
			}
			tx.commit();
			sess.close();
			sf.close();
			
			return "none";
		
	}
}
