<%@page import="br.com.entidade.Venda"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LISTA</title>
</head>
<body>
<div align="center">
	<div id='imprimir' align="center">
		<br>

		<h1>VENDAS REALIZADAS</h1>


		<table border="1">
			<tr>
				<div align="center">
					<td><b>Numero da Venda</td> <a><td><b>Nome cliente</td></a> <a><td><b>CPF
							Cliente</td></a> <a>
					</a> <a>
						<td><b>Cor Bone</td>
					</a>
					<td><b>Valor do Bone<b/></td>
					<td><b>Descrição<b/></td>
					<td><font color=""><b>Ação<b/></td>
			</tr>

			<%
				List<Venda> vendas = (List<Venda>) request.getAttribute("lista");

				for (Venda venda : vendas) {
			%>
			<tr>
				<td align="center"><%=venda.getIdvenda() %></td>
				<td align="center"><%=venda.getCliente().getNome()%></td>
				<td align="center"><%=venda.getCliente().getCPF()%></td>
				<td align="center"><%=venda.getBone().getCor()%></td>
				<td align="center"><%=venda.getBone().getPreco()%></td>
				<td align="center"><%=venda.getDescricao()%></td>
				<td><a href="/LojaBone/venda?acao=excluir&id=<%=venda.getIdvenda()%>"><font color="Blue"><b>Deletar Venda</a></td>
				<>
			</tr>
			<%
				}
			%>
		</table>


		<p>
			<input type="button"onclick="location='/LojaBone/JSP/Menu.jsp'"	value="Menu Principal"><br>
	</div align="center">

</div>

</body>
</html>