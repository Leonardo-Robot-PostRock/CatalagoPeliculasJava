package ar.com.lgp.peliculas.servicio;

import ar.com.lgp.peliculas.datos.AccesoDatosImpl;
import ar.com.lgp.peliculas.datos.IAccesoDatos;
import ar.com.lgp.peliculas.domain.Pelicula;
import ar.com.lgp.peliculas.excepciones.AccesoDatosEx;
import ar.com.lgp.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalagoPeliculas {

	private final IAccesoDatos datos;

	public CatalogoPeliculasImpl(IAccesoDatos datos) {
		this.datos = new AccesoDatosImpl();
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso a datos");
			ex.printStackTrace();
		}
	}

	@Override
	public void listarPelicula() {
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for (Pelicula pelicula : peliculas) {
				System.out.println("película = " + pelicula);
			}
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso datos");
			ex.printStackTrace(System.out);
		}

	}

	@Override
	public void buscarPelicula(String buscar) {
		String resultado = null;

		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
		} catch (AccesoDatosEx ex) {
			System.out.println("Error de acceso datos");
			ex.printStackTrace(System.out);
		}
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		try {
			if (this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			} else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx ex) {
			System.out.println("Error al iniciar catalogo de películas");
			ex.printStackTrace(System.out);
		}
	}

}
