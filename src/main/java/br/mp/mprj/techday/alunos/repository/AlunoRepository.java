package br.mp.mprj.techday.alunos.repository;

import br.mp.mprj.techday.alunos.entity.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends MongoRepository<Aluno, String> {
}
