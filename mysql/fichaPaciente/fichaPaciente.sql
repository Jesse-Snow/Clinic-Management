CREATE TABLE IF NOT EXISTS FichaPaciente (
  PacienteID INT NOT NULL AUTO_INCREMENT,
  NomeCompleto VARCHAR(255) NOT NULL,
  CPF INT NOT NULL UNIQUE,
  Email VARCHAR(255),
  Celular INT NOT NULL,
  Endereco VARCHAR(255) NOT NULL,
  Sexo CHAR(1),
  Idade INT NOT NULL,
  PlanoDeSaude BOOLEAN NOT NULL,
  NomePlanoDeSaude VARCHAR(255),
  Diagnostico VARCHAR(2000),
  Procedimentos VARCHAR(2000),
  Medicamentos VARCHAR(2000),
  PRIMARY KEY (PacienteID)
);
