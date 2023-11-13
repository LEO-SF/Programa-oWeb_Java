<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="classes.*" %>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Usuario</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/css/bootstrap.min.css">
</head>
<body>
    <jsp:useBean id="usuarioBean" class="classes.Usuario" scope="request" />

    <div class="container">
        <%
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            
            boolean autenticado = usuarioBean.login(email, senha);

            if (autenticado == true) {
                response.sendRedirect("menu.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.min.js"></script>
</body>
</html>