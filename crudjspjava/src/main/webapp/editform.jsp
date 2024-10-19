<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crudjspjava.bean.Usuario" %>
<%@ page import="com.crudjspjava.dao.UsuarioDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edição do Usuário</title>
</head>
<body>
	<% 
		String id = request.getParameter("id");
		Usuario usuario = UsuarioDao.getRegistroByID(Integer.parseInt(id));
	%>
	
	<h1>Edição do Usuário</h1>
	<form action="editusuario.jsp" method="post">
		<table>
			<tr>
				<td>ID: </td>
				<td><input type="text" name="id" readonly value="<%=usuario.getId()%>"/></td>
			</tr>
			<tr>
				<td>Nome: </td>
				<td><input type="text" name="nome" value="<%=usuario.getNome()%>"/></td>
			</tr>
			<tr>
				<td>Senha: </td>
				<td><input type="password" name="password" value="<%=usuario.getPassword()%>"/></td>
			</tr>
			<tr>
				<td>E-mail: </td>
				<td><input type="email" name="email" value="<%=usuario.getEmail()%>"/></td>
			</tr>
			<tr>
				<td>Sexo: </td>
				<td><input type="radio" name="sexo" value="masculino"/>Masculino
					<input type="radio" name="sexo" value="feminino"/>Feminino
				</td>
			</tr>
			<tr>
				<td>País: </td>
				<td><select name="pais">
						<option>Brasil</option>
						<option>EUA</option>
						<option>Portugal</option>
						<option>Argentina</option>
						<option>Russia</option>
						<option>China</option>
						<option>Outro</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Editar usuário"></input></td>
			</tr>
		</table>
	</form>
	
</body>
</html>