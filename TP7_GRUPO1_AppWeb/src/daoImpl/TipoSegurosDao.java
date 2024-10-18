package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ITipoSeguroDao;
import entidad.TipoSeguro;

public class TipoSegurosDao implements ITipoSeguroDao {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosGroup";

	
	
	public ArrayList<TipoSeguro> obtenerTiposSeguros() {
	    ArrayList<TipoSeguro> lista = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT * FROM tipoSeguros";
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            TipoSeguro tipo = new TipoSeguro();
	            tipo.setIdTipo(rs.getInt("idTipo"));
	            tipo.setDescripcion(rs.getString("descripcion"));
	          

	            lista.add(tipo);
	        }
	        
	        
	        System.out.println("Cantidad de tipos de seguros recuperados: " + lista.size());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    return lista;
	}
	
	
	
	public ArrayList<TipoSeguro> buscarPorTipoSeguro(String descripcion) {
	    ArrayList<TipoSeguro> lista = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT * FROM tipoSeguros WHERE descripcion LIKE ?";
	        pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, "%" + descripcion + "%"); // Uso de LIKE para buscar coincidencias parciales
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            TipoSeguro tipo = new TipoSeguro();
	            tipo.setIdTipo(rs.getInt("idTipo"));
	            tipo.setDescripcion(rs.getString("descripcion"));

	            lista.add(tipo);
	        }

	        System.out.println("Cantidad de tipos de seguros recuperados: " + lista.size());
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    return lista;
	}



	@Override
	public TipoSeguro obtenerTipoSeguro(int id) {
		TipoSeguro tipo = new TipoSeguro();
		final String query = "SELECT * from tiposeguros where idTipo = ?";
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    try {
	        conn = DriverManager.getConnection(host + dbName, user, pass);
	        pstmt = conn.prepareStatement(query);
	        pstmt.setInt(1, id);
	        rs = pstmt.executeQuery();

	        rs.next();
            tipo.setIdTipo(rs.getInt("idTipo"));
            tipo.setDescripcion(rs.getString("descripcion"));

	    }
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	    } 
	    finally 
	    {
	        try 
	        {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } 
	        catch (Exception ex) 
	        {
	            ex.printStackTrace();
	        }
	    }
	    
	    return tipo;
	}



}
