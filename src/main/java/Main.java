import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-petstore");
        EntityManager em = emf.createEntityManager();

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-biblio");
        EntityManager em = emf.createEntityManager();*/

        /* Récupération d'un livre :
        Livre livre = em.find(Livre.class, 1);
        if (livre != null){
            System.out.println("Titre : " + livre.getTitre() + " \nAuteur : "  + livre.getAuteur());
        }*/

        /* Ajout d'un livre (persist pour un objet instanciée dans le code et merge pour un objet existant dans la bdd) :
        EntityTransaction et = em.getTransaction();
        et.begin();
        Livre livre1 = new Livre("TitreX", "AuteurX");
        livre1.getId();
        livre1.setTitre(livre1.getTitre());
        livre1.setAuteur(livre1.getAuteur());
        em.persist(livre1);
        et.commit();*/

        /* Modification du titre d'un livre :
        EntityTransaction et = em.getTransaction();
        et.begin();
        Livre livre2 = em.find(Livre.class, 5);
        if (livre2 != null){
            livre2.setTitre("Du plaisir dans la cuisine");
            System.out.println("Titre : " + livre2.getTitre() + " \nAuteur : "  + livre2.getAuteur());
        }
        em.merge(livre2);
        et.commit();*/

        /* Récupération d'un livre en fonction de son titre :
        TypedQuery<Livre> query1 = em.createQuery("select l from Livre l where l.titre='Germinal'", Livre.class);
        Livre livre3 = query1.getResultList().get(0);
        if (livre3 != null){
            System.out.println("Auteur du livre " + livre3.getTitre() + " : " + livre3.getAuteur());
        }*/

        /* Récupération d'un livre en fonction de son auteur :
        TypedQuery<Livre> query2 = em.createQuery("select l from Livre l where l.auteur='Emile Zola'", Livre.class);
        Livre livre4 = query2.getResultList().get(0); // ou query2.getSingleResult()
        if (livre4 != null){
            System.out.println("Titre du livre de " + livre4.getAuteur() + " : " + livre4.getTitre());
        }*/

        /* Suppression d'un livre :
        EntityTransaction et = em.getTransaction();
        et.begin();
        Livre livre5 = em.find(Livre.class, 6);
        if (livre5 != null){
            em.remove(livre5);
        }
        et.commit();*/

        /* Récupération de tous les livres :
        TypedQuery query3 = em.createQuery("select l from Livre l", Livre.class);
        List<Livre> listeLivres = query3.getResultList();
        if (listeLivres != null){
            for (Livre unLivre : listeLivres) {
                System.out.println("Titre du livre de " + unLivre.getAuteur() + " : " + unLivre.getTitre());
            }
        }*/

        /* Récupération un emprunt et tous ses livres associés :
        Emprunt emprunt = em.find(Emprunt.class, 1);
        Set<Livre> listeLivres = emprunt.getLivres();

        if (listeLivres != null){
            for (Livre unLivre : listeLivres) {
                System.out.println(unLivre.getTitre());
            }
        }*/

        /* Récupération de tous les emprunts d'un client donné :
        Client client = em.find(Client.class, 1);
        Set<Emprunt> listeEmprunts = client.getEmprunts();
        if (listeEmprunts != null){
            for (Emprunt unEmprunt : listeEmprunts) {
                System.out.println("Id de l'emprunt : " + unEmprunt.getId());
            }
        }*/

        /*System.out.println("em : " + em);
        em.close();
        emf.close();*/

    }
}
