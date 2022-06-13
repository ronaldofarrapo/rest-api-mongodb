package spring.boot.rest.api.alunos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring.boot.rest.api.alunos.entity.Aluno;

import java.util.Optional;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
    Optional<Aluno> findByCpf(String cpf);
}
