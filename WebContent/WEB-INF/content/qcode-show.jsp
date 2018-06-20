<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common-head.jsp" %>
<title>偏偏爱上牛皮纸</title>
</head>
<body>
<%
   
String basePath = request.getScheme()+"://"+request.getServerName()+":"+
                request.getServerPort()+request.getContextPath()+"/";
String file_path=basePath+"uploadFile/"+request.getAttribute("path");
%>
<audio src="<%=file_path%>" controls="controls">
</audio>

</body>
</html>