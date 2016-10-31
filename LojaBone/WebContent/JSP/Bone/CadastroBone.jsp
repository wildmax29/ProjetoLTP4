<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CADASTRO BONE</title>
</head>
<body>
<form action="/LojaBone/bone" method = "post">
<input type = "hidden" name = "acao" value = "cadastrar" />
<label>Cor:</label> <input type="text" name = "cor"/><br/>
<label>Preco:</label> <input type="number" name = "preco"/><br/>
<label>Tamanho:</label> <input type="number" name = "tamanho"/><br/>
<input type="submit" value= "confirmar" />
</form>

</body>
</html>