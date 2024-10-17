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
        
        
        TipoSegurosDao tipoSegurosDao = new TipoSegurosDao();
        ArrayList<TipoSeguro> tiposSeguros = tipoSegurosDao.obtenerTiposSeguros();
        
        // Mostrar los tipos de seguro en la consola
        for (TipoSeguro tipo : tiposSeguros) {
            System.out.println("ID Tipo: " + tipo.getIdTipo() + ", Descripción: " + tipo.getDescripcion());
        }
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conmysql = null;
		String urlmysql = "jdbc:mysql://localhost:3306/segurosGroup";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conmysql = DriverManager.getConnection(urlmysql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		//int filas;
		if(request.getParameter("btnAceptar")!=null)
		{
			
			
			// Obtener tipos de seguros
			TipoSegurosDao tipoSegurosDao = new TipoSegurosDao();
			ArrayList<TipoSeguro> tiposSeguros = tipoSegurosDao.obtenerTiposSeguros();

			// Enviar los tipos de seguros a la JSP
			request.setAttribute("tiposSeguros", tiposSeguros);

			// Redirigir a la vista (Agregar.jsp)
			RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
			rd.forward(request, response);
			
			
//			Seguro s = new Seguro();
//			s.setDescripcion("txtDescripcion");
//			//s.setIdTipo("seguro"); //LEER POR BD LOS TIPOS DE SEGURO EXISTENTES
//			s.setCostoContratacion(Double.parseDouble("txtCostoContratacion"));
//			s.setCostoAsegurado(Double.parseDouble("txtCostoMaximo"));
//			
//			SegurosDao sdao = new SegurosDao();
//			filas = sdao.agregarSeguro(s);
			
			//request.setAttribute("cantFilas", filas);
			//RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
			//rd.forward( request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
