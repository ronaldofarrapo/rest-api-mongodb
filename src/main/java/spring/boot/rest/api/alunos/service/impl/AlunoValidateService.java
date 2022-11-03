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

    private static final int TAMANHO_CPF = 11;

    private final AlunoRepository alunoRepository;

    @Override
    public void validarCpfDuplicado(String cpf) {
        Optional<Aluno> aluno = alunoRepository.findByCpf(cpf);
        aluno.ifPresent(a -> {
            throw new BusinessException("Já existe um aluno com o CPF informado.");
        });

    }

    @Override
    public void validarTamanhoCpf(String cpf) {
        if(cpf.length() != TAMANHO_CPF){
            throw new BusinessException("CPF inválido.");
        }
    }
}
