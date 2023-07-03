package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Controllers;

import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain.Fruit;
import cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
@RequestMapping("/fruits")
public class FruitController {

    //Annotation Autowired to inject dependency service
    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAll(){
        ResponseEntity<List<Fruit>> response = fruitService.getAll();
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
        ResponseEntity<Fruit> response = fruitService.getById(id);
        if(response.getBody() != null){
           response = ResponseEntity.notFound().build();
        }else{
            response = ResponseEntity.ok(response.getBody());
        }
        return response;
    }

    @PostMapping("/add")
    public void postFruit(@RequestBody Fruit fruit){
        fruitService.save(fruit);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOne(@PathVariable int id){
        fruitService.deleteFruit(id);
    }

    @PutMapping("/update")
    public void update(int id, @RequestParam(required = false) String newName, @RequestParam(required = false) int newWeight){
        fruitService.updateFruit(id, newName, newWeight);
    }

}
