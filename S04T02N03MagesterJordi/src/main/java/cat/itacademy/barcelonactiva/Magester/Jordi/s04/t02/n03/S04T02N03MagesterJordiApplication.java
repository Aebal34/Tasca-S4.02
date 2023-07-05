package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Repositories")
public class S04T02N03MagesterJordiApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N03MagesterJordiApplication.class, args);
	}

}
