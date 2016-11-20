<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro</title>
</head>
<body>
	<center>
		<%String msg= (String)request.getAttribute("msg");%>
		<%=msg %></p>
	

		<input type="button" onclick="location='/LojaBone/JSP/Menu.jsp'" value = "Voltar para o Menu"><p>
	</center>
</body>
</html>