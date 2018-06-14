package action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

public class QcodeAction extends ActionSupport {
	private String uuid;
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/qcode?useSSL=false";
	private String user="root";
	private String password="";
	private String path;
	
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
		
		
		try {
			
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url,user,password);
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from table_code_id where code_no = "+uuid);
		
		if(rs.next()){
			path=rs.getString("file_path");
			
			if(path != null){
				//转发到展示页面
				
			
				return "show";
				
			}else{
				//转发到上传页面
//				System.out.println("upfile");
				return "upfile";
				
				
			}
		}
		
		}catch(Exception e){
			System.out.println(e);
		}
		return "none";
		
	}
}
