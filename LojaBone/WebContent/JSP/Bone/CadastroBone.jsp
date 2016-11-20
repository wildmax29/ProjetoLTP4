<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CADASTRO BONE</title>
</head>
<body>
<center>
<h2>CADASTRO BONE</h2>
<form action="/LojaBone/bone" method = "post">
<input type = "hidden" name = "acao" value = "cadastrar" /><p/>
<label>Cor:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text" name = "cor"/><br/><p/>
<label>Preco:&nbsp;&nbsp;&nbsp;&nbsp;</label> <input name = "preco"/><br/><p/>
<label>Tamanho:</label> <input name = "tamanho"/><br/><p/>
<input type="submit" value= "confirmar" />
</form>

<p>
<input type="button" onclick="location='/LojaBone/JSP/Menu.jsp'"value="Menu Principal"><br></div align="center">
</center>

</body>
</html>