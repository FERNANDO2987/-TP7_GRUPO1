package main;

import java.util.ArrayList;

import dao.ISeguroDao;
import daoImpl.SegurosDao;
import daoImpl.TipoSegurosDao;
import entidad.Seguro;
import entidad.TipoSeguro;

public class Principal {

	public static void main(String[] args) {
//		SegurosDao seguroDAO = new SegurosDao();
//
//        // Probar m�todo para insertar un nuevo seguro
//        Seguro nuevoSeguro = new Seguro();
//        nuevoSeguro.setDescripcion("Seguro de Vida2");
//        nuevoSeguro.setIdTipo(1); // Por ejemplo, 1 podr�a representar "Vida"
//        nuevoSeguro.setCostoContratacion(500.75);
//        nuevoSeguro.setCostoAsegurado(300.50);
//        
//        // Llamar al m�todo agregarSeguro para insertar el nuevo seguro
//        int resultado = seguroDAO.agregarSeguro(nuevoSeguro);
//
//        // Verificar si la inserci�n fue exitosa
//        if (resultado > 0) {
//            System.out.println("Seguro insertado correctamente.");
//        } else {
//            System.out.println("No se pudo insertar el seguro.");
//        }
//        
//        
//        
//	
//        //seguroDAO.procedimientoInsertarSeguro(nuevoSeguro);
//        //System.out.println("Seguro insertado correctamente.");
//        
//        
//      
//        ArrayList<Seguro> listaSeguros = seguroDAO.obtenerSeguros();
//        for (Seguro seguro : listaSeguros) {
//            System.out.println("ID: " + seguro.getIdSeguro());
//            System.out.println("Descripci�n: " + seguro.getDescripcion());
//            System.out.println("Tipo de Seguro: " + seguro.getIdTipo());
//            System.out.println("Costo de Contrataci�n: " + seguro.getCostoContratacion());
//            System.out.println("Costo Asegurado: " + seguro.getCostoAsegurado());
//            System.out.println("-----------------------------");
//        }
//	
//        
//        int idSeguroBuscar = 1; 
//        Seguro seguroEncontrado = seguroDAO.obtenerUnSeguro(idSeguroBuscar);
//        if (seguroEncontrado != null) {
//            System.out.println("Seguro encontrado:");
//            System.out.println("ID: " + seguroEncontrado.getIdSeguro());
//            System.out.println("Descripci�n: " + seguroEncontrado.getDescripcion());
//            System.out.println("Tipo de Seguro: " + seguroEncontrado.getIdTipo());
//            System.out.println("Costo de Contrataci�n: " + seguroEncontrado.getCostoContratacion());
//            System.out.println("Costo Asegurado: " + seguroEncontrado.getCostoAsegurado());
//        } else {
//            System.out.println("Seguro con ID " + idSeguroBuscar + " no encontrado.");
//        }
//
//	}
		
		/*TipoSegurosDao tipoDAO = new TipoSegurosDao();
		
		
	    ArrayList<TipoSeguro> listaTipos = tipoDAO.obtenerTiposSeguros();
      for (TipoSeguro tipo : listaTipos) {
          System.out.println("ID: " + tipo.getIdTipo());
          System.out.println("Descripci�n: " + tipo.getDescripcion());
      
          System.out.println("-----------------------------");
      }
	
		*/
		
	}
}

