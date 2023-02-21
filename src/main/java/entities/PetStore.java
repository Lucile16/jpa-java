package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String managerName;
    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(name="compo_petstore_product",
            joinColumns= @JoinColumn(name="ID_PETSTORE", referencedColumnName="ID"),
            inverseJoinColumns= @JoinColumn(name="ID_PRODUCT", referencedColumnName="ID")
    )
    private Set<Product> products;

    @OneToMany(mappedBy="petstore", cascade = CascadeType.ALL)
    private Set<Animal> animals;

    public PetStore() {
        products = new HashSet<Product>();
        animals = new HashSet<Animal>();
    }

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
        products = new HashSet<Product>();
        animals = new HashSet<Animal>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }
}