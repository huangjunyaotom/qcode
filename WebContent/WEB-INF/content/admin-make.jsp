<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/common-head.jsp" %>
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