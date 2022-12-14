package dao;

import java.util.ArrayList;

public interface InterfazDao<T> {
	
	/**
	 * Muestra todos los objetos T de la base de datoss
	 * @return ArrayList de T
	 */
	public ArrayList<T> buscarTodos();
	
	/**
	 * Busca el objeto T con el id especificado
	 * @param i id del objeto 
	 * @return Objeto t recuperado de la base de datos
	 */
	public T buscarPorId(int i);
	
	/**
	 * Insertamos un objeto nuevo en la base de datos
	 * @param t objeto que queremos insertar
	 */
	public void insertar(T t);
	
	/**
	 * Actualiza el objeto t de la base de datos 
	 * @param t objeto que deseamos actualizar
	 */
	public void modificar(T t);
	
	/**
	 * Borra un objeto de la base de datos
	 * @param t objeto que queremos borrar
	 */
	public void borrar(T t);
	
}
