package br.com.jessesnow.controller;

import br.com.jessesnow.model.PacienteModel;
import br.com.jessesnow.repository.PacienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pacientes"})
public class PacienteController {

  @Autowired(required=false)
  private PacienteRepository pacienteRepository;

  @GetMapping
  public List<PacienteModel> findPacientes(){
    return pacienteRepository.findAll();
  }
}
