public class Stock extends Asset{
    public Stock(String code, String nomAsset, double prixUnitaire) {
        super(code, nomAsset, prixUnitaire);
    }

    @Override
    public String getType(){
        return "Stock";
    }
}
