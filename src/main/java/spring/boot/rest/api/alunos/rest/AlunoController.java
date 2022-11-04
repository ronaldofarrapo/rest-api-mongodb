package spring.boot.rest.api.alunos.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.rest.api.alunos.entity.Aluno;
import spring.boot.rest.api.alunos.facade.impl.AlunoFacade;

@RestController
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoFacade alunoFacade;

    @PostMapping("/alunos")
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno) {
        return new RestResponses<Aluno>().created(alunoFacade.salvar(aluno));
    }

}
