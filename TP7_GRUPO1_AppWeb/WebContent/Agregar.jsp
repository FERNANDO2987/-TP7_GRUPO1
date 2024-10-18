<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>  
<%@ page import="entidad.TipoSeguro" %>
<%@ page import="daoImpl.TipoSegurosDao" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Agregar</title>
</head>
<body>

<nav>  
    <a href="Inicio.jsp">Inicio</a> |  
    <a href="servletSeguro?agregar=1">Agregar seguro</a> |  
    <a href="servletListar?lista=1">Listar seguros</a>  
</nav>  
<h1>Agregar seguros</h1>  

<form method="get" action="servletSeguro">
    <table>
        <tr>
            <td>Id Seguro:</td>
               <td>  
                <%  
                	Integer idSeguro = 0;
                	if(request.getAttribute("IDProximo") != null)
                	{
                		idSeguro = (Integer) request.getAttribute("IDProximo");
                	}   
                    if (idSeguro != 0) {  
                        out.print(idSeguro); // Muestra el ID del seguro generado  
                    } else {  
                        out.print("N/A"); // Muestra "N/A" si no hay ID generado  
                    }  
                %>  
            </td>  
        </tr>
        <tr>
            <td>Descripción:</td>
            <td><input type="text" name="txtDescripcion" required></td>
        </tr>
        <tr>
            <td>Tipo de seguro:</td>
            <td>
                <select name="seguro" >
                    <%
                        TipoSegurosDao tipoSegurosDao = new TipoSegurosDao();
                        ArrayList<TipoSeguro> tiposSeguros = tipoSegurosDao.obtenerTiposSeguros();
                        for (TipoSeguro tipo : tiposSeguros) {
                    %>
                        <option value="<%= tipo.getIdTipo() %>"><%= tipo.getDescripcion() %></option>
                    <%
                        }
                    %>
                </select>
            </td>
        </tr>
        <tr>
            <td>Costo de contratación:</td>
            <td><input type="number" step="0.1" name="txtCostoContratacion" required></td>
        </tr>
        <tr>
            <td>Costo máximo asegurado:</td>
            <td><input type="number" step="0.1" name="txtCostoMaximo" required></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" name="btnAceptar" value="Aceptar">
            </td>
        </tr>
    </table>
</form>


</body>
</html>
