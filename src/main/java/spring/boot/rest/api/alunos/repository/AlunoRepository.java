package spring.boot.rest.api.alunos.repository;

import spring.boot.rest.api.alunos.entity.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
