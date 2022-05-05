package br.com.jessesnow.Clinic_management.repository;

import br.com.jessesnow.Clinic_management.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel,Integer>{
  
}
