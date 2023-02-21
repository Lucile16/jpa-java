package entities;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime birth;
    private String color;
    @ManyToOne
    @JoinColumn(name="ID_PETSTORE")
    private PetStore petstore;

    public Animal() {
    }

    public Animal(LocalDateTime birth, String color) {
        this.birth = birth;
        this.color = color;
    }

    public Animal(LocalDateTime birth, String color, PetStore petstore) {
        this.birth = birth;
        this.color = color;
        this.petstore = petstore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBirth() {
        return birth;
    }

    public void setBirth(LocalDateTime birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetstore() {
        return petstore;
    }

    public void setPetstore(PetStore petstore) {
        this.petstore = petstore;
    }
}