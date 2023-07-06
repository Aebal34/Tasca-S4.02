package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FruitServiceImpl<T>{

    void saveFruit(T t);

    ResponseEntity<T> findFruit(int id);

    void updateFruit(int id, String name, int amountKg);

    void deleteFruit(int id);

    ResponseEntity<List<T>> findAllFruits();
}
