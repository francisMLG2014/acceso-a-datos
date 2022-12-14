package main;

import java.util.ArrayList;

import daos.AnimeDAO;
import daos.TemporadaDAO;
import pojos.Anime;
import pojos.Temporada;

public class PrincipalProyecto {

	public static void main(String[] args) {
		
		/*
		 * Inicializacion de variables
		 */
		AnimeDAO a=new AnimeDAO();
		TemporadaDAO t=new TemporadaDAO();
		Anime a1=new Anime(1,"My Hero Academy","Boku no Hero Academy",true);
		Anime a2=new Anime(2,"Demon Slayer","Kimetsu No Yaiba",false);
		Anime a3=new Anime(3,"Chainsaw Man","Chainsaw Man",true);
		Temporada t1=new Temporada(1, 1, "My Hero Academy", "Boku no Hero", 1, 13);
		Temporada t2=new Temporada(2, 2, "My Hero Academy Season 2", "Boku no Hero Season 2", 1, 25);
		Temporada t3=new Temporada(3, 3, "My Hero Academy Season 3", "Boku no Hero Season 3", 1, 25);
		Temporada t4=new Temporada(4, 1, "Chainsaw Man", "Chainsaw Man", 3, 12);
		Temporada t5=new Temporada(5, 1, "Demon Slayer", "Kimetsu No Yaiba",2, 12);
		Temporada t6=new Temporada(6, 2, "Demon Slayer Season 2", "Kimetsu No Yaiba Season 2", 2, 12);
		
		
		/*
		 * Introducir datos en la bbdd
		 */
		a.insertar(a1);
		a.insertar(a2);
		
		t.insertar(t1);
		t.insertar(t2);
		t.insertar(t3);
		System.out.println("--Comprobamos que se han insertado correctamente por ahora:");
		imprimirArray(a.buscarTodos());
		imprimirArray(t.buscarTodos());
		a.insertar(a3);
		t.insertar(t4);
		t.insertar(t5);
		t.insertar(t6);
		
		/*
		 * Buscamos una temporada y un anime
		 */
		System.out.println("--Buscamos temporada y anime\n");
		System.out.println(a.buscarPorId(a1.getId()));
		System.out.println(a1.getTitulojapones()+" tiene: "+a.cantidadTemporadas(a1)+" temporadas");
		System.out.println(t.buscarPorId(t2.getId()));
		
		
		/*
		 * Actualizamos los mismos que hemos buscado arriba y mostramos
		 */
		System.out.println("\n--Actualizamos y mostramos\n");
		a1.setTitulojapones(a1.getTitulojapones()+" CHANGED");
		t2.setTitulojapones(t2.getTitulojapones()+" Besto temporada");
		a.modificar(a1);
		t.modificar(t2);
		System.out.println(a.buscarPorId(a1.getId()));
		System.out.println(t.buscarPorId(t2.getId()));
		
		/*
		 * Borramos las temporada y animes, y mostramos
		 */
		
		t.borrar(t1);
		t.borrar(t2);
		t.borrar(t3);
		a.borrar(a1);
		System.out.println("\n--Mostramos los registros restantes\n");
		imprimirArray(a.buscarTodos());
		imprimirArray(t.buscarTodos());
		
		
		
		/*
		 * Borrado de bbdd
		 */
		t.borrarTodo();
		a.borrarTodo();
		
	}
	public static<E> void imprimirArray(ArrayList<E> arr) {
		for(short i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		System.out.println("-----------------\n");
	}
}
