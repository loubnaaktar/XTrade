import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String type;
    private int quantite;
    private double prix;
    private Date LocalDateTime;
    private ArrayList<Asset> assets = new ArrayList<>();

    public Transaction(String type, int quantite, double prix, Date localDateTime) {
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
        LocalDateTime = localDateTime;
    }
    public Transaction (){}

    public String getType() {
        return type;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    public Date getLocalDateTime() {
        return LocalDateTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setLocalDateTime(Date localDateTime) {
        LocalDateTime = localDateTime;
    }

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public void setAssets(Asset a) {
       assets.add(a);
    }
}
