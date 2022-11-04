package spring.boot.rest.api.alunos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.boot.rest.api.alunos.rest.AlunoController;
import spring.boot.rest.api.alunos.service.impl.AlunoService;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AlunosApplicationTests {

	@Autowired
	private AlunoService alunoService;
	@Autowired
	private AlunoController alunoController;
	@Test
	void contextLoads() {
		assertThat(alunoService).isNotNull();
		assertThat(alunoController).isNotNull();
	}
}
