package spring.boot.rest.api.alunos.service.impl;

import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.repository.AlunoRepository;
import spring.boot.rest.api.alunos.service.IAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService implements IAlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    public Aluno salvar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
}
