import java.util.ArrayList;

public class Trader extends Person{
    private double solde;
    private int id;
    private static int idnombre = 1;
    private Portfolio portfolio;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Trader(String nom, double solde) {
        super(nom);
        this.solde = solde;
        this.id = idnombre;
        idnombre++;
    }

    public Trader(){
        idnombre++;
    }


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
