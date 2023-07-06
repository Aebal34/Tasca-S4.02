package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Services;

import java.util.List;
import java.util.Optional;

public interface FruitServiceImpl<T>{

    void saveFruit(T t);

    Optional<T> findById(String id);

    void updateFruit(String id, String name, Integer amountKg);

    void deleteFruit(String id);

    List<T> findAllFruits();
}
