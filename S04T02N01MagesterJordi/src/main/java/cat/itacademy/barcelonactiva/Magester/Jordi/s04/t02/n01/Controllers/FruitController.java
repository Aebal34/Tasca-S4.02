package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services.FruitService;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services.FruitServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private final FruitServiceImpl<Fruit> fruitService;

    public FruitController(FruitServiceImpl<Fruit> fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(){
        ResponseEntity<List<Fruit>> response = fruitService.findAllFruits();
        if(response.getBody() != null){
            if(response.getBody().isEmpty()){
                response = ResponseEntity.notFound().build(); //If no item in list, http error 404, not found
            }else{
                response = ResponseEntity.ok(response.getBody());
            }
        }else {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getById(@PathVariable int id){
        ResponseEntity<Fruit> response = fruitService.findFruit(id);
        if(response.getBody() != null){
           response = ResponseEntity.notFound().build();
        }else{
            response = ResponseEntity.ok(response.getBody());
        }
        return response;
    }

    @PostMapping("/add")
    public ResponseEntity<String> postFruit(@RequestBody Fruit fruit){
        ResponseEntity<String> response = ResponseEntity.internalServerError().body("An unexpected error has occurred.");
        if(fruit.getName().length() == 0 || fruit.getName().isEmpty() || !fruit.getName().matches("^[a-zA-Z0-9]+$")){
            response = ResponseEntity.badRequest().body("Error 400. Incorrect name. Fruit not added.");
        }else {
            if(fruitService.findFruit(fruit.getId()).getBody() != null){
                fruitService.saveFruit(fruit);
                response = ResponseEntity.accepted().body("201. Fruit correctly added.");
            }
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable int id){
        ResponseEntity<String> response = ResponseEntity.notFound().build();

        if(fruitService.findFruit(id) != null){
            fruitService.deleteFruit(id);
            response = ResponseEntity.ok("Fruit found and deleted.");
        }
        return response;
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(int id, @RequestParam(required = false) String newName, @RequestParam(required = false) int newAmountKg){
        ResponseEntity<String> response = ResponseEntity.notFound().build();
        if(fruitService.findFruit(id) != null){
            if(!newName.matches("^[a-zA-Z0-9]+$")){
                response = ResponseEntity.badRequest().body("Error 400. Incorrect name. Fruit not added.");
            }else {
                fruitService.updateFruit(id, newName, newAmountKg);
                response = ResponseEntity.ok("Fruit successfully updated.");
            }
        }
        return response;
    }
}
