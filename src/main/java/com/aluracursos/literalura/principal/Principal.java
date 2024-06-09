package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Datos;
import com.aluracursos.literalura.model.DatosLibros;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
  private ConsumoAPI consumoAPI = new ConsumoAPI();
  private ConvierteDatos conversor = new ConvierteDatos();
  private Scanner teclado = new Scanner(System.in);
  private static final String URL_BASE = "https://gutendex.com/books/";

  public void muestraMenu() {
    var opcion = -1;

    while (opcion != 0) {
      String menu = """
        *** LITERALURA ***
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
        case 1:
          buscarLibroPorTitulo();
          break;
        case 3:
          buscarAutoresRegistrados();
          break;
        case 4:
          mostrarAutoresVivosEnUnaEpoca();
          break;
        case 5:
          mostrarLibrosPorIdioma();
          break;
        case 0:
          System.out.println("Cerrando la aplicación...");
          break;
        default:
          System.out.println("Opción invalida");
      }
    }
  }

  private void buscarLibroPorTitulo() {
    System.out.println("Ingrese el titulo del libro a buscar:");
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
    var idiomaCodigo = teclado.nextLine();
    var json = consumoAPI.obtenerDatos(URL_BASE + "?languages=" + idiomaCodigo.toLowerCase());
    var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

    if (idiomaCodigo.length() == 2) {
      List<DatosLibros> librosEnIdioma = datosBusqueda.resultados().stream()
          .filter(l -> l.idioma().contains(idiomaCodigo.toLowerCase()))
          .limit(10)
          .collect(Collectors.toList());

      librosEnIdioma.forEach(System.out::println);
    } else {
      System.out.println("Idioma no encontrado");
    }
  }

  private void buscarAutoresRegistrados() {
    System.out.println("Ingrese el nombre del autor que desee buscar:");
  }

  private void mostrarAutoresVivosEnUnaEpoca() {
    System.out.println("Escriba el año que desee buscar:");
    var fechaDeVida = teclado.nextInt();
  }
}
