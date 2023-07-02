package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Repository;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

//We extend JpaRepository to already have most of the CRUD methods we will need
public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    //We define 3 more methods to filter by amount of Kg
    List<Fruit> getByMoreThanKilo(int kg);
    List<Fruit> getByLessThanKilo(int kg);
    List<Fruit> getByKilo(int kg);
}
