package br.com.jessesnow.Clinic_management.controller;

import br.com.jessesnow.Clinic_management.model.PacienteModel;
import br.com.jessesnow.Clinic_management.repository.PacienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/pacientes"})
public class PacienteController {

  @Autowired()
  private PacienteRepository pacienteRepository;

  @GetMapping
  public List<PacienteModel> findPacientes(){
    return pacienteRepository.findAll();
  }

  @GetMapping(path = {"/{PacienteID}"})
  public ResponseEntity findByIdPacientes(@PathVariable Integer PacienteID){
    return pacienteRepository.findById(PacienteID)
      .map(record -> ResponseEntity.ok().body(record))
      .orElse( ResponseEntity.notFound().build());
  }
}
