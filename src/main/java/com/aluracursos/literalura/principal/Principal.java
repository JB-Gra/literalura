package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
  private ConsumoAPI consumoAPI = new ConsumoAPI();
  private ConvierteDatos conversor = new ConvierteDatos();
  private Scanner teclado = new Scanner(System.in);
  private static final String URL_BASE = "https://gutendex.com/books/";

  public void muestraMenu() {
    var json = consumoAPI.obtenerDatos(URL_BASE);
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
        default:
          System.out.println("Opción invalida");
      }
    }

  }
}
