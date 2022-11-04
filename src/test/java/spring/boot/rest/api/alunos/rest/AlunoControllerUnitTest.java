package spring.boot.rest.api.alunos.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.entity.utils.AlunoEntityObjectMother;
import spring.boot.rest.api.alunos.facade.impl.AlunoFacade;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AlunoController.class)
class AlunoControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoFacade alunoFacade;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void salvar() throws Exception {
        Aluno aluno = AlunoEntityObjectMother.comTodosOsDados();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.mockMvc.perform(post("/alunos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsBytes(aluno)))
                .andExpect(status().isCreated());
    }

}