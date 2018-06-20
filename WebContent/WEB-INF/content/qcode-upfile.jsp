<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common-head.jsp" %>
<%@ taglib prefix="s" uri="/struts-tags" %> %>
<title>偏偏爱上牛皮纸</title>
</head>
<body>
<div data-role="page">
	<div data-role="main" class="ui-content">
	
		<form method="post" action="<%=request.getContextPath() %>/upload" enctype="multipart/form-data" data-ajax="false">
		<label for="upload">选择文件</label><input type="file" name="upload"/>
		<abbr>注意:上传的文件不能大于5M,上传后文件只能保存7天</abbr>
		<label for="uuid" class="ui-hidden-accessible">uuid</label><input type="hidden" name="uuid"  value=<%=request.getParameter("uuid") %> />
		<input type="submit" value="上传"/>
		</form>
	</div>
</div>


</body>
</html>