public class CryptoCurrency extends Asset{
    public CryptoCurrency(String code, String nomAsset, double prixUnitaire, int quantiteAsset) {
        super(code, nomAsset, prixUnitaire, quantiteAsset);
    }
    @Override
    public String getType(){
        return "Crypto";
    }
}
