package br.com.jessesnow.Clinic_management.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FichaPaciente")
public class PacienteModel {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name="PacienteID")
  public Integer pacienteID;

  public String nomeCompleto;
  public String cpf;
  public String email;
  public String celular;
  public String endereco;
  public String sexo;
  public Integer idade;
  public Integer planoDeSaude;
  public String nomePlanoDeSaude;
  public String diagnostico;
  public String procedimentos;
  public String medicamentos;

  public Integer getPacienteID(){
    return pacienteID;
  }
  public void setPacienteID(Integer pacienteID){
    this.pacienteID = pacienteID;
  }
  
  public String getnomeCompleto(){
    return nomeCompleto;
  }
  public void setnomeCompleto(String nomeCompleto){
    this.nomeCompleto = nomeCompleto; 
  }

  public String getCpf(){
    return cpf;
  }
  public void setCpf(String cpf){
    this.cpf = cpf;
  }

  public String getEmail(){
    return email;
  }
  public void setEmail(String email){
    this.email = email;
  }

  public String getCelular(){
    return celular;
  }
  public void setCelular(String celular){
    this.celular = celular;
  }

  public String getEndereco(){
    return endereco;
  }
  public void setEndereco(String endereco){
    this.endereco = endereco;
  }

  public String getSexo(){
    return sexo;
  }
  public void setSexo(String sexo){
    this.sexo = sexo;
  }

  public Integer getIdade(){
    return idade;
  }
  public void setIdade(Integer idade){
    this.idade = idade;
  }

  public Integer getPlanoDeSaude(){
    return planoDeSaude;
  }
  public void setPlanoDeSaude(Integer planoDeSaude){
    this.planoDeSaude = planoDeSaude;
  }

  public String getNomePlanoDeSaude(){
    return nomePlanoDeSaude;
  }
  public void setNomePlanoDeSaude(String nomePlanoDeSaude){
    this.nomePlanoDeSaude = nomePlanoDeSaude;
  }

  public String getDiagnostico(){
    return diagnostico;
  }
  public void setDiagnostico(String diagnostico){
    this.diagnostico = diagnostico;
  }

  public String getProcedimentos(){
    return procedimentos;
  }
  public void setProcedimentos(String procedimentos){
    this.procedimentos = procedimentos;
  }

  public String getMedicamentos(){
    return medicamentos;
  }
  public void setMedicamentos(String medicamentos){
    this.medicamentos = medicamentos;
  }
}
