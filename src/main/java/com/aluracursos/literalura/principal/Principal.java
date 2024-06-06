package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.service.ConsumoAPI;

public class Principal {
  private ConsumoAPI consumoAPI = new ConsumoAPI();
  private final String URL_BASE = "https://gutendex.com/books";

  public void muestraMenu() {
    var json = consumoAPI.obtenerDatos(URL_BASE);
    System.out.println(json);
  }
}
