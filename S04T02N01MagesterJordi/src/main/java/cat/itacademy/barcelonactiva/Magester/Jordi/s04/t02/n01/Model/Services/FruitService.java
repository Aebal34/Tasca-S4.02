package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {
    @Autowired
    private FruitRepository fruitRepository;
}
