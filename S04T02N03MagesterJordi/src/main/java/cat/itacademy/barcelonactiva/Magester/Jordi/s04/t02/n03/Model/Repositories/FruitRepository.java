package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Repositories;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Integer> {
}
