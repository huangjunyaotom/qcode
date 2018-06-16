package action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opensymphony.xwork2.ActionSupport;

import dao.QcodeDao;
import entity.Qcode;

public class DownloadAction extends ActionSupport {
	private QcodeDao qcodeDao;
	private String portAndIndex;
	public QcodeDao getQcodeDao() {
		return qcodeDao;
	}

	

	public String getPortAndIndex() {
		return portAndIndex;
	}

	public void setPortAndIndex(String portAndIndex) {
		this.portAndIndex = portAndIndex;
	}

	

	public void setQcodeDao(QcodeDao qcodeDao) {
		this.qcodeDao = qcodeDao;
	}
	public DownloadAction() {
		
	}
	private InputStream excelStream;  //���������  
    private String excelFileName; //�����ļ���  
  
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
		/*
		 * ��ȡδ��ӡ�Ķ���
		 * ���������
		 * д����
		 * 
		 */
		List<Qcode> qcodes=qcodeDao.getUnPrinted();
		
		/*
		 * ����������
		 */
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		int i=0;
		//��ȡip
		InetAddress addr=InetAddress.getLocalHost();
		String ip=addr.getHostAddress().toString();
		
		for(Qcode q:qcodes) {
			
			XSSFRow row = sheet.createRow(i);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue("http://"+ip+portAndIndex+q.getCode_no());
			i++;
		}
		
		ByteArrayOutputStream os = new ByteArrayOutputStream();  
		workbook.write(os);  
        byte[] fileContent = os.toByteArray();  
        ByteArrayInputStream is = new ByteArrayInputStream(fileContent); 
        
        excelStream = is;
        
		excelFileName="address.xlsx";
		for(Qcode q:qcodes) {
			q.setIs_printed(1);
			qcodeDao.update(q);
		}
		
		
		return SUCCESS;
	}
}
