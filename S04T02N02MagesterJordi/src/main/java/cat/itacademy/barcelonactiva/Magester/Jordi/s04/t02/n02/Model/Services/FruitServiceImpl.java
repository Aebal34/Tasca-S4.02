package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Services;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface FruitServiceImpl<T>{

    void saveFruit(T t);

    ResponseEntity<T> findFruit(int id);

    void updateFruit(int id, String name, Integer amountKg);

    void deleteFruit(int id);

    ResponseEntity<List<T>> findAllFruits();
}
