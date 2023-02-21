package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Cat extends Animal {
    private String chipId;

    public Cat() {
    }

    public Cat(String chipId) {
        this.chipId = chipId;
    }

    public Cat(LocalDateTime birth, String color) {
        super(birth, color);
    }

    public Cat(LocalDateTime birth, String color, String chipId) {
        super(birth, color);
        this.chipId = chipId;
    }

    public Cat(LocalDateTime birth, String color, PetStore petstore) {
        super(birth, color, petstore);
    }

    public Cat(LocalDateTime birth, String color, PetStore petstore, String chipId) {
        super(birth, color, petstore);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}