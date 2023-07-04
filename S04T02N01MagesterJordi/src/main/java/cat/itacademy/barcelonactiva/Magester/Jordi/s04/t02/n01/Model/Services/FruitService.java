package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.beans.Transient;
import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitService(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    public ResponseEntity<List<Fruit>> getAll() {
        return ResponseEntity.ok(fruitRepository.findAll());
    }

    public ResponseEntity<Fruit> getById(int id){
        return ResponseEntity.ok(fruitRepository.findById(id).orElse(null));
    }

    public void save(Fruit fruit){
        fruitRepository.save(fruit);
    }

    public void delete(Fruit fruit){
        fruitRepository.delete(fruit);
    }

    public void deleteFruit(int id) {
        fruitRepository.deleteById(id);
    }

    @Transient
    public void updateFruit(int id, String newName, int newAmountKg) {
        if(newName.length() != 0){
            fruitRepository.findById(id).get().setName(newName);
        }
        fruitRepository.findById(id).get().setAmountKg(newAmountKg);
    }
}
