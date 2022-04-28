package com.crud.democrud.ServicesTest;


import com.crud.democrud.models.RolModel;
import com.crud.democrud.models.UsuarioModel;
import com.crud.democrud.repositories.RolRepository;
import com.crud.democrud.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class RolServiceTest {

  @Autowired
  RolRepository rolRepository;

  @Test
  public void testGuardarRol(){
    RolModel rolModel =new RolModel("Contratista");
    RolModel rolModelRegistrado = rolRepository.save(rolModel);
    assertNotNull(rolModelRegistrado );
  }

  @Test
  public void testListarUsuarios(){
    List<RolModel> rolModelList=(List<RolModel>) rolRepository.findAll();
    assertThat(rolModelList).size().isGreaterThan(0);
  }


}
