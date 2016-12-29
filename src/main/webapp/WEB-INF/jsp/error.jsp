<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>服务器端出现异常</h2>
<%
	request.getAttribute("status");
%>
<div style="display:none;">
	<input id="status" type="text" value='<%=request.getAttribute("status")%>' />
	<input id="exception" type="text" value='<%=request.getAttribute("exception")%>'/>
</div>
</body>
</html>
