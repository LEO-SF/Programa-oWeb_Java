<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.*"%>
<%@page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirma��o de Edi��o</title>
    </head>
    <body>    
        <jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
        <jsp:setProperty name="programadorBean" property="*" /> 
        <%
           
            if (programadorBean.atualizar()) {
         %>
            <jsp:forward page="listarProgramadores.jsp"/>
        <%}else {%>
             <jsp:forward page="error.jsp"/>
        <%}%>
    </body>
</html>
