public class Person {
    private String nom;
    private int id;
    private static int idnombre = 1;

    public Person(String nom, int id) {
        this.nom = nom;
        this.id = idnombre;
        idnombre++;
    }

    public Person() {
        idnombre++;
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        this.id = id;
    }
}
