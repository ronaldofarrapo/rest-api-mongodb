package br.mp.mprj.techday.alunos.service.impl;

import br.mp.mprj.techday.alunos.entity.Aluno;
import br.mp.mprj.techday.alunos.repository.AlunoRepository;
import br.mp.mprj.techday.alunos.service.IAlunoService;
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
