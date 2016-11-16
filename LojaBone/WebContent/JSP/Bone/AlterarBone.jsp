<%@page import="br.com.entidade.Bone"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alteração ou exclusão</title>
</head>
<body>
<%
Bone bone=(Bone)request.getAttribute("bone");
%>
<form action="/LojaBone/bone" method = "post">
<input type = "hidden" name = "idbone" value = "<%=bone.getIdbone() %>"/>
<input type = "hidden" name = "acao" value = "alterar" />
<label>Cor:</label> <input type="text" name = "cor" value="<%=bone.getCor() %>"/><br/>
<label>Preco:</label> <input type="number" name = "preco" value="<%= bone.getPreco() %>"/><br/>
<label>Tamanho:</label> <input type="text" name = "tamanho" value="<%=bone.getTamanho() %> " /><br/>
<input type="submit" value= "confirmar" />

</form>
</body>
</html>