package proyecto.animales;

public class MainAnimales {
	public static void main(String[] args) {
		System.out.println("raar");
		Animal a=new Animal("Ardilla","Bosque",0.1);
		AnimalDAO.insertAnimal(a);
		
	}

}
