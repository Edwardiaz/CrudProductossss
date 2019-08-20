<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CATEGORIA</title>
</head>
<body>

	<h2>Lista Productos</h2>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>***Listado de Categoria***</h1>
	<h3>Links de movimiento</h3>
	<h3>
		<a href="http://localhost:8090/crudProductos/">Vista principal</a>
	</h3>
	<h3>
		<a href="listaP">Consultar los productoss</a>
	</h3>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Categoria</th>
			
		</tr>
		<c:forEach var="ver" items="${listaCat}">
			<tr>
				<td>${ver.idCategoria}</td>
				<td>${ver.categoria}</td>
				
				<td><a href="">Editar</a>
				<br>
				<a href="">Eliminar</a></td>

			</tr>
		</c:forEach>
	</table>
	<br />

</body>
</html>