package com.crud.democrud.controllers;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.services.RolService;
import com.crud.democrud.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
  @Autowired UsuarioService usuarioService;

  @Autowired RolService rolService;

  @GetMapping()
  public ArrayList<UsuarioModel> obtenerUsuarios() {
    return usuarioService.obtenerUsuarios();
  }

  @PostMapping()
  public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario) {
    return this.usuarioService.guardarUsuario(usuario);
  }

  @PostMapping(path = "/{id}/rol/{idRol}")
  public void agregarUsuarioRol(@PathVariable long id, @PathVariable long idRol) {
    Optional<UsuarioModel> usuarioEncontrado = this.usuarioService.obtenerPorId(id);
    Optional<RolModel> rolEncontrado = this.rolService.obtenerPorId(idRol);
    if (usuarioEncontrado.isEmpty() || rolEncontrado.isEmpty()) {
      return;
    }

    UsuarioModel usuarioMasRol = usuarioEncontrado.get();
    RolModel elRol = rolEncontrado.get();
    List<RolModel> rolesDelUsuario = usuarioMasRol.getRoles();
    rolesDelUsuario.add(elRol);

    this.usuarioService.guardarUsuario(usuarioMasRol);
  }

  @PatchMapping(path = "/{id}")
  public void updateusuario(@PathVariable long id, @RequestBody UsuarioModel usuario) {
    Optional<UsuarioModel> usuarioEncontrado = this.usuarioService.obtenerPorId(id);
    if (usuarioEncontrado.isEmpty()) {
      return;
    }

    UsuarioModel viejoUsuario = usuarioEncontrado.get();

    if (!usuario.nombreEsNulo()) {
      viejoUsuario.setNombre(usuario.getNombre());
    }

    if (!usuario.emailEsNulo()) {
      viejoUsuario.setEmail(usuario.getEmail());
    }

    if (!usuario.prioridadEsNulo()) {
      viejoUsuario.setPrioridad(usuario.getPrioridad());
    }

    this.usuarioService.guardarUsuario(viejoUsuario);
  }

  @GetMapping(path = "/{id}")
  public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
    return this.usuarioService.obtenerPorId(id);
  }

  @GetMapping("/query")
  public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(
      @RequestParam("prioridad") Integer prioridad) {
    return this.usuarioService.obtenerPorPrioridad(prioridad);
  }

  @DeleteMapping(path = "/{id}")
  public String eliminarPorId(@PathVariable("id") Long id) {
    boolean ok = this.usuarioService.eliminarUsuario(id);
    if (ok) {
      return "Se eliminó el usuario con id " + id;
    } else {
      return "No pudo eliminar el usuario con id" + id;
    }
  }
}
