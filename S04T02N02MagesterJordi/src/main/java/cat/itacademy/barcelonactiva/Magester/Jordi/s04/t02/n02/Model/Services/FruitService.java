package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    @Autowired
    FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }


    public void addFruit(Fruit fruit) {
        fruitRepository.save(fruit);
    }
}
