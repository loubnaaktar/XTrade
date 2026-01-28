public class Stock extends Asset{
    public Stock(String code, String nomAsset, double prixUnitaire, int quantiteAsset) {
        super(code, nomAsset, prixUnitaire, quantiteAsset);
    }

    @Override
    public String getType(){
        return "Stock";
    }
}
