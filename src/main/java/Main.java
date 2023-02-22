import entities.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-petstore");
        EntityManager em = emf.createEntityManager();

        //Insertions dans la base de données :
        EntityTransaction et = em.getTransaction();
        et.begin();
        Address address1 = new Address("12", "rue de la soif", "44000", "NANTES");
        Address address2 = new Address("13", "rue de la soif", "44000", "NANTES");
        Address address3 = new Address("14", "rue de la soif", "44000", "NANTES");
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        Product product1 = new Product("code1", "banana", Product.ProdType.valueOf("FOOD"), 1.50);
        Product product2 = new Product("code2", "necklace", Product.ProdType.valueOf("ACCESSORY"),19.80);
        Product product3 = new Product("code3", "soap", Product.ProdType.valueOf("CLEANING"), 2.10);//ProdType.valueOf("CLEANING")
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        PetStore petstore1 = new PetStore("petstore1", "Tony", address1);
        PetStore petstore2 = new PetStore("petstore2", "Mathias", address2);
        PetStore petstore3 = new PetStore("petstore3", "Pierre", address3);
        em.persist(petstore1);
        em.persist(petstore2);
        em.persist(petstore3);
        Animal animal1 = new Animal(LocalDateTime.now(), "black", petstore1);
        Animal animal2 = new Animal(LocalDateTime.now(), "white", petstore2);
        Animal animal3 = new Animal(LocalDateTime.now(), "brown", petstore3);
        em.persist(animal1);
        em.persist(animal2);
        em.persist(animal3);
        Cat cat1 = new Cat(LocalDateTime.now(), "grey", petstore1, "1");
        Cat cat2 = new Cat(LocalDateTime.now(), "beige",petstore2,  "2");
        Animal cat3 = new Cat(LocalDateTime.now(), "ginger", petstore3, "3");
        em.persist(cat1);
        em.persist(cat2);
        em.persist(cat3);
        Fish fish1 = new Fish(LocalDateTime.now(), "blue", petstore1, Fish.FishLivEnv.valueOf("FRESH_WATER"));
        Fish fish2 = new Fish(LocalDateTime.now(), "green", petstore2, Fish.FishLivEnv.valueOf("SEA_WATER"));
        Animal fish3 = new Fish(LocalDateTime.now(), "yellow", petstore3, Fish.FishLivEnv.valueOf("FRESH_WATER"));
        em.persist(fish1);
        em.persist(fish2);
        em.persist(fish3);
        et.commit();

        //Réaliser une requête qui permet d’extraire tous les animaux d’une animalerie donnée
        TypedQuery<Animal> query1 = em.createQuery("select a from Animal a where a.petstore=" + petstore1.getId(), Animal.class);
        List<Animal> listAnimal = query1.getResultList();
        if (!listAnimal.isEmpty()){
            for (Animal a: listAnimal) {
                System.out.println("Id : " + a.getId());
            }
        }
        em.close();
        emf.close();

    }
}
