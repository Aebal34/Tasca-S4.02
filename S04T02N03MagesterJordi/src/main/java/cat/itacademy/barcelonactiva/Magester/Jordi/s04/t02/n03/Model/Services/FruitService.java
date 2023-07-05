package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Repositories.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    @Autowired
    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public void saveFruit(Fruit fruit) {
        fruitRepository.save(fruit);
    }
}
