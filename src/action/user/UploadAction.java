package action.user;

import java.io.File;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.QcodeService;
@Controller
public class UploadAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadFileName;
	private String savePath;
	private String uuid;
	
	@Autowired
	private QcodeService qcodeService;
	
	
	public QcodeService getQcodeService() {
		return qcodeService;
	}


	public void setQcodeService(QcodeService qcodeService) {
		this.qcodeService = qcodeService;
	}
	public UploadAction() {
		
	}

	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
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
			
		return qcodeService.upload(uuid, getSavePath(), uploadFileName, upload);
	}

}
