package spring.boot.rest.api.alunos.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.entity.utils.AlunoEntityObjectMother;
import spring.boot.rest.api.alunos.exception.BusinessException;
import spring.boot.rest.api.alunos.repository.AlunoRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class AlunoValidateServiceTest {

    @InjectMocks
    private AlunoValidateService validateService;

    @Mock
    private AlunoRepository alunoRepository;

    private Optional<Aluno> aluno;
    private final String cpf = "00064588874";

    @BeforeEach
    void setUp(){
        aluno = Optional.of(AlunoEntityObjectMother.comTodosOsDados());
    }

    @Test
    void validarCpfDuplicado() {

        when(alunoRepository.findByCpf(cpf)).thenReturn(aluno);

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            validateService.validarCpfDuplicado(cpf);
        });

        String expectedMessage = "Já existe um aluno com o CPF informado.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);

    }

    @Test
    void validarCpfDuplicadoComUmNovoAluno(){
        when(alunoRepository.findByCpf(cpf)).thenReturn(Optional.empty());

        try {
            validateService.validarCpfDuplicado(cpf);
        } catch (BusinessException ex) {
            fail("Não deveria cair nessa Exception.");
        }
    }

    @Test
    void cpfInvalidoTamanhoMenor() {
        String tamanhoMenor = "0214754875";
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            validateService.validarTamanhoCpf(tamanhoMenor);
        });

        String expectedMessage = "CPF inválido.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void cpfInvalidoTamanhoMaior(){
        String tamanhoMaior = "021475487569";
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            validateService.validarTamanhoCpf(tamanhoMaior);
        });

        String expectedMessage = "CPF inválido.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void cpfValido(){
        String cpf = "02147548756";
        try {
            validateService.validarTamanhoCpf(cpf);
        } catch (BusinessException ex) {
            fail("Não deveria cair nessa Exception.");
        }
    }
}