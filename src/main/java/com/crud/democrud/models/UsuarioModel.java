package com.crud.democrud.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  private String nombre;
  private String email;
  private Integer prioridad;

  public boolean nombreEsNulo() {
    if (this.nombre == null || this.nombre.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean emailEsNulo() {
    if (this.email == null || this.email.isEmpty()) {
      return true;
    }
    return false;
  }

  public boolean prioridadEsNulo() {
    if (this.prioridad == null) {
      return true;
    }
    return false;
  }

  public void setPrioridad(Integer prioridad) {
    this.prioridad = prioridad;
  }

  public Integer getPrioridad() {
    return prioridad;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public UsuarioModel(String nombre, String email, Integer prioridad) {
    this.nombre = nombre;
    this.email = email;
    this.prioridad = prioridad;
  }

  public UsuarioModel() {}

  public void setEmail(String email) {
    this.email = email;
  }

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "UsuarioRol",
      joinColumns = {@JoinColumn(name = "usuario_rol")},
      inverseJoinColumns = {@JoinColumn(name = "rol_usuario")})
  private List<RolModel> roles = new ArrayList<RolModel>();

  public List<RolModel> getRoles() {
    return roles;
  }

  public void setRoles(List<RolModel> roles) {
    this.roles = roles;
  }
}
