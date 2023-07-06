package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Services.FruitService;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Services.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private final FruitServiceImpl<Fruit> fruitService;

    public FruitController(FruitServiceImpl<Fruit> fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestParam String name, @RequestParam Integer amountKg){
        if(name != null && amountKg != null){
            if(!name.matches("^[a-zA-Z0-9]+$")){
                return ResponseEntity.badRequest().body("400. Wrong name. No symbols in it, please.");
            }else{
                fruitService.saveFruit(new Fruit(name, amountKg));
                return ResponseEntity.ok("200. Fruit added to database successfully.");
            }
        }else{
            return ResponseEntity.badRequest().body("400. Must have name and amount of Kg to save a new fruit.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestParam String id, @RequestParam(required = false) String name, @RequestParam(required = false) Integer amountKg){
        Optional<Fruit> fruit = fruitService.findById(id);
        ResponseEntity<String> response;
        if(fruit.isPresent()){
            if(name != null){
                if(name.matches("^[a-zA-Z0-9]+$")){
                    fruitService.updateFruit(id, name, amountKg);
                    response = ResponseEntity.ok("200. Fruit updated successfully.");
                }else{
                    response = ResponseEntity.badRequest().body("400. Wrong name.");
                }
            }else if(amountKg != null){
                fruitService.updateFruit(id, name, amountKg);
                response = ResponseEntity.ok("200. Fruit updated successfully.");
            }else{
                response = ResponseEntity.badRequest().body("400. Must have name of amountKg to update.");
            }
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("404. Fruit not found.");
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id){
        if(fruitService.findById(id).isPresent()){
            fruitService.deleteFruit(id);
            return ResponseEntity.ok("200. Fruit deleted successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404. Fruit not found.");
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Object> getOne(@PathVariable String id){
        if(fruitService.findById(id).isPresent()){
            return ResponseEntity.ok(fruitService.findById(id).get());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404. Not found.");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll(){
        if(!fruitService.findAllFruits().isEmpty()){
            return ResponseEntity.ok(fruitService.findAllFruits());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("404. Not found.");
        }
    }
}
