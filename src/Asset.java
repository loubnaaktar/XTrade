public abstract class Asset {
    private String code;
    private String nomAsset;
    private double prixUnitaire;
    private int quantiteAsset;

    public Asset(String code, String nomAsset, double prixUnitaire, int quantiteAsset) {
        this.code = code;
        this.nomAsset = nomAsset;
        this.prixUnitaire = prixUnitaire;
        this.quantiteAsset = quantiteAsset;
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

    public int getQuantiteAsset() {
        return quantiteAsset;
    }

    public void setQuantiteAsset(int quantiteAsset) {
        this.quantiteAsset = quantiteAsset;
    }

    public String getType(){
        return "Asset";
    }
}
