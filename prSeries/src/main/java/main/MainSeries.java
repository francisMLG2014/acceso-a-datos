package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojos.Serie;
import pojos.Temporada;

public class MainSeries {

	public static void main(String[] args) {
		SerieDao serieDao=new SerieDao();
		TemporadaDao temporadaDao=new TemporadaDao();
//		Serie serie=new Serie("Los Simpsons",7,"Disney Plus");
//		serieDao.insertar(serie);
		Serie serie=serieDao.buscarPorId(1);
		Temporada t1=new Temporada(1,"Temporada 1",serie);
		Temporada t2=new Temporada(2,"Temporada 2",serie);
		temporadaDao.insertar(t1);
		temporadaDao.insertar(t2);
		
		
		
	}

}
