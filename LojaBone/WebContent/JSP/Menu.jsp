<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
</head>
<body>

<center>
<h2>MENU</h2>
	<h1>Cliente</h1><p>
	<a href="../../LojaBone/JSP/Cliente/Cadastro.jsp"> CadastroCliente</a><br/>
	<a href="/LojaBone/cliente?acao=Listar">Listar clientes</a><br/>
	<h1>Bone</h1><p>
	<a href="../../LojaBone/JSP/Bone/CadastroBone.jsp"> CadastroBone</a><br/>
	<a href="/LojaBone/bone?acao=Listar">Listar bones</a><br/>
	<h1>Vendas</h1><p>
	<a href="/LojaBone/venda?acao=vender"> Cadastrar Nova Venda</a><br/>
	<a href="/LojaBone/venda?acao=listar"> Listar Vendas</a><br/>
	<input type="button" onclick="location='/LojaBone/Login'" value = "Logout"><p>

	</center>

</body>
</html>