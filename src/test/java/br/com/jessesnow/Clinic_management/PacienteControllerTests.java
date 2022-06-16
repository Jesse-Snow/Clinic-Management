package br.com.jessesnow.Clinic_management;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.jessesnow.Clinic_management.model.PacienteModel;

@SpringBootTest()
@AutoConfigureMockMvc
public class PacienteControllerTests {

  @Autowired
  MockMvc mockMvc;

  @Autowired 
  ObjectMapper ObjectMapper;

  @Test
  public void GET_ALL_Should_Return_OK_And_TypeJson() throws Exception{
    this.mockMvc.perform(MockMvcRequestBuilders.get("/pacientes"))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
  }

 @Test
 public void GET_BY_ID_Should_Return_Ok_And_Correct_Name() throws Exception{
   this.mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/1"))
     .andExpect(MockMvcResultMatchers.status().isOk())
     .andExpect(MockMvcResultMatchers.jsonPath("nomeCompleto").value("Sam Roger"));
 }


  // Need to fix this and Delete this Row in Database
  @Test 
  public void POST_Should_Return_Ok() throws Exception {
    PacienteModel pacienteModel = new PacienteModel();
    pacienteModel.setnomeCompleto("Samus Aram");
    pacienteModel.setCpf("6134124125553");                          
    pacienteModel.setSexo("F");                        
    pacienteModel.setEmail("samus@email");
    pacienteModel.setIdade(31);
    pacienteModel.setCelular("91341346");
    pacienteModel.setEndereco("Far from this Planet,Dark Aether");
    pacienteModel.setDiagnostico("Infecção por X Parasite");
    pacienteModel.setMedicamentos("Injeção Metroid");
    pacienteModel.setPlanoDeSaude(0);
    pacienteModel.setProcedimentos("Utilizar Injeção Metroid");
    pacienteModel.setNomePlanoDeSaude("");
    String requestJson = ObjectMapper.writeValueAsString(pacienteModel); 

    this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestJson)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
