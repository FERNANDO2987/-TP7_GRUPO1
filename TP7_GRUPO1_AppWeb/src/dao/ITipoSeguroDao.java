package dao;

import java.util.ArrayList;

import entidad.TipoSeguro;

public interface ITipoSeguroDao {
	public TipoSeguro obtenerTipoSeguro(int id);
	public ArrayList<TipoSeguro> obtenerTiposSeguros();
	public ArrayList<TipoSeguro> buscarPorTipoSeguro(String descripcion);
}
