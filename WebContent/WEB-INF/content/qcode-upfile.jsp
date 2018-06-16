<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common-head.jsp" %>
<title>偏偏爱上牛皮纸</title>
</head>
<body>
<div data-role="page">
	<div data-role="main" class="ui-content">
	
		<form method="post" action="<%=request.getContextPath() %>/upload" enctype="multipart/form-data">
		<label for="upload">选择文件</label><input type="file" name="upload"/>
		
		<label for="uuid" class="ui-hidden-accessible">uuid</label><input type="hidden" name="uuid"  value=<%=request.getParameter("uuid") %> />
		<input type="submit" value="上传"/>
		</form>
	</div>
</div>


</body>
</html>