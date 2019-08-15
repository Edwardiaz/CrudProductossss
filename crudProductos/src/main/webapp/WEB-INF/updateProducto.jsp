<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Editar Producto</h1>
<form action="update" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td><output path="idproducto" /></td>
		</tr>
		<tr>
			<td>Nombre :</td>
			<td><input path="producto" /></td>
		</tr>
		<tr>
			<td>Precio :</td>
			<td><input path="precio" /></td>
		</tr>
		<tr>
			<td>Categoria :</td>
			<td><input path="idCategoria" /></td>
		</tr>
		
		<tr>
			<td>Cantidad :</td>
			<td><input path="cantidad" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" name="Guardar" value="Guardar" /></td>
		</tr>
	</table>
</form>
