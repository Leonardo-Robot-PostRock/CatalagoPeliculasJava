package ar.com.lgp.peliculas.servicio;

public interface ICatalagoPeliculas {
	String NOMBRE_RECURSO = "peliculas.txt";

	void agregarPelicula(String nombrePelicula);

	void listarPelicula();

	void buscarPelicula(String buscar);

	void iniciarCatalogoPeliculas();
}
