package ar.com.lgp.peliculas.datos;

import java.util.List;

import ar.com.lgp.peliculas.domain.Pelicula;
import ar.com.lgp.peliculas.excepciones.AccesoDatosEx;
import ar.com.lgp.peliculas.excepciones.EscrituraDatosEx;
import ar.com.lgp.peliculas.excepciones.LecturaDatosEx;

public interface IAccesoDatos {
	
	public boolean existe(String nombreRecurso) throws AccesoDatosEx;

	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;

	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

	public void crear(String nombreRecurso) throws AccesoDatosEx;

	public void borrar(String nombreRecurso) throws AccesoDatosEx;

}
