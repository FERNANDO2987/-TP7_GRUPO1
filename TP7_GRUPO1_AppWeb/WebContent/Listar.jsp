<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ page import="java.util.ArrayList" %>  
<%@ page import="entidad.Seguro" %>  
<%@ page import="entidad.TipoSeguro" %>  
<%@ page import="daoImpl.TipoSegurosDao" %>
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Lista de Seguros</title>  
</head>  
<body>  
    <nav>  
        <a href="Inicio.jsp">Inicio</a> |  
        <a href="Agregar.jsp">Agregar seguro</a> |  
        <a href="servletListar?lista=1">Listar seguros</a>  
    </nav>   
		<%  
            // Recuperar los tipos de seguros del request
            ArrayList<TipoSeguro> opciones = new ArrayList<TipoSeguro>();
            if(request.getAttribute("opciones")!= null)
            {
            	opciones = (ArrayList<TipoSeguro>) request.getAttribute("opciones");
            }
        %>  
	
    <h3>Tipo de seguros de la base de datos</h3>  
    <form action="servletListar" method="post">  
        <label for="tipoSeguro">Buscar por tipo de Seguros:</label>  
        <select name="tipoSeguro" id="tipoSeguro">
            <%
            	for(TipoSeguro opcion : opciones)
            	{
            		%>
            			<option><%=opcion.getDescripcion() %> </option>
            		<%
            	}
            
            %>           
            <!-- Agrega más opciones según sea necesario -->  
        </select>  
        <input type="submit" value="Filtrar">  
    </form>   
    <br>   

    <table border="1">  
        <tr>  
            <th>ID Seguro</th>  
            <th>Descripción Seguro</th>  
            <th>ID Tipo</th>  
            <th>Costo Contratación</th>  
            <th>Costo Máximo Asegurado</th>  
        </tr>  
        
        <%  
            // Recuperar la lista de seguros del request
            
            ArrayList<Seguro> listaSeguros = new ArrayList<Seguro>(); //(ArrayList<Seguro>) request.getAttribute("listaSeguros");
            if(request.getAttribute("listFiltrada")!= null)
            {
            	listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaFiltrada");
            }
            
	        if(request.getAttribute("listaCargada")!= null)
	        {
	        	listaSeguros = (ArrayList<Seguro>) request.getAttribute("listaCargada");
	        }
	        
            if (listaSeguros.size() > 1) {  
                for (Seguro seguro : listaSeguros) {  
        %>  
        <tr>  
            <td><%= seguro.getIdSeguro() %></td>  
            <td><%= seguro.getDescripcion() %></td>  
            <td><%= seguro.getIdTipo() %></td>  
            <td><%= seguro.getCostoContratacion() %></td>  
            <td><%= seguro.getCostoAsegurado() %></td>  
        </tr>  
        <%  
                }  
            } else {  
        %>  
        <tr>  
            <td colspan="5">No se encontraron seguros.</td>  
        </tr>  
        <%  
            }  
        %>  
    </table>  
</body>  
</html>