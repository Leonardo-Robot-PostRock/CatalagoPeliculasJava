package ar.com.lgp.peliculas.presentacion;

import java.util.Scanner;

import ar.com.lgp.peliculas.servicio.CatalogoPeliculasImpl;
import ar.com.lgp.peliculas.servicio.ICatalagoPeliculas;

public class CatalogoPeliculasPresentacion {
	public static void main(String[] args) {
		var opcion = -1;

		var scanner = new Scanner(System.in);
		// Bajo Acoplamiento: se ultiliza la menor cantidad de veces las relaciones
		// entre clases.
		// Alta cohesion: cada clase se encarga de realizar su tarea y no más.
		ICatalagoPeliculas catalogo = new CatalogoPeliculasImpl();

		while (opcion != 0) {
			System.out.println("Elige una opción:\n" + "1. Iniciar catalogo películas\n" + "2. Agregar película\n"
					+ "3. Listar películas\n" + "4. Buscar película\n" + "0. Salir");
			opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("Introduce el nombre de la película");
				var nombrePelicula = scanner.nextLine();
				catalogo.agregarPelicula(nombrePelicula);
				break;
			case 3:
				catalogo.listarPelicula();
				break;
			case 4:
				System.out.println("Introduce una película a buscar");
				var buscar = scanner.nextLine();
				catalogo.buscarPelicula(buscar);
				break;
			case 0:
				System.out.println("Hasta Pronto!");
				break;
			default:
				System.out.println("Opción no reconocida");
				break;
			}

		}
	}
}
