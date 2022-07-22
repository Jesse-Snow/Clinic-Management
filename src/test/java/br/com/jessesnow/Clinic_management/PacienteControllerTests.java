package br.com.jessesnow.Clinic_management;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.jessesnow.Clinic_management.model.PacienteModel;
import br.com.jessesnow.Clinic_management.repository.PacienteRepository;

@SpringBootTest()
@AutoConfigureMockMvc
public class PacienteControllerTests {

  @Autowired
  MockMvc mockMvc;
  @Autowired
  PacienteRepository pacienteRepository;

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
   this.mockMvc.perform(MockMvcRequestBuilders.get("/pacientes/2"))
     .andExpect(MockMvcResultMatchers.status().isOk())
     .andExpect(MockMvcResultMatchers.jsonPath("nomeCompleto").value("Chris Hamson"));
 }


  // Need to fix this and Delete this Row in Database
  @Test 
  public void POST_And_PUT_And_Delete_Should_Return_Ok() throws Exception {

    // Object of PacienteModel
    PacienteModel pacienteModel = new PacienteModel();
    pacienteModel.setPacienteID(500);
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

    // Test for the POST
    MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestJson)
        .accept(MediaType.APPLICATION_JSON)) .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    
    // Getting id for delete the previous post
    String content = result.getResponse().getContentAsString();
    String id = com.jayway.jsonpath.JsonPath.read(content,"pacienteID").toString();

    
    // Another Object of PacienteModel
    PacienteModel pacienteModel2 = new PacienteModel();
    pacienteModel2.setPacienteID(500);
    pacienteModel2.setnomeCompleto("Samus Nao ARAM");
    pacienteModel2.setCpf("6134124125553");                          
    pacienteModel2.setSexo("F");                        
    pacienteModel2.setEmail("sem email");
    pacienteModel2.setIdade(31);
    pacienteModel2.setCelular("91341346");
    pacienteModel2.setEndereco("Far from this Planet,Dark Aether");
    pacienteModel2.setDiagnostico("Infecção por X Parasite");
    pacienteModel2.setMedicamentos("Injeção Metroid");
    pacienteModel2.setPlanoDeSaude(0);
    pacienteModel2.setProcedimentos("Utilizar Injeção Metroid");
    pacienteModel2.setNomePlanoDeSaude("");
    String requestJson2 = ObjectMapper.writeValueAsString(pacienteModel2); 

     
    // Test for the PUT
    this.mockMvc.perform(MockMvcRequestBuilders.put("/pacientes/".concat(id))
         .contentType(MediaType.APPLICATION_JSON)
         .content(requestJson2)
         .accept(MediaType.APPLICATION_JSON))
         .andExpect(MockMvcResultMatchers.status().isOk());

    // Delete the previous post in the database
    this.mockMvc.perform(MockMvcRequestBuilders.delete("/pacientes/".concat(id))
         .contentType(MediaType.APPLICATION_JSON)
         .accept(MediaType.APPLICATION_JSON))
         .andExpect(MockMvcResultMatchers.status().isOk());
  }

}
