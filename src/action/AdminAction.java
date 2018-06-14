package action;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private String username;
	private String password;
	private String tip;
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
		if(getUsername() == null ||getPassword()==null ) {
			return "wrong";
		}
		if(getUsername().equals("albbjiangxiaohua")&& getPassword().equals("123456")) {
			return "make";
		}else{
			setTip("µÇÂ¼Ãû»òÕßÃÜÂë´íÎó");
			return "wrong";
		}
	
		
	}
}
