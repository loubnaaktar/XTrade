import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    private String type;
    private int quantite;
    private double prix;
    private LocalDateTime date;
    private Asset asset ;


    public Transaction(String type, int quantite, double prix, LocalDateTime date) {
        this.type = type;
        this.quantite = quantite;
        this.prix = prix;
        this.date = date;
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

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }
}
