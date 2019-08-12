<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Editar Producto</h1>
<form:form method="POST" action="/crudProductos/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="idproducto" /></td>
		</tr>
		<tr>
			<td>Nombre :</td>
			<td><form:input path="producto" /></td>
		</tr>
		<tr>
			<td>Precio :</td>
			<td><form:input path="precio" /></td>
		</tr>
		<tr>
			<td>Categoria :</td>
			<td><form:input path="idCategoria" /></td>
		</tr>
		
		<tr>
			<td>Cantidad :</td>
			<td><form:input path="cantidad" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Actualizar" /></td>
		</tr>
	</table>
</form:form>
