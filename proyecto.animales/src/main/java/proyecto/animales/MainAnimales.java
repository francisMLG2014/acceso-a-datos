package proyecto.animales;

import java.util.ArrayList;

public class MainAnimales {
	public static void main(String[] args) {
		

		Animal a=new Animal("Loro","Casa",2.2);
		AnimalDAO.insertAnimal(a);
		ArrayList<Animal> animales=AnimalDAO.findAllAnimals();
		for(byte i=0;i<animales.size();i++) {
			System.out.println(animales.get(i));
		}
		
		
		
		
		
	}

}
