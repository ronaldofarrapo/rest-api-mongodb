package spring.boot.rest.api.alunos.entity.utils;

import spring.boot.rest.api.alunos.entity.Aluno;

import java.time.LocalDateTime;

public class AlunoEntityObjectMother {

    public static Aluno comTodosOsDados(){
        return Aluno.builder()
                .id("123456")
                .nome("Guedes")
                .cpf("00064588874")
                .numeroCartaoCredito("3654585457854215")
                .dataCadastro(LocalDateTime.now())
                .matricula("2022.00001")
                .endereco("Rua Conde de Bonfim")
                .build();
    }
}
