package service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.QcodeDao;
import entity.Qcode;

@Service
public class QcodeServiceImpl implements QcodeService{
	@Autowired
	private QcodeDao qcodeDao;
	
	public void setQcodeDao(QcodeDao qcodeDao) {
		this.qcodeDao = qcodeDao;
	}
	@Override
	@Transactional
	public String admin(String username, String password) {
		// TODO Auto-generated method stub
		if(username == null ||password==null ) {
			return "wrong";
		}
		if(username.equals("albbjiangxiaohua")&& password.equals("123456")) {
			return "make";
		}else{
			
			return "wrong";
		}
	}
	@Override
	@Transactional
	public String makeQcode(Integer num) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<num;i++) {
			Qcode q=new Qcode();
			String uuid=UUID.randomUUID().toString().replace("-", "");
			q.setCode_no(uuid);
			q.setIs_printed(0);
			qcodeDao.saveOrUpdate(q);
			
		}
		return "success";
	}
	@Override
	@Transactional
	public Map<String, String> qcode(String uuid) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String,String>();
		Qcode q=qcodeDao.getByUuid(uuid);
		String path=null;
		if(q!=null){
			path=q.getFile_path();
			
			if(path != null && !path.equals("")){
				File file=new File(path);
				path=file.getName();
				map.put("result", "show");
				map.put("path",path);
				
			}else{
				map.put("result", "upfile");	
				
			}
		}else {
			map.put("result", "none");	
		}
			
		return map;
	}
	@Override
	@Transactional
	public String upload(String uuid, String savePath, String uploadFileName, File upload) throws Exception {
		// TODO Auto-generated method stub
		String realPath=savePath+File.separator+uuid+"."+uploadFileName.split("\\.")[1];
		
		
		FileOutputStream os=new FileOutputStream(realPath);
		
		FileInputStream is=new FileInputStream(upload);
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=is.read(buffer))>0) {
			os.write(buffer, 0, len);
		}
			
		
		Qcode q=qcodeDao.getByUuid(uuid);
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		q.setFile_path(realPath);
		q.setUse_time(d);
		qcodeDao.saveOrUpdate(q);
		
		
		return "success";
	}
	@Override
	@Transactional
	public Map<String, Object> download(String portAndIndex) throws Exception{
		// TODO Auto-generated method stub
		
		Map<String,Object> map=new HashMap<String,Object>();
		List<Qcode> qcodes=qcodeDao.getByAll("is_printed", 0);
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		int i=0;
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
        map.put("excelStream", is);
        map.put("excelFileName", "address.xlsx");
        map.put("result","success");
		for(Qcode q:qcodes) {
			q.setIs_printed(1);
			qcodeDao.saveOrUpdate(q);
		}
		
		return map;
	}

}
