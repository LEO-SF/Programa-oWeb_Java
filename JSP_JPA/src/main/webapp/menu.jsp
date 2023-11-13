<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="menu">
            <h1 class="text-center mb-4">Menu</h1>
            <ul class="list-unstyled">
                <li class="text-center mb-4"><a href="adicionarProg.jsp" class="btn btn-primary">Cadastrar Programador</a></li>
                <li class="text-center mb-4"><a href="listarProgramadores.jsp" class="btn btn-primary">Listar Programadores</a></li>
            </ul>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.min.js"></script>
</body>
</html>