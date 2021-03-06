package spring.boot.rest.api.alunos.service.impl;

import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.repository.AlunoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDateTime;

import static org.mockito.Mockito.verify;

@SpringJUnitConfig
class AlunoServiceUnitTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
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
    void salvar() {
        alunoService.salvar(aluno);

        verify(alunoRepository).save(aluno);
    }
}