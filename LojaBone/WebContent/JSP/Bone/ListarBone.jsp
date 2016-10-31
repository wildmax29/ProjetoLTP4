<%@page import="java.util.List"%>
<%@page import="br.com.entidade.Bone"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de bones cadastrados</title>
</head>
<body>

<table border="1">
   <tr>
	<td><a>ID Bone</a></td>
	<td><a>Cor</a></td>
	<td><a>Preço</a></td>
	<td><a>Tamanho</a></td>
   </tr>
   <tr>
    <%
    for(Bone bone: (List<Bone>)request.getAttribute("bones")){
    	
      %>
      <td><a><%=bone.getIdbone()%></a>
      <td><a><%=bone.getCor() %></a>
      <td><a><%=bone.getPreco() %></a>
      <td><a><%=bone.getTamanho() %></a>
      <td><a href="/LojaBone/Bone?acao=alterar&id=<%=bone.getIdbone() %>">Alterar</a></td>
      <td><a href="/LojaBone/Bone?acao=deletar&id=<%=bone.getIdbone() %>">Deletar</a></td>
      
      </tr>
      <%
    }
      %>
      
</table>
<input type="button" onclick="location='/LojaBone/JSP/Bone/CadastroBone.jsp'" value = "Cadastro">

</body>
</html>