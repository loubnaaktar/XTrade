import java.util.ArrayList;

public class Trader extends Person{
    private double solde;
    private static int idnombre = 1;
    private Portfolio<Asset> portfolio;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Trader(String nom, double solde) {
        super(nom);
        this.solde = solde;
        setId(idnombre);
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

    public Portfolio<Asset> getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio<Asset> portfolio) {
        this.portfolio = portfolio;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction transaction) {
        transactions.add(transaction);
    }
}
