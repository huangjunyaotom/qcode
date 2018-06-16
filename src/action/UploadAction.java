package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionSupport;

import dao.QcodeDao;
import entity.Qcode;

public class UploadAction extends ActionSupport{
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String uuid;
	
	private QcodeDao qcodeDao;
	public QcodeDao getQcodeDao() {
		return qcodeDao;
	}

	public void setQcodeDao(QcodeDao qcodeDao) {
		this.qcodeDao = qcodeDao;
	}
	public UploadAction() {
		
	}

	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() throws Exception {
		
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	@Override
	public String execute() throws Exception {
		setSavePath("/uploadFile");
		String realPath=getSavePath()+File.separator+getUuid()+"."+getUploadFileName().split("\\.")[1];
		
		
		FileOutputStream os=new FileOutputStream(realPath);
		
		
		FileInputStream is=new FileInputStream(getUpload());
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=is.read(buffer))>0) {
			os.write(buffer, 0, len);
		}
		
//		Session sess=qcodeDao.getSession();
//		Transaction tx=sess.beginTransaction();
		
		
		Qcode q= qcodeDao.getByUuid(uuid);
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		q.setFile_path(realPath);
		q.setUse_time(d);
		qcodeDao.updateFilePathByUuid(q);
		
//		tx.commit();
//		sess.close();
		
		
		
		return SUCCESS;
	}

}
