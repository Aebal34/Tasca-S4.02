package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n02.Model.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(String name, int amountKg) {
        if (name.length() == 0 || name.matches("/.*[a-zA-Z0-9].*/")) {
            return ResponseEntity.badRequest().body("Wrong name. Please try again");
        } else {
            fruitService.addFruit(new Fruit(name, amountKg));
            return ResponseEntity.ok("Fruit saved into database successfully.");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestParam int id, @RequestParam(required = false) String name, @RequestParam(required = false) Integer amountKg) {
        ResponseEntity<String> response = ResponseEntity.internalServerError().body("An unexpected error occurred.");
        if (fruitService.findFruit(id).getBody() != null) {
            if(name != null){
                if (name.matches("/.*[a-zA-Z0-9.*]/")) {
                    response = ResponseEntity.badRequest().body("Wrong name. Please try again.");
                }else{
                    fruitService.updateFruit(id, name, amountKg);
                    response = ResponseEntity.ok("Fruit updated into database successfully.");
                }
            }else if(amountKg != null){
                fruitService.updateFruit(id, name, amountKg);
                response = ResponseEntity.ok("Fruit updated into database successfully.");
            }else{
                response = ResponseEntity.badRequest().body("You need at least one parameter to update fruit.");
            }
        }else{
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found.");
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOne(@PathVariable int id){
        Fruit fruit = fruitService.findFruit(id).getBody();
        if(fruit != null){
            fruitService.deleteFruit(id);
            return ResponseEntity.ok("Fruit deleted successfully.");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fruit not found.");
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOne(@PathVariable int id){
        Fruit fruit = fruitService.findFruit(id).getBody();
        if(fruit != null){
            return ResponseEntity.ok(fruit);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(){
        List<Fruit> fruits = fruitService.findAllFruits().getBody();
        if(fruits != null){
            if(fruits.isEmpty()){
                return ResponseEntity.noContent().build();
            }else{
                return ResponseEntity.ok(fruits);
            }
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
