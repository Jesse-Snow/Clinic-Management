package br.com.jessesnow.repository;

import br.com.jessesnow.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel,Integer>{
  
}
