package spring.boot.rest.api.alunos.factory.impl;

import org.springframework.stereotype.Component;
import spring.boot.rest.api.alunos.factory.IMatriculaFactory;

import java.util.UUID;

@Component
public class MatriculaFactory implements IMatriculaFactory {
    @Override
    public String gerar() {
        return UUID.randomUUID().toString();
    }
}
