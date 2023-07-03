package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Repository;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

//We extend JpaRepository to already have most of the CRUD methods we will need
@Repository
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

}
