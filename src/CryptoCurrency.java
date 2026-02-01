public class CryptoCurrency extends Asset{
    public CryptoCurrency(String code, String nomAsset, double prixUnitaire) {
        super(code, nomAsset, prixUnitaire);
    }
    @Override
    public String getType(){
        return "Crypto";
    }
}
