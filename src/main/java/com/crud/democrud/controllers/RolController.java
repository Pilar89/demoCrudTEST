package com.crud.democrud.controllers;

import com.crud.democrud.models.RolModel;
import com.crud.democrud.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/rol")

public class RolController {

  @Autowired
  RolService rolService;

  @GetMapping()
  public ArrayList<RolModel> obtenerRoles() {
    return rolService.obtenerRoles();
  }

  @PostMapping()
  public RolModel guardarRol (@RequestBody RolModel rol) {
    return this.rolService.guardarRol(rol);
  }

  @GetMapping(path = "/{id}")
  public Optional<RolModel> obtenerRolPorId(@PathVariable("idRol") Long idRol) {
    return this.rolService.obtenerPorId(idRol);
  }

  @DeleteMapping(path = "/{id}")
  public String eliminarPorId(@PathVariable("idRol") Long idRol) {
    boolean ok = this.rolService.eliminarRol(idRol);
    if (ok) {
      return "Se eliminó el usuario con id " + idRol;
    } else {
      return "No pudo eliminar el usuario con id" + idRol;
    }
  }


}
