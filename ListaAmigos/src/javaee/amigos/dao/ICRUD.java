package javaee.amigos.dao;

import java.util.List;

public interface ICRUD<T>  {
	public List<T> obtener(T t);
	//public T leerPorId (int id);
	public void registrar(T t);
	public void actualizar(T t, String nombreAnterior);
	public void eliminar(T t);
}
