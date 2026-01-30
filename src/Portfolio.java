import java.util.ArrayList;

public class Portfolio <Asset>{
private int idPorfolio;
static int count = 100;
private ArrayList<Asset> assets = new ArrayList<>();

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

    public ArrayList<Asset> getAssets() {
        return assets;
    }

    public void setAssets(Asset a) {
        assets.add(a);
    }
}
