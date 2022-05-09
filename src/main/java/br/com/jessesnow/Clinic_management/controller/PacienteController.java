package br.com.jessesnow.Clinic_management.controller;

import br.com.jessesnow.Clinic_management.model.PacienteModel;
import br.com.jessesnow.Clinic_management.repository.PacienteRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping 
  public PacienteModel createPacientes(@RequestBody PacienteModel pacienteModel){
    return pacienteRepository.save(pacienteModel);
  }

  @PutMapping(value="/{PacienteID}")
  public ResponseEntity update(@PathVariable("PacienteID") Integer PacienteID,@RequestBody PacienteModel pacienteModel){

    return pacienteRepository.findById(PacienteID)
      .map( record -> { 
        record.setnomeCompleto(pacienteModel.getnomeCompleto());  
        record.setCpf(pacienteModel.getCpf());
        record.setSexo(pacienteModel.getSexo());
        record.setEmail(pacienteModel.getEmail());
        record.setIdade(pacienteModel.getIdade());
        record.setCelular(pacienteModel.getCelular());
        record.setEndereco(pacienteModel.getEndereco());
        record.setDiagnostico(pacienteModel.getDiagnostico());
        record.setMedicamentos(pacienteModel.getMedicamentos());
        record.setPlanoDeSaude(pacienteModel.getPlanoDeSaude());
        record.setProcedimentos(pacienteModel.getProcedimentos());
        record.setNomePlanoDeSaude(pacienteModel.getNomePlanoDeSaude());
        PacienteModel updated = pacienteRepository.save(record);
        return ResponseEntity.ok().body(updated);
      }).orElse(ResponseEntity.notFound().build());
  } 


  @DeleteMapping(path = "/{PacienteID}")
  public ResponseEntity deletePacientes(@PathVariable Integer PacienteID){
    return pacienteRepository.findById(PacienteID)
      .map( record -> {
        pacienteRepository.deleteById(PacienteID);
        return ResponseEntity.ok().build();
      }).orElse(ResponseEntity.notFound().build());
  }
  
}
