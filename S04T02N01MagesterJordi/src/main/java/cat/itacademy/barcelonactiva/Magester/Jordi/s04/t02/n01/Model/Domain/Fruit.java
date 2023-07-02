package cat.itacademy.barcelonactiva.Magester.Jordi.s04.t02.n01.Model.Domain;

import jakarta.persistence.*;

@Entity //It's a persistent class, one we want to store data from
@Table(name = "fruits") //define table where we save the data
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //defines this attribute as the DB's id with auto-increment
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="kgAmount")
    private int weight;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
