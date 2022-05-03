package br.com.jessesnow.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="fichaPaciente")
@Table(name="FichaPaciente")
public class PacienteModel {

  @Id
  @GeneratedValue()
  public Integer PacienteID;

  public String NomeCompleto;
  public String CPF;
  public String Email;
  public String Celular;
  public String Endereco;
  public String Sexo;
  public Integer Idade;
  public Integer PlanoDeSaude;
  public String NomePlanoDeSaude;
  public String Diagnostico;
  public String Procedimentos;
  public String Medicamentos;

  public Integer getPacienteId(){
    return PacienteID;
  }
  public void setPacienteID(Integer PacienteID){
    this.PacienteID = PacienteID;
  }
  
  public String getNomeCompleto(){
    return NomeCompleto;
  }
  public void setNomeCompleto(String NomeCompleto){
    this.NomeCompleto = NomeCompleto; 
  }

  public String getCPF(){
    return CPF;
  }
  public void setCPF(String CPF){
    this.CPF = CPF;
  }

  public String getEmail(){
    return Email;
  }
  public void setEmail(String Email){
    this.Email = Email;
  }

  public String getCelular(){
    return Celular;
  }
  public void setCelular(String Celular){
    this.Celular = Celular;
  }

  public String getEndereco(){
    return Endereco;
  }
  public void setEndereco(String Endereco){
    this.Endereco = Endereco;
  }

  public String getSexo(){
    return Sexo;
  }
  public void setSexo(String Sexo){
    this.Sexo = Sexo;
  }

  public Integer getIdade(){
    return Idade;
  }
  public void setIdade(Integer Idade){
    this.Idade = Idade;
  }

  public Integer getPlanoDeSaude(){
    return PlanoDeSaude;
  }
  public void setPlanoDeSaude(Integer PlanoDeSaude){
    this.PlanoDeSaude = PlanoDeSaude;
  }

  public String getNomePlanoDeSaude(){
    return NomePlanoDeSaude;
  }
  public void setNomePlanoDeSaude(String NomePlanoDeSaude){
    this.NomePlanoDeSaude = NomePlanoDeSaude;
  }

  public String getDiagnostico(){
    return Diagnostico;
  }
  public void setDiagnostico(String Diagnostico){
    this.Diagnostico = Diagnostico;
  }

  public String getProcedimentos(){
    return Procedimentos;
  }
  public void setProcedimentos(String Procedimentos){
    this.Procedimentos = Procedimentos;
  }

  public String getMedicamentos(){
    return Medicamentos;
  }
  public void setMedicamentos(String Medicamentos){
    this.Medicamentos = Medicamentos;
  }
}
