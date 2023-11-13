<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="classes.*" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Programadores</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <jsp:useBean id="programadorBean" class="classes.Programador" scope="request" />
        <%
            List<Programador> lista = programadorBean.buscarTodosProg();
            request.setAttribute("listaReq", lista);
        %>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">Nome</th>
                    <th scope="col">Endereço</th>
                    <th scope="col">E-mail</th>
                    <th scope="col">Salário</th>
                    <th scope="col">CPF</th>
                    <th scope="col">Linguagem</th>
                    <th scope="col">Projetos</th>
                    <th scope="col">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="programador" items="${listaReq}">
                    <tr>
                        <td>${programador.getNome()}</td>
                        <td>${programador.getEndereco()}</td>
                        <td>${programador.getEmail()}</td>
                        <td>${programador.getSalario()}</td>
                        <td>${programador.getCpf()}</td>
                        <td>${programador.getLinguagem()}</td>
                        <td>${programador.getProjetos()}</td>
                        <td>
                            <a href="excluirProgramador.jsp?idFuncionario=${programador.getIdFuncionario()}" class="btn btn-danger">Excluir</a>
                            <a href="editarProgramador.jsp?idFuncionario=${programador.getIdFuncionario()}" class="btn btn-primary">Editar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>
        <a href="menu.jsp" class="btn btn-secondary">Voltar</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.min.js"></script>
</body>
</html>
