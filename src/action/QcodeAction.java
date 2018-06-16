package action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionSupport;

import dao.QcodeDao;
import entity.Qcode;

public class QcodeAction extends ActionSupport {
	private String uuid;
	
	private String path;
	
	
	private QcodeDao qcodeDao;
	
	public QcodeAction() {
		
	}
	
	public QcodeDao getQcodeDao() {
		return qcodeDao;
	}

	public void setQcodeDao(QcodeDao qcodeDao) {
		this.qcodeDao = qcodeDao;
	}

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
//		Session sess=qcodeDao.getSession();
//		Transaction tx=sess.beginTransaction();
		
		
		Qcode q=qcodeDao.getByUuid(uuid);
			
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
			
//			tx.commit();
//			sess.close();
			return "none";
		
	}
}
