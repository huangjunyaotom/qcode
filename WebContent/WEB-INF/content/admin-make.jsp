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
<form method="post" action="<%=request.getContextPath() %>/make">
<label for="num">输入数量:</label><input name="num" />
<input type="submit" value="生成"/>
</form>
<hr/>

</body>
</html>