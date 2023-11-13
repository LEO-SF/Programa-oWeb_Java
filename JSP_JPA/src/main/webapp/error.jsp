<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1> Descrição do erro: <%=exception%></h1>
         <br/>
         <%exception.printStackTrace(new java.io.PrintWriter(out));%>
         <br>         
         
    </body>
</html>
