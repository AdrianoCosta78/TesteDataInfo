<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="model.DAO"%>


<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
	
	
 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Lista de Tarefas</title>
<link rel="stylesheet" href="css/style.css">


</head>
<body>
	<nav>
		<div class="logo">Adriano Costa</div>
			<ul>
				<li><a href="report">Relatório</a></li>
				<li><a href="telaPrincipal.jsp">Voltar</a></li>
				<li><a href="Index.html">Sair</a></li>
				
			</ul>		
	</nav>
	<div id= "login3-container">
		<h1>Lista de Usuários</h1>
		
		
	
		<a href="inserirUsuario.jsp" class="Botao3" >Inserir Novo Usuario</a>
		<table id="tabela">
		
			<thead>
		
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Telefone</th>
					<th>Email</th>
					<th>Senhas</th>
					<th>Opções</th>
				</tr>		
			</thead>
			<tbody>
			
				
				<%DAO dao = new DAO();	%>			
				<%ArrayList<JavaBeans> lista = dao.listarUsuarios();%>
				
				<%for (int i = 0; i < lista.size(); i++){%>
				<tr>
					<td><%=lista.get(i).getIdusu() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><%=lista.get(i).getEmail() %></td>
					<td><%=lista.get(i).getSenha() %></td>
					
					<td>
					<a href="editar?idusu=<%=lista.get(i).getIdusu() %>" class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdusu() %>)" class="Botao2">Deletar</a></td>
					
				
				</tr>
				
				
				<%}%>
				
			</tbody>
		</table>
	
		
	</div>
	<script src="scripts/confirmaExclusao.js"></script>
</body>
</html>
