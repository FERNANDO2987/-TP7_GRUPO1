<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>  
   <%@ page import="entidad.TipoSeguro" %>
<!DOCTYPE html>
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
                  <select id="nitfuentes" name="seguro" class="form-control" required>  
    <option value="">Seleccione</option>  

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

int filas =0;
if(request.getAttribute("cantFilas")!=null)
{
	filas = Integer.parseInt(request.getAttribute("cantFilas").toString()); 
}




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