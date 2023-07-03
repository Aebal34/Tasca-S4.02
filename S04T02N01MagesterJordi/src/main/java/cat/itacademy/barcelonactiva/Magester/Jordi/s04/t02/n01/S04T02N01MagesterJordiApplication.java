package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Controllers.FruitController;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Repository.FruitRepository;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class S04T02N01MagesterJordiApplication {

	public static void main(String[] args) {
		SpringApplication.run(S04T02N01MagesterJordiApplication.class, args);
	}
}
