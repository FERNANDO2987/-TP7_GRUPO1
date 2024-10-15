package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SegurosDao;
import entidad.Seguro;

/**
 * Servlet implementation class servletSeguro
 */
@WebServlet("/servletSeguro")
public class servletSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int filas;
		if(request.getParameter("btnAceptar")!=null)
		{
			Seguro s = new Seguro();
			s.setDescripcion("txtDescripcion");
			//s.setIdTipo("seguro"); //LEER POR BD LOS TIPOS DE SEGURO EXISTENTES
			s.setCostoContratacion(Double.parseDouble("txtCostoContratacion"));
			s.setCostoAsegurado(Double.parseDouble("txtCostoMaximo"));
			
			SegurosDao sdao = new SegurosDao();
			filas = sdao.agregarSeguro(s);
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/Agregar.jsp");
			rd.forward( request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
