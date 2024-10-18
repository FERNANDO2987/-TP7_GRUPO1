package entidad;

public class Seguro {
	
	
	   private int idSeguro;
	    private String descripcion;
	    private TipoSeguro tipo;
	    private double costoContratacion;
	    private double costoAsegurado;
	

	public Seguro()
	{
		
	}


	public Seguro(int idSeguro, String descripcion, int idTipo, double costoContratacion, double costoAsegurado) {
		super();
		this.idSeguro = idSeguro;
		this.descripcion = descripcion;
		this.tipo.setIdTipo(idTipo);
		this.costoContratacion = costoContratacion;
		this.costoAsegurado = costoAsegurado;
	}


	public int getIdSeguro() {
		return idSeguro;
	}


	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getIdTipo() {
		return this.tipo.getIdTipo();
	}


	public void setIdTipo(int idTipo) {
		this.tipo.setIdTipo(idTipo);
	}


	public double getCostoContratacion() {
		return costoContratacion;
	}


	public void setCostoContratacion(double costoContratacion) {
		this.costoContratacion = costoContratacion;
	}


	public double getCostoAsegurado() {
		return costoAsegurado;
	}


	public void setCostoAsegurado(double costoAsegurado) {
		this.costoAsegurado = costoAsegurado;
	}


	public TipoSeguro getTipo() {
		return tipo;
	}


	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}


	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", descripcion=" + descripcion + ", idTipo=" + this.tipo.getIdTipo()
				+ ", costoContratacion=" + costoContratacion + ", costoAsegurado=" + costoAsegurado + "]";
	}
}


