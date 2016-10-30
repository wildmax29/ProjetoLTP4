<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CADASTRO CLIENTE</title>
</head>
<body>
<form action="/LojaBone/cliente" method = "post">
<input type = "hidden" name = "acao" value = "cadastrar" />
<label>Nome:</label> <input type="text" name = "nome"/><br/>
<label>Idade:</label> <input type="text" name = "idade"/><br/>
<label>CPF:</label> <input type="text" name = "cpf"/><br/>
<input type="submit" value= "confirmar" />
</form>

</body>
</html>