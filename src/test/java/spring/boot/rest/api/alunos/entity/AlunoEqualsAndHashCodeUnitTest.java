package spring.boot.rest.api.alunos.entity;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.boot.rest.api.alunos.entity.utils.AlunoEntityObjectMother;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringJUnitConfig
class AlunoEqualsAndHashCodeUnitTest {

    @Test
    void iguais(){
        Aluno jose = AlunoEntityObjectMother.comTodosOsDados();
        jose.setCpf("78685792002");
        jose.setMatricula("2022.00001");

        Aluno joao = AlunoEntityObjectMother.comTodosOsDados();
        joao.setCpf("78685792002");
        joao.setMatricula("2022.00001");

        assertEquals(jose, joao);
    }

    @Test
    void diferentesPelaMatricula(){
        Aluno jose = AlunoEntityObjectMother.comTodosOsDados();
        jose.setCpf("14968567081");
        jose.setMatricula("2022.00001");

        Aluno joao = AlunoEntityObjectMother.comTodosOsDados();
        joao.setCpf("14968567081");
        joao.setMatricula("2022.00002");

        assertNotEquals(jose, joao);
    }

    @Test
    void diferentesPeloCPF(){
        Aluno jose = AlunoEntityObjectMother.comTodosOsDados();
        jose.setCpf("14968567081");
        jose.setMatricula("2022.00001");

        Aluno joao = AlunoEntityObjectMother.comTodosOsDados();
        joao.setCpf("78685792002");
        joao.setMatricula("2022.00001");

        assertNotEquals(jose, joao);
    }

}