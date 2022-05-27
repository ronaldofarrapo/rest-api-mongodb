package br.mp.mprj.techday.alunos;

import br.mp.mprj.techday.alunos.entity.Aluno;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootTest
public abstract class DatabaseIntegrationTestBase {
    @Autowired
    private MongoTemplate mongoTemplate;

    @AfterEach
    void limparDados(){
        mongoTemplate.remove(new Query(), Aluno.class);
    }
}
