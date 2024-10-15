<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar</title>
</head>
<body>

	<nav>  
        <a href="Inicio.jsp">Inicio</a> |  
        <a href="Agregar.jsp">Agregar seguro</a> |  
        <a href="Listar.jsp">Listar seguros</a>  
    </nav>  
	<h1>Agregar seguros</h1>  
	
	<form method="get" action="servletSeguro">
	
		<table>
			<tr>
				<td>Id Seguro:</td>
				<td></td>
			</tr>
			<tr>
				<td>Descripción:</td>
				<td><input type="text" name="txtDescripcion"></td>
			</tr>
			<tr>
				<td>Tipo de seguro:</td>
				<td>
					<select name="seguro">
						
					</select>
				</td>
			</tr>
			<tr>
				<td>Costo de contratación:</td>
				<td><input type="text" name="txtCostoContratacion"></td>
			</tr>
			<tr>
				<td>Costo máximo asegurado:</td>
				<td><input type="text" name="txtCostoMaximo"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="submit" name="btnAceptar" value="Aceptar">
				</td>
			</tr>
		</table>
	
	</form>
	
<%
	int filas = Integer.parseInt(request.getAttribute("cantFilas").toString());
%>
<%
	if(filas==1)
	{
		%>
		Seguro agregado con éxito
		<%		
	}
%>
	
</body>
</html>