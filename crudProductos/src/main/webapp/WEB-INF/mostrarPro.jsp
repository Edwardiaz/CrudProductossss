<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Lista Productos</h2>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>***Listado de productos***</h1>
	<h3>Links de movimiento</h3>
	<h3>
		<a href="http://localhost:8090/crudProductos/">Vista principal</a>
	</h3>
	<h3>
		<a href="listaC">Consultar las Categorias</a>
	</h3>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>ID</th>
			<th>Producto</th>
			<th>Precio</th>
			<th>Categoria</th>
			<th>Cantidad</th>
		</tr>
		<c:forEach var="ver" items="${listaPro}">
			<tr>
				<td>${ver.idProducto}</td>
				<td>${ver.producto}</td>
				<td>${ver.precio}</td>
				<td>${ver.idCategoria}</td>
				<td>${ver.cantidad}</td>
				<td><a href="updatePro/${ver.idProducto}">Editar</a></td>
				<td><a href="eliminarpro/${ver.idProducto}">Eliminar</a></td>

				<td></td>
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>