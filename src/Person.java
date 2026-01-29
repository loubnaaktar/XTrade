public class Person {
    private String nom;
    private int id;

    public Person(String nom) {
        this.nom = nom;
    }

    public Person() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
