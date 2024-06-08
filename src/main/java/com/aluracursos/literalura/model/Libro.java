package com.aluracursos.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class Libro {
  private String titulo;
  private List<DatosAutor> autor;
  private List<String> idioma;
  private Double numeroDescarga;

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

  public Double getNumeroDescarga() {
    return numeroDescarga;
  }

  public void setNumeroDescarga(Double numeroDescarga) {
    this.numeroDescarga = numeroDescarga;
  }
}
