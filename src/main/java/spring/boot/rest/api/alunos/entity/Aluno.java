package spring.boot.rest.api.alunos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aluno")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 5016284151239769022L;

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NotNull
    private String nome;
    private String cpf;
    private String endereco;
    private String numeroCartaoCredito;
    private String matricula;
    private LocalDateTime dataCadastro;

}
