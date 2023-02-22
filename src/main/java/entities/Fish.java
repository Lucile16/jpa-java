package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Entity
public class Fish extends Animal {
    public enum FishLivEnv {
        FRESH_WATER, SEA_WATER
    }
    @Enumerated(EnumType.STRING)
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    public Fish(LocalDateTime birth, String color) {
        super(birth, color);
    }

    public Fish(LocalDateTime birth, String color, FishLivEnv livingEnv) {
        super(birth, color);
        this.livingEnv = livingEnv;
    }

    public Fish(LocalDateTime birth, String color, PetStore petstore) {
        super(birth, color, petstore);
    }

    public Fish(LocalDateTime birth, String color, PetStore petstore, FishLivEnv livingEnv) {
        super(birth, color, petstore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}