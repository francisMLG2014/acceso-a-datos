package pojos;

public class Temporada {
	private int id;
	private int numeroTemporada;
	private String titulo;
	private String titulojapones;
	private int id_anime;
	private int capitulos;
	
	public Temporada(int id, int numeroTemporada,String titulo, String titulojapones, int id_anime, int capitulos) {
		super();
		this.id = id;
		this.numeroTemporada=numeroTemporada;
		this.titulo = titulo;
		this.titulojapones = titulojapones;
		this.id_anime = id_anime;
		this.capitulos = capitulos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroTemporada() {
		return numeroTemporada;
	}

	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulojapones() {
		return titulojapones;
	}

	public void setTitulojapones(String titulojapones) {
		this.titulojapones = titulojapones;
	}

	public int getId_anime() {
		return id_anime;
	}

	public void setId_anime(int id_anime) {
		this.id_anime = id_anime;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}

	@Override
	public String toString() {
		return "Temporada [numeroTemporada=" + numeroTemporada + ", titulojapones=" + titulojapones + ", capitulos="
				+ capitulos + "]";
	}
	
	

}
