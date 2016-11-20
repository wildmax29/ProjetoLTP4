<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CADASTRO CLIENTE</title>
</head>
<body>
<center>
<h2>CADASTRO DE CLIENTE</h2><br/>
<form action="/LojaBone/cliente" method = "post">
<input type = "hidden" name = "acao" value = "cadastrar" />
<label>Nome:&nbsp;</label> <input type="text" name = "nome"/><br><p>
<label>Idade:&nbsp;</label> <input type="number" name = "idade"/><br><p>
<label>CPF:&nbsp;&nbsp;</label> <input type="text" name = "cpf"/><br><p>
<input type="submit" value= "confirmar" />
</form>
<p>
<input type="button" onclick="location='/LojaBone/JSP/Menu.jsp'"value="Menu Principal"><br></div align="center">
</center>

</body>
</html>