<%@page import="java.util.List"%>
<%@page import="br.com.entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de clientes cadastrados</title>
</head>
<body>
<center>
<h2>LISTA DE CLIENTES</h2><p>
<table border="1">
   <tr>
	<td><a>ID Cliente</a></td>
	<td><a>Nome</a></td>
	<td><a>Idade</a></td>
	<td><a>CPF</a></td>
   </tr>
   <tr>
    <%
    for(Cliente cliente: (List<Cliente>)request.getAttribute("clientes")){
    	
      %>
      <td><a><%=cliente.getIdcliente()%></a>
      <td><a><%=cliente.getNome() %></a>
      <td><a><%=cliente.getIdade() %></a>
      <td><a><%=cliente.getCPF() %></a>
      <td><a href="/LojaBone/cliente?acao=consultar&id=<%=cliente.getIdcliente() %>"><font color="Blue"><b>Alterar</a></td>
      <td><a href="/LojaBone/cliente?acao=deletar&id=<%=cliente.getIdcliente() %>"><font color="Blue"><b>Deletar</a></td>
      
      </tr>
      <%
    }
      %>
      
</table>
</br>
<input type="button" onclick="location='/LojaBone/JSP/Cliente/Cadastro.jsp'" value = "Cadastro"><p>
<input type="button" onclick="location='../../LojaBone/JSP/Menu.jsp'" value="Menu Principal"><br></div align="center">

</center>
</body>
</html>