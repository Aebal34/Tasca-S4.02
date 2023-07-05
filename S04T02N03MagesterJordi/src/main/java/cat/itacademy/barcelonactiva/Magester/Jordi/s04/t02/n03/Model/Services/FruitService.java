package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Repositories.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Optional<Fruit> findById(String id) {
        return fruitRepository.findById(id);
    }

    public void updateFruit(String id, String name, Integer amountKg) {
        Fruit fruit = fruitRepository.findById(id).get();
        if(name != null){
            fruit.setName(name);
        }
        if(amountKg != null){
            fruit.setAmountKg(amountKg);
        }
        fruitRepository.save(fruit);
    }

    public void deleteFruit(String id) {
        fruitRepository.deleteById(id);
    }
}
