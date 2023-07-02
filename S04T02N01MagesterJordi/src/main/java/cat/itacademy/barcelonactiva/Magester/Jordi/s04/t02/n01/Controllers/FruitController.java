package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Repository.FruitRepository;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class FruitController {

    //Annotation Autowired to inject dependency service
    @Autowired
    FruitService fruitService;


}
