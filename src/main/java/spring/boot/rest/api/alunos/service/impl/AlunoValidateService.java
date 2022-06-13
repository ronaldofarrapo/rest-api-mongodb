package spring.boot.rest.api.alunos.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.exception.BusinessException;
import spring.boot.rest.api.alunos.repository.AlunoRepository;
import spring.boot.rest.api.alunos.service.IAlunoValidateService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlunoValidateService implements IAlunoValidateService {

    private final AlunoRepository alunoRepository;

    @Override
    public void validarCpfDuplicado(String cpf) {
        Optional<Aluno> expected = alunoRepository.findByCpf(cpf);
        expected.ifPresent(aluno -> {throw new BusinessException("Já existe um aluno com o CPF informado.");});

    }

    @Override
    public void validarCpfInvalido(String cpf) {

    }
}
