<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Editar Usuário</title>

<link rel="stylesheet" href="css/style.css">

			<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
			<script src="//cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js"></script>

</head>
<body>
	<nav>
		<div class="logo">Adriano Costa</div>
			<ul>
				<li><a href="listarUsuarios.jsp">Voltar</a></li>
				<li><a href="Index.html">Sair</a></li>
			</ul>		
	</nav>
	<div id= "login2-container">
	
		<h1>Editar Usuário</h1>
		
		<form name="frmContato" action="update">
		
			<label for="text">ID</label>
			<input type="text" name="idusu" id="titulo" autocomplete="off" class="Botao4" readonly value="<%out.print(request.getAttribute("idusu"));%>">
			
			<label for="text">Nome</label>
			<input type="text" name="nome" id="titulo" autocomplete="off" value="<%out.print(request.getAttribute("nome"));%>">
							
			<label for="text">Telefone</label>
			<input type="text" name="fone" id="fone"  autocomplete="off" value="<%out.print(request.getAttribute("fone"));%>">
			
			<label for="text">Email</label>
			<input type="text" name="email" id="email" autocomplete="off" value="<%out.print(request.getAttribute("email"));%>">
			
			<label for="text">Senha</label>
			<input type="text" name="senha" id="senha" autocomplete="off" value="<%out.print(request.getAttribute("senha"));%>">
					
			<input src="" type="submit" value="Salvar" onclick="validarTarefas()">
		</form>
		
	</div>
	<script src="scripts/validarTarefa.js"></script>	
	<script>
		$("#fone").mask("(99) 99999-9999");
	</script>

</body>
</html>