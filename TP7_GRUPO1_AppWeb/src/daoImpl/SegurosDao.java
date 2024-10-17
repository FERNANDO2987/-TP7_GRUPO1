package daoImpl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Seguro;

public class SegurosDao {
	
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosGroup";

	
	public int agregarSeguro(Seguro seguro) {  
	    int idGenerado = -1; // Inicializamos con un valor que indica que no se ha generado un ID  
	    Connection cn = null;  
	    PreparedStatement pst = null;  
	    
	    try {  
	        // Cargar el driver de MySQL  
	        Class.forName("com.mysql.jdbc.Driver");  

	        // Conectarse a la base de datos  
	        cn = DriverManager.getConnection(host + dbName, user, pass);  

	        // Preparar la consulta con PreparedStatement para evitar inyección SQL  
	        String query = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)";  
	        pst = cn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS); // Permitir la obtención de claves generadas  
	        
	        // Asignar valores a los parámetros  
	        pst.setString(1, seguro.getDescripcion());  
	        pst.setInt(2, seguro.getIdTipo());  
	        pst.setBigDecimal(3, BigDecimal.valueOf(seguro.getCostoContratacion()));  
	        pst.setBigDecimal(4, BigDecimal.valueOf(seguro.getCostoAsegurado()));  

	        // Ejecutar la actualización  
	        pst.executeUpdate();  

	        // Obtener la clave generada  
	        ResultSet generatedKeys = pst.getGeneratedKeys();  
	        if (generatedKeys.next()) {  
	            idGenerado = generatedKeys.getInt(1); // Recuperar el ID generado  
	        }  
	        
	    } catch (ClassNotFoundException e) {  
	        e.printStackTrace();  
	    } catch (SQLException e) {  
	        e.printStackTrace();  
	    } finally {  
	        // Cerrar la conexión para liberar recursos  
	        try {  
	            if (pst != null) pst.close();  
	            if (cn != null) cn.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	    return idGenerado; // Devuelve el ID generado  
	}

	
	
	
	public ArrayList<Seguro> obtenerSeguros() {
	    ArrayList<Seguro> lista = new ArrayList<>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM seguros";
	        pstmt = conn.prepareStatement(query);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Seguro seguro = new Seguro();
	            seguro.setIdSeguro(rs.getInt("idSeguro"));
	            seguro.setDescripcion(rs.getString("descripcion"));
	            seguro.setIdTipo(rs.getInt("idTipo"));
	            seguro.setCostoContratacion(rs.getDouble("costoContratacion"));
	            seguro.setCostoAsegurado(rs.getDouble("costoAsegurado"));

	            lista.add(seguro);
	        }
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

	
	
	public Seguro obtenerUnSeguro(int id) {
	    Seguro seguro = null;
	    Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet resultado = null;

	    try {
	        con = DriverManager.getConnection(host + dbName, user, pass);
	        String query = "SELECT idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM seguros WHERE idSeguro = ?";
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, id); // Cargo el ID recibido
	        resultado = pstmt.executeQuery();

	        if (resultado.next()) {
	            seguro = new Seguro();
	            seguro.setIdSeguro(resultado.getInt("idSeguro"));
	            seguro.setDescripcion(resultado.getString("descripcion"));
	            seguro.setIdTipo(resultado.getInt("idTipo"));
	            seguro.setCostoContratacion(resultado.getDouble("costoContratacion"));
	            seguro.setCostoAsegurado(resultado.getDouble("costoAsegurado"));
	        }
	    } catch (Exception e) {
	        System.out.println("Error de conexión o consulta: " + e.getMessage());
	    } finally {
	        try {
	            if (resultado != null) resultado.close();
	            if (pstmt != null) pstmt.close();
	            if (con != null) con.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
	    
	    return seguro;
	}	

}