import java.util.ArrayList;
import java.util.Objects;

public class Market {
    private String nomMarket;
    private ArrayList<Trader> traders = new ArrayList<>();
    private ArrayList<Asset> assets = new ArrayList<>();


    public void AjouterActif(Asset a) {
        assets.add(a);
        if (a instanceof Stock) {
            System.out.println("stock ajouté avec succés");
        } else if (a instanceof CryptoCurrency) {
            System.out.println("crypto ajouté avec succés");
        }
        System.out.println("les information de l'actif ajouté \n" +
                "- le type : " + a.getType() + "\n" +
                "- le code: " + a.getCode() + "\n" +
                "- le prix unitaire :" + a.getPrixUnitaire() + " $ \n" +
                "- la quantité: " + a.getQuantiteAsset());
    }

    public void AjouterTrader(Trader trader) {
        if (trader.getSolde() > 0) {
            traders.add(trader);
            creerPortefeuille(trader);
        } else {
            System.out.println("le solde doit étre superieur à 0 ");
        }

    }

    public void creerPortefeuille(Trader trader) {

        Portfolio<Asset> pf = new Portfolio<>();
        trader.setPortfolio(pf);
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("Trader ajouté avec succés ");
        System.out.println("----------------------------------------");
        System.out.println("- Les informations du trader : ");
        System.out.println("- L'id du trader: " + trader.getId() + "\n" +
                "- Le nom : " + trader.getNom() + "\n" +
                "- L'id du portfeuille : " +pf.idPorfolio + "\n" +
                "- Les solde initial : " + trader.getSolde() + " $ \n");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }
    public void AfficherActifs(int num) {
        if(!assets.isEmpty()){
        if (num == 1) {
            System.out.println("les stocks existés sont:");
            for (Asset a : assets) {
                if (a instanceof Stock) {
                    System.out.println(" \n" +
                            "- " + a.getNomAsset() + " || le code : " +a.getCode() + "|| le prix unitaire: " + a.getPrixUnitaire() + "$ " + "|| la quantité: " + a.getQuantiteAsset());
                }
            }
        } else if (num == 2) {
            for (Asset a : assets) {
                if (a instanceof CryptoCurrency) {
                    System.out.println("- " + a.getNomAsset() + "|| le prix unitaire: " + a.getPrixUnitaire() + "$ " + "|| la quantité: " + a.getQuantiteAsset());
                }
            }
        }else{
            System.out.println("choisisez 1 ou 2 ");
        }
        }else{
            System.out.println("aucun actif pour le moment");
        }
    }

    public Asset chercherAsset(String code) {
        for (Asset asset : assets) {
            if (Objects.equals(asset.getCode(), code)) {
                return asset;
            }
        }
    return null;
    }

    public void changerPrix(Asset a, double nvprix){
        if(nvprix > 0 ){
            double anprix = a.getPrixUnitaire();
            a.setPrixUnitaire(nvprix);
            System.out.println("prix changé avec succés");
            System.out.println("-" + a.getNomAsset() + " || le code N°: " + a.getCode()+ " || l'ancien prix :" + anprix + " $" + " || le nouveau prix: " + a.getPrixUnitaire() + " $ ");
        }else{
            System.out.println("le prix doit étre supérieur ");
        }
    }

    public Trader chercherTrader(int id){
       if(!traders.isEmpty()){
           for(Trader tr : traders){
               if(tr.getPortfolio().idPorfolio == id){
                   return tr;
               }else{
                       System.out.println("ce id n'existe pas!  ");
                   }
           }
       }else{
           System.out.println("aucun portefeuille");
       }
        return null;
    }
    public void ConsulterPortefeuille(int id) {
        Trader tr = chercherTrader(id);
        if(tr != null){
            if(tr.getPortfolio().idPorfolio == id) {
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println("---- Les informations du Portefeuille----- ");
                System.out.println("ID de Portefeuille: " + tr.getPortfolio().idPorfolio + "\n" +
                        "Le nom de trader: " + tr.getNom() + "\n" +
                        "Le solde : " + tr.getSolde() + "\n" +
                        "Les actifs : ");
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
            }
        }
    }

    public void AcheterActif() {
    }

    public void vendreActif() {
    }

    public void Historique() {
    }
}
