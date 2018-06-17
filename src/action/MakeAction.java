package action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.QcodeService;
@Controller
public class MakeAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer num;
	@Autowired
	private QcodeService qcodeService;

	public QcodeService getQcodeService() {
		return qcodeService;
	}


	public void setQcodeService(QcodeService qcodeService) {
		this.qcodeService = qcodeService;
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

		return qcodeService.makeQcode(num);
	}
	
}
