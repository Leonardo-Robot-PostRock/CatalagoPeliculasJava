package ar.com.lgp.peliculas.datos;

import java.io.*;
import java.util.*;

import ar.com.lgp.peliculas.domain.Pelicula;
import ar.com.lgp.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

	@Override
	public boolean existe(String nombreRecurso) throws AccesoDatosEx {
		var archivo = new File(nombreRecurso);
		return archivo.exists();
	}

	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
		var archivo = new File(nombreRecurso);
		List<Pelicula> peliculas = new ArrayList<Pelicula>();

		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String linea = null;
			linea = entrada.readLine();

			while (linea != null) {
				var pelicula = new Pelicula(linea);
				peliculas.add(pelicula);
				linea = entrada.readLine();
			}

			entrada.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Excepción al listar películas:" + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Excepción al listar películas:" + ex.getMessage());
		}
		return peliculas;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
		var archivo = new File(nombreRecurso);

		try {

			var salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.toString());
			salida.close();
			System.out.println("Se ha escrito información al archivo: " + pelicula);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new EscrituraDatosEx("Excepción al escribir películas:" + ex.getMessage());
		}
	}

	@Override
	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
		return null;
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {

	}

	@Override
	public void borrar(String nombreRecurso) throws AccesoDatosEx {

	}

}
