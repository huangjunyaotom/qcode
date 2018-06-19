package action.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.QcodeService;
@Controller
public class AdminAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String tip;
	@Autowired
	private QcodeService qcodeService;
	
	public QcodeService getQcodeService() {
		return qcodeService;
	}
	public void setQcodeService(QcodeService qcodeService) {
		this.qcodeService = qcodeService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	
	@Override
	public String execute() {
		String result=qcodeService.admin(username, password);
		if(result.equals("wrong")) {
			this.setTip("登录名或密码错误");
		}
		return result;
	
		
	}
}
