public abstract class Asset {
    private String code;
    private String nomAsset;
    private double prixUnitaire;
    private int quantiteAsset;


    public Asset(String code, String nomAsset, double prixUnitaire) {
        this.code = code;
        this.nomAsset = nomAsset;
        this.prixUnitaire = prixUnitaire;

    }

    public String getCode() {
        return code;
    }

    public String getNomAsset() {
        return nomAsset;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setNomAsset(String nomAsset) {
        this.nomAsset = nomAsset;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getType(){
        return "Asset";
    }

    public int getQuantiteAsset() {
        return quantiteAsset;
    }

    public void addQuantite(int q) {
        this.quantiteAsset += q;
    }
    public void retirerQuantite(int q) {
        this.quantiteAsset -= q;
    }
}
