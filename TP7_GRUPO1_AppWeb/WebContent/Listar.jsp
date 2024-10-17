<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
    <%@ page import="java.util.ArrayList" %>  
<%@ page import="entidad.TipoSeguro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Lista de Seguros</title>  
</head>  
<body>  
  <nav>  
        <a href="Inicio.jsp">Inicio</a> |  
        <a href="Agregar.jsp">Agregar seguro</a> |  
        <a href="Listar.jsp">Listar seguros</a>  
    </nav> 

    <h3>Tipo de seguros de la base de datos</h3>  
    <form action="servletListar" method="post">  
        <label for="tipoSeguro">Buscada por tipo de Seguros:</label>  
        <select name="tipoSeguro" id="tipoSeguro">  
            <option value="Seguro de casas">Seguro de casas</option>  
            <option value="Seguro de motos">Seguro de motos</option>  
            <!-- Add more options as needed -->  
        </select>  
        <input type="submit" value="Filtrar">  
    </form> 
    <br></br> 
    <table border="1">  
        <tr>  
            <th>ID seguro</th>  
            <th>Descripci�n seguro</th>  
            <th>Descripci�n tipo seguro</th>  
            <th>Costo contrataci�n</th>  
            <th>Costo m�ximo asegurado</th>  
        </tr>  
        <!-- Aqu� se llenar�n los datos de la base de datos -->  
    </table>  
</body>  
</html>