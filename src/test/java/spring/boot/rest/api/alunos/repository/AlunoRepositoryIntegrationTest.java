package spring.boot.rest.api.alunos.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.boot.rest.api.alunos.DatabaseIntegrationTestBase;
import spring.boot.rest.api.alunos.entity.Aluno;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlunoRepositoryIntegrationTest extends DatabaseIntegrationTestBase {

    @Autowired
    private AlunoRepository alunoRepository;
    private Aluno aluno;

    @BeforeEach
    void setUp(){
        aluno = Aluno.builder()
                .nome("Guedes")
                .cpf("00064588874")
                .dataCadastro(LocalDateTime.now())
                .endereco("Rua Conde de Bonfim")
                .build();
    }

    @Test
    void comSucesso(){
        Aluno alunoNovo = alunoRepository.save(this.aluno);

        Optional<Aluno> resultado = alunoRepository.findById(alunoNovo.getId());

        resultado.ifPresent(expected -> {
            assertThat(expected.getNome(), is(this.aluno.getNome()));
            assertThat(expected.getCpf(), is(this.aluno.getCpf()));
            assertThat(expected.getEndereco(), is(this.aluno.getEndereco()));
        });
    }

    @Test
    void comNomeNaoInformado() {
        this.aluno.setNome(null);

        ConstraintViolationException exception = assertThrows(ConstraintViolationException.class, () -> alunoRepository.save(this.aluno));

        String expectedMessage = "nome: não deve ser nulo";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void verificarQuantidadeIncluida(){
        alunoRepository.save(this.aluno);

        List<Aluno> all = alunoRepository.findAll();

        assertThat(all.size(), is(1));
    }

}
