package spring.boot.rest.api.alunos.service;

public interface IAlunoValidateService {
    void validarCpfDuplicado(String cpf);
    void validarCpfInvalido(String cpf);
}
