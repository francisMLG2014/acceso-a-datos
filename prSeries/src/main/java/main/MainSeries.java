package main;

import dao.SerieDao;
import dao.TemporadaDao;
import pojos.Serie;

public class MainSeries {

	public static void main(String[] args) {
		SerieDao serieDao=new SerieDao();
		TemporadaDao temporadaDao=new TemporadaDao();
		Serie serie=new Serie("Los Simpsons",7,"Disney Plus");
		serieDao.insertar(serie);
		
	}

}
