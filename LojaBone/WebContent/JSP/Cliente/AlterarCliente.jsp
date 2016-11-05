<%@page import="br.com.entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração</title>
</head>
<body>
<%
Cliente cliente=(Cliente)request.getAttribute("cliente");
%>
<form action="/LojaBone/cliente" method = "post">
<input type = "hidden" name = "Id" value = "<%=cliente.getIdcliente() %>"/>
<input type = "hidden" name = "acao" value = "alterar" />
<label>Nome:</label> <input type="text" name = "nome" value="<%=cliente.getNome() %>"/><br/>
<label>Idade:</label> <input type="number" name = "idade" value="<%= cliente.getIdade() %>"/><br/>
<label>CPF:</label> <input type="text" name = "cpf" value="<%=cliente.getCPF() %> " /><br/>
<input type="submit" value= "confirmar" />

</form>
</body>
</html>