<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.crudjspjava.dao.UsuarioDao" %>
<%@ page import="com.crudjspjava.bean.Usuario" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualização de Usuários</title>
</head>
<body>
	<h1>Listagem de Usuários</h1>
	<% 
	List<Usuario> list = UsuarioDao.getAllUsuarios();
	request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Senha</th>
			<th>Email</th>
			<th>Sexo</th>
			<th>País</th>
			<th>Editar</th>
			<th>Excluir</th>
		</tr>
			<c:forEach items="${list}" var="usuario">
				<tr>
					<td>${usuario.getId()}</td>
					<td>${usuario.getNome()}</td>
					<td>${usuario.getPassword()}</td>
					<td>${usuario.getEmail()}</td>
					<td>${usuario.getSexo()}</td>
					<td>${usuario.getPais()}</td>
					<td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
					<td><a href="#">Excluir</a></td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<a href="addusuarioform.jsp">Adicionar novo usuário</a>
</body>
</html>