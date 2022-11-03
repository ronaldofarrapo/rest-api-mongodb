package spring.boot.rest.api.alunos.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.facade.IAlunoFacade;
import spring.boot.rest.api.alunos.service.impl.AlunoService;
import spring.boot.rest.api.alunos.service.impl.AlunoValidateService;

@Service
@RequiredArgsConstructor
public class AlunoFacade implements IAlunoFacade {

    private final AlunoService alunoService;
    private final AlunoValidateService alunoValidateService;

    @Override
    public Aluno salvar(Aluno aluno) {
        alunoValidateService.validarCpfDuplicado(aluno.getCpf());
        alunoValidateService.validarTamanhoCpf(aluno.getCpf());

        return alunoService.salvar(aluno);
    }
}
