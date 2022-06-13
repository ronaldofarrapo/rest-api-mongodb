package spring.boot.rest.api.alunos.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.boot.rest.api.alunos.DatabaseIntegrationTestBase;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.entity.utils.AlunoEntityObjectMother;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlunoRepositoryQueriesIntegrationTest extends DatabaseIntegrationTestBase {

    @Autowired
    private AlunoRepository alunoRepository;
    private final String cpfCadastrado = "00064588874";
    private final String cpfNaoCadastrado = "35605396099";
    private Aluno aluno;

    @BeforeEach
    void setUp(){
        aluno = AlunoEntityObjectMother.comTodosOsDados();
        aluno.setId(null);
        alunoRepository.save(aluno);
    }

    @Test
    void comCpfCadastrado() {
        Optional<Aluno> retorno = alunoRepository.findByCpf(cpfCadastrado);

        Aluno expected = this.aluno;
        retorno.ifPresent(actual -> {
            assertEquals(expected, actual);
        });
    }

    @Test
    void comCpfNaoCadastrado(){
        Optional<Aluno> retorno = alunoRepository.findByCpf(cpfNaoCadastrado);

        assertTrue(retorno.isEmpty());
    }
}