<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ACESSO SISTEMA DE COMPRAS DE BONE</title>
</head>
<body>
<center>
<h2>ACESSO AO SISTEMA<br></h2>
<form action="../../LojaBone/Login" method="post">
<input type="hidden" name="acao" value="Logar"/>
<p><td>Usu�rio&nbsp;<input type="text" name="usuario"></td>
<p><td>Senha &nbsp;&nbsp;&nbsp;<input type="password" name="senha"></td>
<p><input type = "submit" value ="login"/>
</center>
</form>

</body>
</html>