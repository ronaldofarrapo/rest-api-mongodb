package spring.boot.rest.api.alunos.facade.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.entity.utils.AlunoEntityObjectMother;
import spring.boot.rest.api.alunos.service.impl.AlunoService;
import spring.boot.rest.api.alunos.service.impl.AlunoValidateService;

import static org.mockito.BDDMockito.inOrder;

@SpringJUnitConfig
class AlunoFacadeUnitTest {

    @InjectMocks
    private AlunoFacade alunoFacade;
    @Mock
    private AlunoService alunoService;
    @Mock
    private AlunoValidateService alunoValidateService;

    private Aluno aluno;

    @BeforeEach
    public void setUp() {
        aluno = AlunoEntityObjectMother.comTodosOsDados();
    }

    @Test
    void salvar(){
        alunoFacade.salvar(aluno);

        InOrder inOrder = inOrder(alunoService, alunoValidateService);

        inOrder.verify(alunoValidateService).validarCpfDuplicado(aluno.getCpf());
        inOrder.verify(alunoValidateService).validarTamanhoCpf(aluno.getCpf());
        inOrder.verify(alunoService).salvar(aluno);
    }

}