package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SegurosDao;
import daoImpl.TipoSegurosDao;
import entidad.Seguro;
import entidad.TipoSeguro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletSeguro() {
        super();
        
    }
    
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosGroup";

	

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conmysql = null;
        String urlmysql = "jdbc:mysql://localhost:3306/segurosGroup";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conmysql =DriverManager.getConnection(host + dbName, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error de conexión a la base de datos: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
            rd.forward(request, response);
            return; // Detener procesamiento
        }


        if (request.getParameter("btnAceptar") != null) {
            String descripcion = request.getParameter("txtDescripcion");
            String tipoSeguroIdStr = request.getParameter("seguro");
            // Verifica y logea los parámetros recibidos
            System.out.println("Descripcion: " + descripcion);
            System.out.println("Tipo Seguro ID: " + tipoSeguroIdStr);

            if (tipoSeguroIdStr == null || tipoSeguroIdStr.isEmpty()) {
                request.setAttribute("errorMessage", "Por favor, seleccione un tipo de seguro.");
                RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
                rd.forward(request, response);
                return;
            }

            try {
                int tipoSeguroId = Integer.parseInt(tipoSeguroIdStr);
                double costoContratacion = Double.parseDouble(request.getParameter("txtCostoContratacion"));
                double costoMaximo = Double.parseDouble(request.getParameter("txtCostoMaximo"));

                Seguro s = new Seguro();
                s.setDescripcion(descripcion);
                s.setIdTipo(tipoSeguroId);
                s.setCostoContratacion(costoContratacion);
                s.setCostoAsegurado(costoMaximo);

                SegurosDao sdao = new SegurosDao();
                int idSeguro = sdao.agregarSeguro(s); // Ahora esto devuelve el ID del seguro  

                request.setAttribute("idSeguro", idSeguro);  
                RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
                rd.forward(request, response);
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "Error al parsear números. Verifique los campos de costo.");
                RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
                rd.forward(request, response);
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Error al guardar el seguro: " + e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
                rd.forward(request, response);
            }
        }
    }

    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
