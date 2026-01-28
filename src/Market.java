import java.util.ArrayList;

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
                "- le prix unitaire :" + a.getPrixUnitaire() + "\n" +
                "- la quantité: " + a.getQuantiteAsset());
    }

    public void AjouterTrader(Trader trader) {
        if (trader.getSolde() > 0) {
            System.out.println("trader ajouté avec succés ");
            traders.add(trader);
            System.out.println("----------------------------------------");
            System.out.println("les informations du trader : ");
            System.out.println("l'ID du trader: " + trader.getId() + "\n" +
                    "le nom : " + trader.getNom() + "\n" +
                    "les solde initial : " + trader.getSolde() + " $ \n"
            );
        } else {
            System.out.println("le solde doit étre superieur à 0 ");
        }

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
            if (asset.getCode() == code) {
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

    public void CreerPortefeuille() {
    }

    public void ConsulterPortefeuille() {
    }

    public void AcheterActif() {
    }

    public void vendreActif() {
    }

    public void Historique() {
    }
}
