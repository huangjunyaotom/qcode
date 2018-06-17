package action;

import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import service.QcodeService;
@Controller
public class DownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String portAndIndex;
	@Autowired
	private QcodeService qcodeService;

	public QcodeService getQcodeService() {
		return qcodeService;
	}


	public void setQcodeService(QcodeService qcodeService) {
		this.qcodeService = qcodeService;
	}
	
	public String getPortAndIndex() {
		return portAndIndex;
	}

	public void setPortAndIndex(String portAndIndex) {
		this.portAndIndex = portAndIndex;
	}
	
	public DownloadAction() {
		
	}
	private InputStream excelStream;  
    private String excelFileName; 
  
    public InputStream getExcelStream() {  
        return excelStream;  
    }  
    public void setExcelStream(InputStream excelStream) {  
        this.excelStream = excelStream;  
    }  
    public String getExcelFileName() {  
        return excelFileName;  
    }  
    public void setExcelFileName(String excelFileName) {  
        this.excelFileName = excelFileName;  
    } 
    
    
	public String execute() throws Exception {
		Map<String,Object> map=qcodeService.download(portAndIndex);
		setExcelStream((InputStream)map.get("excelStream"));
		setExcelFileName((String)map.get("excelFileName"));
		return (String)map.get("result");
	}
}
