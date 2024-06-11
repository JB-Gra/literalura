package com.aluracursos.literalura.model;

import java.util.List;

public class Libro {
  private String titulo;
  private List<DatosAutor> autor;
  private List<String> idioma;
  private Integer numeroDescarga;

  public Libro(String titulo, DatosLibros l) {
    this.titulo = l.titulo();
    this.autor = l.autor();
    this.idioma = l.idioma();
    this.numeroDescarga = Integer.valueOf(l.numeroDescargas());
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public List<DatosAutor> getAutor() {
    return autor;
  }

  public void setAutor(List<DatosAutor> autor) {
    this.autor = autor;
  }

  public List<String> getIdioma() {
    return idioma;
  }

  public void setIdioma(List<String> idioma) {
    this.idioma = idioma;
  }

  public Integer getNumeroDescarga() {
    return numeroDescarga;
  }

  public void setNumeroDescarga(Integer numeroDescarga) {
    this.numeroDescarga = numeroDescarga;
  }

  @Override
  public String toString() {
    return
        "----- LIBRO -----" +
        "\nTitulo: " + titulo +
        "\nAutor: " + autor.get(0).nombre() +
        "\nIdioma: " + idioma.get(0) +
        "\nNúmero de descargas: " + numeroDescarga +
        "\n-----------------\n";
  }
}
