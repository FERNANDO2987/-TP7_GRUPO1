package dao;

import java.util.ArrayList;

import entidad.Seguro;

public interface ISeguroDao {
	public int agregarSeguro(Seguro seguro);
	public ArrayList<Seguro> obtenerSeguros();
	public Seguro obtenerUnSeguro(int id);
	public ArrayList<Seguro> obtenerSegurosPorTipo(String tipoSeguro);
	public int numeroNuevoRegistro();
}
