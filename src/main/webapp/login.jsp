<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset=utf-8>
<title>Login</title>
<link rel="stylesheet" href="css/style.css">



<%
String erro = (String) request.getAttribute("erro");
%>

</head>
<body>
	<nav>
		<div class="logo">Adriano Costa</div>
		<ul>
			<li><a href="Index.html">Voltar</a></li>
		</ul>
	</nav>

	<div id="login-container">
		<h1>Login</h1>
		<form name="frmLogin" action="<%=request.getContextPath()%>/login"
			method="post">
			<label for="email">E-mail</label> <input type="text" name="email"
				id="email" placeholder="Digite seu e-mail" autocomplete="off">

			<label for="senha">Senha</label> <input type="password" name="senha"
				id="senha" placeholder="Digite a sua senha" autocomplete="off">


			<a href="" id="forgot-pass">Esqueceu a senha?</a><br>
			<p>
				<%
				if (erro != null) {
					out.print(erro);
				}
				%>
			</p>
			<input type="submit" onclick="return validarForm()">


		</form>
		<div id="register-container">
			<p>Ainda não tem uma conta?</p>
			<a href="cadastroNovoUsuario.html">Registrar</a>
		</div>
	</div>

</body>
</html>
