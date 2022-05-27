package br.mp.mprj.techday.alunos.repository;

import br.mp.mprj.techday.alunos.DatabaseIntegrationTestBase;
import br.mp.mprj.techday.alunos.entity.Aluno;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
    void salvandoComSucesso(){
        Aluno alunoNovo = alunoRepository.save(this.aluno);

        Optional<Aluno> alunoExpected = alunoRepository.findById(alunoNovo.getId());

        alunoExpected.ifPresent(aluno -> {
            assertThat(aluno.getNome(), is(this.aluno.getNome()));
            assertThat(aluno.getCpf(), is(this.aluno.getCpf()));
            assertThat(aluno.getEndereco(), is(this.aluno.getEndereco()));
        });
    }

    @Test
    void verificarQuantidadeIncluida(){
        alunoRepository.save(this.aluno);

        List<Aluno> all = alunoRepository.findAll();

        assertThat(all.size(), is(1));
    }

}
