package pojos;

public class Anime {
	private int id;
	private String titulo;
	private String titulojapones;
	private boolean enEmision;
	public Anime(int id, String titulo, String titulojapones, boolean enEmision) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.titulojapones = titulojapones;
		this.enEmision = enEmision;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isEnEmision() {
		return enEmision;
	}
	public void setEnEmision(boolean enEmision) {
		this.enEmision = enEmision;
	}
	@Override
	public String toString() {
		return "Anime [id=" + id + ", titulojapones=" + titulojapones + ", enEmision=" + enEmision + "]";
	}

	
	
}
