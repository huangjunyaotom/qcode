<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="s" uri="/struts-tags" %> %>
<!DOCTYPE html5>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>偏偏爱上牛皮纸</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath() %>/admin">
<label for="username">用户名:</label><input type="text" name="username"/>
<label for="passwird">密码:</label><input type="password" name="password"/>
<input type="submit" value="登录"/>
<%
String tip=(String)request.getAttribute("tip");
if(tip !=null){
	out.println(tip);
}
%>
</form>
</body>
</html>