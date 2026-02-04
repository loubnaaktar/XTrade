import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Market {
    private String nomMarket;
    private ArrayList<Trader> traders = new ArrayList<>();
    private ArrayList<Asset> assets;
    private ArrayList<Transaction> transactions = new ArrayList<>();


    public Market() {
        assets = new ArrayList<>();
        initialiserAssets();
    }

    private void initialiserAssets() {

        Stock stock1 = new Stock("AAPL", "Apple", 150.0);
        Stock stock2 = new Stock("GOOGL", "Alphabet", 2800.0);
        Stock stock3 = new Stock("MSFT", "Microsoft", 300.0);


        CryptoCurrency crypto1 = new CryptoCurrency("BTC", "Bitcoin", 25000.0);
        CryptoCurrency crypto2 = new CryptoCurrency("ETH", "Ethereum", 1800.0);
        CryptoCurrency crypto3 = new CryptoCurrency("ADA", "Cardano", 0.35);


        assets.add(stock1);
        assets.add(stock2);
        assets.add(stock3);
        assets.add(crypto1);
        assets.add(crypto2);
        assets.add(crypto3);
    }


    public void AjouterActif(String code, Asset a) {
        if (a.getCode().equals(code)) {
            System.out.println("----------------------------------------");
            System.out.println("cet asset existe déja");
            System.out.println("----------------------------------------");
            return;
        }
        assets.add(a);
        if (a instanceof Stock) {
            System.out.println("----------------------------------------");
            System.out.println("stock ajouté avec succés");
            System.out.println("----------------------------------------");
        } else if (a instanceof CryptoCurrency) {
            System.out.println("----------------------------------------");
            System.out.println("crypto ajouté avec succés");
            System.out.println("----------------------------------------");
        }
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println("les information de l'actif ajouté \n" +
                "- le type : " + a.getType() + "\n" +
                "- le code: " + a.getCode() + "\n" +
                "- le prix unitaire :" + a.getPrixUnitaire() + " $");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }

    public void AjouterTrader(Trader trader) {
        if (trader.getSolde() > 0) {
            traders.add(trader);
            creerPortefeuille(trader);
        } else {
            System.out.println("----------------------------------------");
            System.out.println("le solde doit étre superieur à 0 ");
            System.out.println("----------------------------------------");
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
                "- L'id du portfeuille : " + pf.getIdPorfolio() + "\n" +
                "- Les solde initial : " + trader.getSolde() + " $ \n");
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
    }

    public void AfficherActifs() {
        if (!assets.isEmpty()) {

            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("les actifs existés sont:");
            for (Asset a : assets) {
                System.out.println(" \n" +
                        "- " + a.getNomAsset() + " || le code : " + a.getCode() + "|| le prix unitaire: " + a.getPrixUnitaire() + "$ ");

            }
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("aucun actif pour le moment");
            System.out.println("----------------------------------------");
        }
    }

    public Asset chercherAsset(String code) {
        for (Asset asset : assets) {
            if (asset.getCode().equals(code)) {
                return asset;
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("ce code n'existe pas! ");
        System.out.println("----------------------------------------");

        return null;
    }

    public void changerPrix(Asset a, double nvprix) {
        if (nvprix > 0) {
            double anprix = a.getPrixUnitaire();
            a.setPrixUnitaire(nvprix);
            System.out.println("----------------------------------------");
            System.out.println("prix changé avec succés");
            System.out.println("-" + a.getNomAsset() + " || le code N°: " + a.getCode() + " || l'ancien prix :" + anprix + " $" + " || le nouveau prix: " + a.getPrixUnitaire() + " $ ");
            System.out.println("----------------------------------------");
        } else {
            System.out.println("----------------------------------------");
            System.out.println("le prix doit étre supérieur ");
            System.out.println("----------------------------------------");
        }
    }

    public Trader chercherTrader(int id) {
        if (!traders.isEmpty()) {
            for (Trader tr : traders) {
                if (tr.getId() == id) {
                    return tr;
                }
            }
            System.out.println("----------------------------------------");
            System.out.println("cet id n'existe pas!  ");
            System.out.println("----------------------------------------");

        } else {
            System.out.println("----------------------------------------");
            System.out.println("aucun trader");
            System.out.println("----------------------------------------");
        }
        return null;
    }

    public void ConsulterPortefeuille(int id) {
        Trader tr = chercherTrader(id);
        if (tr != null) {
            if (tr.getId() == id) {
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
                System.out.println("---- Les informations du Portefeuille----- ");
                System.out.println("ID de Portefeuille: " + tr.getPortfolio().getIdPorfolio() + "\n" +
                        "Le nom de trader: " + tr.getNom() + "\n" +
                        "Le solde : " + tr.getSolde() + " $ \n");
                if (!tr.getPortfolio().getAssets().isEmpty()) {
                    System.out.println(" Les actifs : ");
                    for (Asset s : tr.getPortfolio().getAssets()) {
                        if (s.getQuantiteAsset() == 0) {
                            System.out.println("----------------------------------------");
                            System.out.println("aucun assets pour le moment");
                            System.out.println("----------------------------------------");
                            break;
                        }
                        System.out.println("-le type: " + s.getType() + " || le nom : " + s.getNomAsset() + " || le prix unitaire: " + s.getPrixUnitaire() + " $ || la quantité: " + s.getQuantiteAsset());

                    }
                } else {
                    System.out.println("----------------------------------------");
                    System.out.println("aucun assets pour le moment");
                    System.out.println("----------------------------------------");
                }

                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");
            }
        }
    }


    public void AcheterActif(Trader tr, Asset a, int quantite) {
        if (quantite > 0) {
            if (tr.getSolde() > a.getPrixUnitaire()) {
                double prixTotal = quantite * a.getPrixUnitaire();
                if (tr.getSolde() > prixTotal) {
                    tr.setSolde(tr.getSolde() - prixTotal);
                    Transaction transaction = new Transaction();
                    transaction.setType("Achat");
                    transaction.setQuantite(quantite);
                    transaction.setPrix(prixTotal);
                    transaction.setDate(LocalDateTime.now());
                    transactions.add(transaction);
                    tr.setTransactions(transaction);
                    transaction.setAsset(a);
                    tr.getPortfolio().ajouterquantite(a, quantite);
                    System.out.println("----------------------------------------");
                    System.out.println("----------------------------------------");
                    System.out.println("Achat effectué avec succes!");
                    System.out.println("les informations: ");
                    System.out.println("- le type d'asset acheter: " + a.getType() + "\n" +
                            "- la quantité achetée: " + quantite + "\n" +
                            "- le prix total : " + prixTotal + "$");
                    System.out.println("----------------------------------------");
                    System.out.println("----------------------------------------");
                } else {
                    System.out.println("----------------------------------------");
                    System.out.println("solde insuffisant");
                    System.out.println("----------------------------------------");
                }

            } else {
                System.out.println("----------------------------------------");
                System.out.println("solde insufissant");
                System.out.println("----------------------------------------");
            }

        } else {
            System.out.println("----------------------------------------");
            System.out.println("la quantité doit étre positive! ");
            System.out.println("----------------------------------------");
        }

    }

    public void vendreActif(Trader tr, Asset a, int quantite) {
        if (quantite > 0) {
            if (a.getQuantiteAsset() >= quantite) {
                double prixTotal = quantite * a.getPrixUnitaire();
                tr.setSolde(tr.getSolde() + prixTotal);
                Transaction transaction = new Transaction();
                transaction.setType("Vente");
                transaction.setQuantite(quantite);
                transaction.setPrix(prixTotal);
                transaction.setDate(LocalDateTime.now());
                transaction.setAsset(a);
                transactions.add(transaction);
                tr.setTransactions(transaction);
                tr.getPortfolio().diminuerQuantite(a, quantite);
                System.out.println("--------------------------------------");
                System.out.println("--------------------------------------");
                System.out.println("Vente effectué avec succes!");
                System.out.println("les informations: ");
                System.out.println("- le type d'asset vendu : " + a.getType() + "\n" +
                        "- la quantité vendue: " + quantite + "\n" +
                        "- le prix total : " + prixTotal + "$");
                System.out.println("----------------------------------------");
                System.out.println("----------------------------------------");


            } else {
                System.out.println("----------------------------------------");
                System.out.println("quantité insuffisante");
                System.out.println("----------------------------------------");
            }

        } else {
            System.out.println("----------------------------------------");
            System.out.println("la quantité doit étre positive!");
            System.out.println("----------------------------------------");
        }
    }

    public void Historique() {
        if (!transactions.isEmpty()) {
            System.out.println("----------Historique---------");
            for (Transaction transaction : transactions) {
                if (transaction.getAsset() != null) {
                    System.out.println("- le type de la transaction : " + transaction.getType() + " || le nom de l'asset: " + transaction.getAsset().getNomAsset() + " || - la quantité: " + transaction.getQuantite() + "|| - la date :" + transaction.getDate());
                }
            }
        } else {
            System.out.println("----------------------------------------");
            System.out.println("aucune transaction pour le moment ");
            System.out.println("----------------------------------------");
        }
    }

    public void transisionTrader(Trader tr) {
        traders.stream().filter(trader -> trader.getTransactions().equals(tr.getTransactions()));

        if (!tr.getTransactions().isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
            System.out.println("les transactions du trader " + tr.getNom() + " : ");
            tr.getTransactions().forEach(transaction -> {
                if (transaction.getAsset() != null) {
                    System.out.println("- le type de la transaction : " + transaction.getType() + " || le nom de l'asset: " + transaction.getAsset().getNomAsset() + " || - la quantité: " + transaction.getQuantite() + "|| - la date :" + transaction.getDate());
                }
            });
        } else {
            System.out.println("----------------------------------------");
            System.out.println("aucune transaction pour ce trader");
            System.out.println("----------------------------------------");
        }

    }

    public void filterByType(int choix) {
        List<Transaction> filtredTransactions = new ArrayList<>();
        if (choix == 1) {
            filtredTransactions = transactions.stream().filter(transaction -> transaction.getType().equals("Achat")).toList();
            System.out.println("-------les transactions : ACHAT ---------");
        }
        if (choix == 2) {
            filtredTransactions = transactions.stream().filter(transaction -> transaction.getType().equals("Vente")).toList();
            System.out.println("-------les transactions : VENTE ---------");
        }
        if (filtredTransactions.isEmpty()) {
            System.out.println("----------------------------------------");
            System.out.println("aucune transaction pour le moment ");
            System.out.println("----------------------------------------");
            return;
        }
        filtredTransactions.forEach(transaction -> {
            System.out.println("- le type de la transaction : " + transaction.getType() + " || le nom de l'asset: " + transaction.getAsset().getNomAsset() + " || - la quantité: " + transaction.getQuantite() + "|| - la date :" + transaction.getDate());
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        });

    }

    public void filteByActif(String code) {
        Asset asset = chercherAsset(code);
        List<Transaction> transactionsByType = transactions.stream()
                .filter(transaction -> transaction.getAsset() == asset).toList();
        System.out.println("-------transactions : " + asset.getCode() + "-----------");
        transactionsByType.forEach(transaction ->
                System.out.println(" - le nom de l'asset: " + transaction.getAsset().getNomAsset() + "|| -le code :" + transaction.getAsset().getCode() + " || - le type de trasaction : " + transaction.getType() + " || -la quantité: " + transaction.getQuantite())
        );
    }

    public void filterBydate(int debut , int fin) {

    }

    public void trierBymontant() {
        if(!transactions.isEmpty()){
            Collections.sort(transactions, (tran1, tran2) -> (int) (tran2.getPrix() - tran1.getPrix()));
            System.out.println("--------- trie par montant ---------");
            transactions.forEach(transaction ->
                    System.out.println("- le prix total : " + transaction.getPrix() + "$ || - le nom de l'asset: " + transaction.getAsset().getNomAsset() + "|| -le code :" + transaction.getAsset().getCode() + " || - le type de trasaction : " + transaction.getType() + " || -la quantité: " + transaction.getQuantite())
            );
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println("----------------------------------------");
            System.out.println("aucune transaction pour le moment ");
            System.out.println("----------------------------------------");
        }

    }

    public void trierByDate(){
        if(!transactions.isEmpty()){
            Collections.sort(transactions, Comparator.comparing(Transaction::getDate, Comparator.reverseOrder()));
            System.out.println("------ trie par date ---------");
            transactions.forEach(transaction ->
                    System.out.println("- la date :" + transaction.getDate() + " || - le prix total : " + transaction.getPrix() + "$ || - le nom de l'asset: " + transaction.getAsset().getNomAsset() + "|| -le code :" + transaction.getAsset().getCode() + " || - le type de trasaction : " + transaction.getType() + " || -la quantité: " + transaction.getQuantite())
            );
            System.out.println("----------------------------------------");
            System.out.println("----------------------------------------");
        }else{
            System.out.println("----------------------------------------");
            System.out.println("aucune transaction pour le moment ");
            System.out.println("----------------------------------------");
        }

    }


}
