package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @PostMapping("/add")
    public ResponseEntity<String> add(String name, int amountKg){
        ResponseEntity<String> response = ResponseEntity.internalServerError().body("An unexpected error occurred.");

        if(name.length() == 0 || name.matches("/.*[a-zA-Z0-9].*/")){
            response = ResponseEntity.badRequest().body("Wrong name. Please try again");
        }else{
            fruitService.addFruit(new Fruit(name, amountKg));
            response = ResponseEntity.ok("Fruit saved into database successfully.");
        }
        return response;
    }

}
