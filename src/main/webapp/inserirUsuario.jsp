<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Inserir Novo Usuário</title>

<link rel="stylesheet" href="css/style.css">

<script type="text/javascript">

			function validarNovoUsuario(){
				
				var nome = frmContato.nome.value;
				var fone = frmContato.fone.value;
				var email = frmContato.email.value;
				var senha= frmContato.senha.value;
				
				if(nome === ""){
					alert("Insira o nome");
					frmContato.nome.focus();
					return false;
				}
				
				if(fone === ""){
					alert("Insira o telefone");
					frmContato.fone.focus();
					return false;
				}
				
				if(email === ""){
					alert("Insira o email");
					frmContato.email.focus();
					return false;
				}
				
				if(email.indexOf('@') == -1){
					alert("Verifique se o email foi escrito corretamente");
					frmContato.email.focus();
					return false;
				}	
				
				if(senha === ""){
					alert("Insira a senha");
					frmContato.senha.focus();
					return false;
				}
			}
		</script>
		
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
	
		<h1>Inserir Novo Usuário </h1>
		
		<form name="frmContato" action="insert">
			
			<label for="text">Nome</label>
			<input type="text" name="nome" id="nome" placeholder="Inserir o nome" autocomplete="off">
			
				
			<label for="text">Telefone</label>
			<input type="text" name="fone" id="fone" placeholder="Inserir o telefone" autocomplete="off">
			
			<label for="text">Email</label>
			<input type="text" name="email" id="email" placeholder="Inserir o email" autocomplete="off">
			
			<label for="text">Senha</label>
			<input type="text" name="senha" id="senha" placeholder="Inserir a senha" autocomplete="off">
			
		
			<input src="" type="submit" onclick="return validarNovoUsuario()">
		</form>
		
	</div>
		<script>
			$("#fone").mask("(99) 99999-9999");
		</script>
</body>
</html>