public class Trader extends Person{
    private double solde;

    public Trader(String nom, int id, double solde) {
        super(nom, id);
        this.solde = solde;
    }

    public Trader(){}


    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
}
