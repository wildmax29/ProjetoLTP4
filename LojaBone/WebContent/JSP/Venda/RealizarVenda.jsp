<%@page import="br.com.entidade.Bone"%>
<%@page import="java.util.List"%>
<%@ page import="br.com.entidade.Cliente" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Venda Realizada</title>
</head>
<body>
<div align="center">
<h1> REALIZAÇÃO DE VENDAS </h1>
	<form action="/LojaBone/venda?acao=realizaVenda" method="post">
<center>
	Cliente:&nbsp;&nbsp; <select name="idcliente" required="required">
			
				<option value="">Procurar</option>
				<%
				List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
				
				for(Cliente cliente : clientes){
				%>	
				<option value="<%= cliente.getIdcliente()%>"><%= cliente.getNome() %></option>
				<%
				}
				%>
			</select><br><br>
			
	Bone:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select name="id" required="required">
			
				<option value="">Selecione</option>
				<%
				List<Bone> bones = (List<Bone>) request.getAttribute("bones");
				
				for(Bone bone : bones){
				%>	
				<option value="<%= bone.getIdbone()%>"><%= bone.getCor() %></option>
				<%
				}
				%>
			</select><br><br>

	Descrição: <textarea cols=15 rows="5" name="descricao" maxlength="200" wrap="hard" ></textarea>
		
		<input type="hidden" name="acao" value="realizaVenda">
		<BR><BR><BR>
		<input type="Submit" name="enviar" value="Vender" class="myButton2"><p/>
		<input type="reset" value="Limpar" class="myButton2">
	
	</form>
		
		   <p><input type="button" onclick="location='/LojaBone/JSP/Menu.jsp'" value="Menu Principal"><br>
</div>
</center>
</body>
</html>