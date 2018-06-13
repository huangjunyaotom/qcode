package qcode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Qcode extends ActionSupport {
	private String uuid;
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/qcode?useSSL=false";
	private String user="root";
	private String password="";
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String execute() {
		
		uuid=getUuid();
		try {
			
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from table_code_id where code_no = "+uuid);
		
		if(rs.next()){
			String path=rs.getString("file_path");
			
			if(path != null){
				//转发到展示页面
				ActionContext acx= ActionContext.getContext();
				acx.put("path",path);
				
			
				return "show";
				
			}else{
				//转发到上传页面
//				System.out.println("upfile");
				return "upfile";
				
				
			}
		}else{
			//不是我们的条码
			return "none";
		}
		
		}catch(Exception e){
			System.out.println(e);
		}
		return "none";
		
	}
}
