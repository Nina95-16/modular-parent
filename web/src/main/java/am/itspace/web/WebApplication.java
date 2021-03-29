package am.itspace.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"am.itspace.common.*", "am.itspace.web.*"})
@EnableJpaRepositories(basePackages = {"am.itspace.common.*", "am.itspace.web.*"})
@EntityScan("am.itspace.common.*")
@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
