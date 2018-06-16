package dao;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
public static void main(String[] args) throws Exception {
	XSSFWorkbook workbook = new XSSFWorkbook();
    //新建工作表
    XSSFSheet sheet = workbook.createSheet("hello");
    //创建行,行号作为参数传递给createRow()方法,第一行从0开始计算
    
	
	for(int i=0;i<10;i++) {
		XSSFRow row = sheet.createRow(i);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("0000");
		
	}
    //输出到磁盘中
    FileOutputStream fos = new FileOutputStream(new File("d:\\11.xlsx"));
    workbook.write(fos);
    workbook.close();
    fos.close();	

}
}
