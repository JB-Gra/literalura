package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Datos;
import com.aluracursos.literalura.model.DatosLibros;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
  private ConsumoAPI consumoAPI = new ConsumoAPI();
  private ConvierteDatos conversor = new ConvierteDatos();
  private Scanner teclado = new Scanner(System.in);
  private static final String URL_BASE = "https://gutendex.com/books/";

  public void muestraMenu() {
    var opcion = -1;

    while (opcion != 0) {
      String menu = """
        Elija la opción deseada:
        1 - Buscar y registrar libro por titulo
        2 - Mostrar libros registrados
        3 - Mostrar autores registrados
        4 - Mostrar autores vivos en un determinado año
        5 - Mostrar libros por idioma
        0 - Salir
        """;
      System.out.println(menu);
      opcion = teclado.nextInt();
      teclado.nextLine();

      switch (opcion) {
        case 0:
          System.out.println("Cerrando la aplicación...");
          break;
        case 1:
          buscarLibroPorTitulo();
          break;
        case 5:
          mostrarLibrosPorIdioma();
          break;
        default:
          System.out.println("Opción invalida");
      }
    }

  }

  private void buscarLibroPorTitulo() {
    System.out.println("Ingrese el titulo del libro a buscar");
    var tituloLibro = teclado.nextLine();
    var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ","+"));
    var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
    Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
        .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
        .findFirst();
    if(libroBuscado.isPresent()){
      System.out.println("Libro Encontrado ");
      System.out.println(libroBuscado.get());
    } else {
      System.out.println("Libro no encontrado");
    }
  }

  private void mostrarLibrosPorIdioma() {
    String listadoIdiomas = """
        *** CÓDIGOS DE IDIOMA ***
        Español -> es
        Inglés -> en
        Portugués -> pt
        Francés -> fr
        Italiano -> it
        """;
    System.out.println(listadoIdiomas);
    System.out.println("¿Cuál es el idioma que desea buscar?");
    var idioma = teclado.nextLine();
    var json = consumoAPI.obtenerDatos(URL_BASE + "?languages=" + idioma.toLowerCase());
    var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

    Optional<DatosLibros> idiomaBuscado = datosBusqueda.resultados().stream()
        .filter(l -> l.idioma().contains(idioma.toLowerCase()))
        .findFirst();
    if(idiomaBuscado.isPresent()){
      System.out.println("Libros econtrados en el idioma \'" + idioma + "\'");
      System.out.println(idiomaBuscado.get());
    } else {
      System.out.println("Idioma no encontrado");
    }
  }
}
