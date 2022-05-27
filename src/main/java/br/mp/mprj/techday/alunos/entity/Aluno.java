package br.mp.mprj.techday.alunos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aluno")
public class Aluno {

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String nome;
    private String cpf;
    private String endereco;
    private String numeroCartaoCredito;
    private String matricula;
    private LocalDateTime dataCadastro;

}
