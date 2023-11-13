<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="classes.*"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
    <jsp:setProperty name="programadorBean" property="idFuncionario" param="idFuncionario" />
	<%
		if(programadorBean.remover()){
 	%>
	     <jsp:forward page="listarProgramadores.jsp"/>
     <%
        } else {
                out.println("<br/>Erro ao excluir programador!");
                out.println("<br/><a href=listarProgramadors.jsp> Voltar para a lista </a>");
        }
      %>

</body>
</html>