package br.com.jessesnow.Clinic_management.repository;

import br.com.jessesnow.Clinic_management.model.PacienteModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel,Integer>{

  long deleteByNomeCompleto(String nomeCompleto);
}
