package spring.boot.rest.api.alunos.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "aluno")
public class Aluno implements Serializable {

    private static final long serialVersionUID = 5016284151239769022L;

    @MongoId(FieldType.OBJECT_ID)
    private String id;
    @NotBlank
    private String nome;
    private String cpf;
    private String endereco;
    @NotBlank
    private String numeroCartaoCredito;
    private String matricula;
    private LocalDateTime dataCadastro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return cpf.equals(aluno.cpf) && matricula.equals(aluno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, matricula);
    }
}
