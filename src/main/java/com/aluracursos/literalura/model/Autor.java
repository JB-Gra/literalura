package com.aluracursos.literalura.model;

public class Autor {
  private String nombre;
  private Integer nacimiento;
  private Integer deceso;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Integer getNacimiento() {
    return nacimiento;
  }

  public void setNacimiento(Integer nacimiento) {
    this.nacimiento = nacimiento;
  }

  public Integer getDeceso() {
    return deceso;
  }

  public void setDeceso(Integer deceso) {
    this.deceso = deceso;
  }
}
