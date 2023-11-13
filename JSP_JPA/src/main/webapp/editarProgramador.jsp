<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="classes.*"%>
<%@page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar Pessoa</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <jsp:useBean id="programadorBean" class="classes.Programador" scope="request"/>
        <jsp:setProperty name="programadorBean" property="idFuncionario" param="idFuncionario" />
        <%  
            Programador programador = programadorBean.buscarID(); 
            String id = String.valueOf(programadorBean.getIdFuncionario());	
        %>

        <h1>Editar Usuário</h1>
        <form method="POST" action="direcionaEdit.jsp">
            <input type="hidden" name="idFuncionario" value="<%=id%>"/>

            <div class="mb-3">
                <label for="nome" class="form-label">Nome:</label>
                <input type="text" id="nome" name="nome" value="<%=programador.getNome()%>" class="form-control">
            </div>

            <div class="mb-3">
                <label for="endereco" class="form-label">Endereço:</label>
                <input type="text" id="endereco" name="endereco" value="<%=programador.getEndereco()%>" class="form-control">
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" id="email" name="email" value="<%=programador.getEmail()%>" class="form-control">
            </div>

            <div class="mb-3">
                 <label for="salario" class="form-label">Salário:</label>
                 <input type="number" id="salario" name="salario" value="<%=programador.getSalario()%>" step="0.01" class="form-control">
           </div>

            <div class="mb-3">
                <label for="cpf" class="form-label">CPF:</label>
                <input type="text" id="cpf" name="cpf" value="<%=programador.getCpf()%>" class="form-control">
            </div>

            <div class="mb-3">
                <label for="linguagem" class="form-label">Linguagem de Programação:</label>
                <input type="text" id="linguagem" name="linguagem" value="<%=programador.getLinguagem()%>" class="form-control">
            </div>

            <div class="mb-3">
                <label for="projetos" class="form-label">Projetos:</label>
                <input type="text" id="projetos" name="projetos" value="<%=programador.getProjetos()%>" class="form-control">
            </div>

            <input type="submit" value="Atualizar" class="btn btn-primary">
            <a href="listarProgramadores.jsp" class="btn btn-secondary">Voltar</a>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/js/bootstrap.min.js"></script>
</body>
</html>