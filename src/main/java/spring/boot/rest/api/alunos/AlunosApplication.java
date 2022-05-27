package spring.boot.rest.api.alunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class AlunosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlunosApplication.class);
	}

	@Bean
	public ValidatingMongoEventListener validatingMongoEventListener(final LocalValidatorFactoryBean factoryBean){
		return new ValidatingMongoEventListener(factoryBean);
	}

}
