package com.crud.democrud.models;


import javax.persistence.*;

@Entity
@Table(name = "rol")

public class RolModel {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long idRol;

  private String rol;

  public RolModel() {
  }

  public RolModel(String rol) {
    this.rol = rol;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

}
