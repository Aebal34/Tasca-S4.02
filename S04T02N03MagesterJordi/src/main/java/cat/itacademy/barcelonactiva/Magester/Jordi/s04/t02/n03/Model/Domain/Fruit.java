package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n03.Model.Domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruit {
    @Id
    private String id;

    private String name;
    private Integer amountKg;

    public Fruit(String name, Integer amountKg) {
        this.name = name;
        this.amountKg = amountKg;
    }

    public Fruit() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmountKg() {
        return amountKg;
    }

    public void setAmountKg(Integer amountKg) {
        this.amountKg = amountKg;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amountKg=" + amountKg +
                '}';
    }
}
