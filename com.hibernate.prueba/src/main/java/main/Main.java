package main;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import pojo.Animal;
import pojo.Zoologico;
import util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session sesion=HibernateUtil.getSessionFactory().openSession();
		Zoologico zoo=new Zoologico("Fuengirola ZOO","Fuengirola",2022);
//		sesion.save(zoo);
		
		
		
		
		/* hql=Hibernate Query Language
		//  Busqueda avanzada con wheres
		String hql="FROM Animal WHERE habitat=:habitat";
		Query query=sesion.createQuery(hql);
		query.setParameter("habitat", "Casa");
		List<Animal> animales=query.getResultList();
		
		
		
		
		//Insertas un dato en la tabla
		Animal a1=new Animal("Yorkshire","Casa",new BigDecimal(1));
		sesion.save(a1);
		
		
		int id=16;
		//Recuperas un dato de la tabla
		Animal a=(Animal)sesion.get(Animal.class, id);
		System.out.println(a.getNombre());
											//CONSULTA-Nombre Pojo. 
		List<Animal> animales=sesion.createQuery("FROM Animal").getResultList();
		
		
		for(Iterator<Animal> i=animales.iterator();i.hasNext();) {
			Animal anim=i.next();
			System.out.println(anim.getNombre());
		}
		*/
		
		sesion.close();
	}

}
