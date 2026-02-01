import java.util.ArrayList;

public class Portfolio <T extends Asset>{
private int idPorfolio;
static int count = 100;
private int quantity;
private ArrayList<T> assets = new ArrayList<>();

    public Portfolio(){
        this.idPorfolio = count;
        count++;
    }
    public int getIdPorfolio() {
        return idPorfolio;
    }

    public void setIdPorfolio(int idPorfolio) {
        this.idPorfolio = idPorfolio;
    }

    public ArrayList<T> getAssets() {
        return assets;
    }

    public void setAssets(T a) {
        assets.add(a);
    }

    public int getQuantity() {
        return quantity;
    }
    public void ajouterquantite(T asset, int quantite) {
            for (T a : assets) {
                if (a.getCode().equals(asset.getCode())) {
                    a.addQuantite(quantite);
                    return;
                }
            }
            asset.addQuantite(quantite);
            assets.add(asset);
        }

    public void diminuerQuantite(T asset, int q){
        for (T a : assets) {
            if(a.getCode().equals(asset.getCode())){
                a.retirerQuantite(q);
                return;
            }
        }
        asset.retirerQuantite(q);
        assets.add(asset);
    }
}
