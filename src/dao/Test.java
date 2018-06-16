package dao;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
public static void main(String[] args) throws Exception {
	InetAddress addr=InetAddress.getLocalHost();
	String ip=addr.getHostAddress().toString();
	System.out.println(ip);
}
}
