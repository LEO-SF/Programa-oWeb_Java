<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="classes.Programador"%>
<%@page errorPage="error.jsp"%>
<!-- outras definições -->
<body>
<jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
<jsp:setProperty name="programadorBean" property="*" />
<%
if (programadorBean.salvar()) {
%>
<jsp:forward page="cadSucesso.jsp"/>
<%
} else {%>
<jsp:forward page="error.jsp"/>
<%}%>
</body>
</html>