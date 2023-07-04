package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public void updateFruit(int id, String name, Integer amountKg) {
        Fruit fruit = fruitRepository.findById(id).get();
        if(name != null){
            fruit.setName(name);
        }
        if(amountKg != null){
            fruit.setAmountKg(amountKg);
        }
        fruitRepository.save(fruit);
    }

    public ResponseEntity<Fruit> findFruit(int id) {
        return ResponseEntity.ok(fruitRepository.findById(id).orElse(null));
    }


    public void deleteFruit(int id) {
        fruitRepository.deleteById(id);
    }
}
