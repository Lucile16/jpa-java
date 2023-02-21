package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
    public enum ProdType {
        FOOD, ACCESSORY, CLEANING
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String label;
    @Enumerated(EnumType.STRING)
    private ProdType type;
    private double price;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
    private Set<PetStore> petstores;

    public Product() {
        petstores = new HashSet<PetStore>();
    }

    public Product(String code, String label, double price) {
        this.code = code;
        this.label = label;
        this.price = price;
    }

    public Product(String code, String label, ProdType type, double price) {
        this.code = code;
        this.label = label;
        this.type = type;
        this.price = price;
        petstores = new HashSet<PetStore>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ProdType getType() {
        return type;
    }

    public void setType(ProdType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<PetStore> getPetstores() {
        return petstores;
    }

    public void setPetstores(Set<PetStore> petstores) {
        this.petstores = petstores;
    }
}