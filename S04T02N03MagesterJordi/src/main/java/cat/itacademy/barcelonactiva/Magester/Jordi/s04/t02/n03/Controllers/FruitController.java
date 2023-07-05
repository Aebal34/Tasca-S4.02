package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private final FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam String name, @RequestParam Integer amountKg){
        if(name != null && amountKg != null){
            if(name.matches("/.*[a-zA-Z0-9].*/")){
                return ResponseEntity.badRequest().body("Wrong name. No symbols in it, please.");
            }else{
                fruitService.saveFruit(new Fruit(name, amountKg));
                return ResponseEntity.ok("Fruit added to database successfully.");
            }
        }else{
            return ResponseEntity.badRequest().body("Must have name and amount of Kg to save a new fruit.");
        }
    }


}
