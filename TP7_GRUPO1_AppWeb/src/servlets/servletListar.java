package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

/**
 * Servlet implementation class servletListar
 */
@WebServlet("/servletListar")
public class servletListar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListar() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosGroup";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conmysql = null;
        String urlmysql = "jdbc:mysql://localhost:3306/segurosGroup";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conmysql =DriverManager.getConnection(host + dbName, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error de conexión a la base de datos: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/Listar.jsp");
            rd.forward(request, response);
            return; // Detener procesamiento
        }
        
		if(request.getParameter("lista")!= null)
		{
			//Todos los seguros
			SegurosDao segurosDao = new SegurosDao();
			ArrayList<Seguro> listaSeguros;
			listaSeguros = segurosDao.obtenerSeguros();
			
			request.setAttribute("listaCargada", listaSeguros);
			//Lista de Opciones
			TipoSegurosDao tipoSegurosDao = new TipoSegurosDao();
            ArrayList<TipoSeguro> tiposSeguros = tipoSegurosDao.obtenerTiposSeguros();
            
            request.setAttribute("opciones", tiposSeguros);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Listar.jsp");
			rd.forward(request, response);
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		  
		   Connection conmysql = null;
	        String urlmysql = "jdbc:mysql://localhost:3306/segurosGroup";
	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            conmysql =DriverManager.getConnection(host + dbName, user, pass);
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "Error de conexión a la base de datos: " + e.getMessage());
	            RequestDispatcher rd = request.getRequestDispatcher("/Listar.jsp");
	            rd.forward(request, response);
	            return; // Detener procesamiento
	        }
	        //Lista de Opciones
	        TipoSegurosDao tipoSegurosDao = new TipoSegurosDao();
            ArrayList<TipoSeguro> tiposSeguros = tipoSegurosDao.obtenerTiposSeguros();
            
            request.setAttribute("opciones", tiposSeguros);
            //La eleccion en el filtro
	        String tipoSeguroSeleccionado = request.getParameter("tipoSeguro");  
	        
	        // Lógica para obtener seguros por tipo  
	        SegurosDao segurosDao = new SegurosDao();  
	        ArrayList<Seguro> listaSeguros;  
	        
	        if (tipoSeguroSeleccionado != null && !tipoSeguroSeleccionado.isEmpty()) {  
	            listaSeguros = segurosDao.obtenerSegurosPorTipo(tipoSeguroSeleccionado); // Este método debería implementarse  
	        } else {  
	            listaSeguros = segurosDao.obtenerSeguros();
	        }  
	        
	        request.setAttribute("listaCargada", listaSeguros);  
	        request.getRequestDispatcher("/Listar.jsp").forward(request, response); 
	    } 
}
