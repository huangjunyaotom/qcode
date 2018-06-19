package action.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import service.QcodeService;
@Controller
public class QcodeAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uuid;
	
	private String path;
	@Autowired
	private QcodeService qcodeService;
	
	
	public QcodeService getQcodeService() {
		return qcodeService;
	}


	public void setQcodeService(QcodeService qcodeService) {
		this.qcodeService = qcodeService;
	}


	public QcodeAction() {
		
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
		Map<String,String> map=qcodeService.qcode(uuid);
		setPath(map.get("path"));
		return map.get("result");
		
	}
}
