<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>偏偏爱上牛皮纸</title>
</head>
<body>

<%
//获取数据库配置
String driver=application.getInitParameter("driver");
String url=application.getInitParameter("url");
String user=application.getInitParameter("user");
String password=application.getInitParameter("password");

//获取请求的uuid
String uuid=request.getParameter("uuid");


//查询数据库
Class.forName(driver);
Connection conn=DriverManager.getConnection(url,user,password);
Statement stmt=conn.createStatement();
ResultSet rs=stmt.executeQuery("select * from table_code_id where code_no = "+uuid);
if(rs.next()){
	String path=rs.getString("file_path");
	
	if(path != null){
		//转发到展示页面
		request.setAttribute("path",path);
	
		request.getRequestDispatcher("jsp/show.jsp").forward(request,response);
		
	}else{
		//转发到上传页面
		request.getRequestDispatcher("jsp/upFile.jsp").forward(request,response);
		
		
	}
}else{
	//不是我们的条码
	response.sendRedirect("jsp/none.jsp");
}
conn.close();
%>
</body>
</html>