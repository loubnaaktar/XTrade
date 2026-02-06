
import org.w3c.dom.ls.LSOutput;

import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static Market market = new Market();


    public static void main(String[] args) {


        int ch;
        do {

            System.out.println("-----------------------MENU -----------------------------");
            System.out.println("1- ADMIN\n" +
                    "2- UTILISATEUR\n" +
                    "3- Quitter");
            System.out.print("entrez votre choix: ");
            ch = sc.nextInt();
            if (ch == 1) {
                int choix;
                do {
                    System.out.println("1- ajouter actif \n" +
                            "2- modifier actitif\n" +
                            "3- Retour");
                    System.out.print("entrez votre choix: ");
                    choix = sc.nextInt();
                    switch (choix) {
                        case 1 -> ajouterActif();
                        case 2 -> changerPrix();
                        case 3 -> System.out.println("retour");
                        default -> System.out.println("entrez un nombre entre 1 et 3 ");
                    }
                } while (choix != 3);

            } else if (ch == 2) {
                int c;
                do {
                    System.out.println("1- ajouter trader\n" +
                            "2- afficher les actifs\n" +
                            "3- Consulter un portefeuille\n" +
                            "4- Acheter un actif\n" +
                            "5- Vendre un actif\n" +
                            "6- Historique\n" +
                            "7- Filter les transactions \n" +
                            "8- Trier les transactions \n" +
                            "9- Calcule de volume des actifs et d'achats et ventes \n" +
                            "10- Analyse de performance par trader\n" +
                            "11- Analyse globale du marché simulé\n" +
                            "12- Retour "
                    );
                    System.out.print("entrez votre choix: ");
                    c = sc.nextInt();
                    switch (c) {
                        case 1 -> ajouterTrader();
                        case 2 -> market.AfficherActifs();
                        case 3 -> consulterPf();
                        case 4 -> acheterAsset();
                        case 5 -> vendreAsset();
                        case 6 -> historiqueTransaction();
                        case 7 -> filterTransaction();
                        case 8 -> trierTransactions();
                        case 9 -> calculeTransactions();
                        case 10 -> AnalyseTraders();
                        case 11 -> analyseMarche();
                        case 12 -> System.out.println("Retour");
                        default -> System.out.println("entrez un nombre entre 1 et 12");
                    }
                } while (c != 12);
            } else if (ch == 3) {
                System.out.println("Merci");
            } else {
                System.out.println("choisisez 1 ou 2 ");
            }
        } while (ch != 3);

    }

    public static void ajouterTrader() {

        sc.nextLine();
        System.out.print("entrez votre nom :");
        String nom = sc.nextLine();
        System.out.print("entrez votre solde initial: ");
        double solde = sc.nextFloat();
        Trader tr = new Trader(nom, solde);
        market.AjouterTrader(tr);

    }

    public static void ajouterActif() {
        System.out.println("entrez le type d'actif que vous voulez ajouter :\n" +
                "1- stock\n" +
                "2- crypto\n");
        System.out.print("entrez votre choix: ");
        int ch = sc.nextInt();

        sc.nextLine();
        System.out.print("entrez le code : ");
        String code = sc.nextLine();
        System.out.print("entrez le nom: ");
        String nom = sc.nextLine();
        System.out.print("entrez le prix unitaire : ");
        double prix = sc.nextDouble();
        if (ch == 1) {
            Stock stock = new Stock(code, nom, prix);
            market.AjouterActif(code, stock);
        } else if (ch == 2) {
            CryptoCurrency cr = new CryptoCurrency(code, nom, prix);
            market.AjouterActif(code, cr);
        } else {
            System.out.println("entrez 1 ou 2 ");
        }
    }


    public static void changerPrix() {
        sc.nextLine();
        System.out.print("Entrez le code de l’asset dont vous voulez changer le prix: ");
        String code = sc.nextLine();
        Asset a = market.chercherAsset(code);
        if (a != null) {
            System.out.print("entrez le nouveau prix unitaire: ");
            double nvprix = sc.nextDouble();
            market.changerPrix(a, nvprix);
        } else {
            System.out.println("Asset n'existe pas! ");
        }
    }

    public static void consulterPf() {
        System.out.print("entrez Id du trader: ");
        market.ConsulterPortefeuille(sc.nextInt());
    }

    public static void acheterAsset() {
        System.out.print("entrez votre id : ");
        Trader tr = market.chercherTrader(sc.nextInt());
        if (tr != null) {
            sc.nextLine();
            market.AfficherActifs();
            System.out.print("entrez le code de l'asset à acheter: ");
            Asset a = market.chercherAsset(sc.nextLine());
            if (a != null) {
                System.out.print("entrez la quantité que vous voulez acheter: ");
                int quantite = sc.nextInt();
                market.AcheterActif(tr, a, quantite);
            }
        }

    }

    public static void vendreAsset() {
        System.out.print("entrez votre id : ");
        Trader tr = market.chercherTrader(sc.nextInt());
        if (tr != null) {
            sc.nextLine();
            System.out.print("entrez le code de l'asset à vendre: ");
            Asset a = market.chercherAsset(sc.nextLine());
            if (a != null) {
                if (tr.getPortfolio().getAssets().contains(a)) {
                    System.out.print("entrez la quantité que vous voulez vendre: ");
                    int quantite = sc.nextInt();
                    market.vendreActif(tr, a, quantite);
                } else {
                    System.out.println("cet asset n'existe pas chez vous !");
                }

            }
        }

    }

    public static void historiqueTransaction() {

        System.out.println("Voulez-vous voir l’historique général ou l’historique d’un trader ? : 1- historique général \n" +
                " 2- l'historique d'un trader ");
        System.out.print("entrez votre choix: ");
        int choix = sc.nextInt();
        if (choix == 1) {
            market.Historique();
        } else if (choix == 2) {
            System.out.print("entrez l'id du trader:");
            Trader tr = market.chercherTrader(sc.nextInt());
            if (tr != null) {
                market.transisionTrader(tr);
            }
        } else {
            System.out.println("entrez 1 ou 2 ");
        }
    }

    public static void filterTransaction() {
        System.out.println("fliter par : \n" +
                "1- Type (achat / vente) \n" +
                "2- Actif financier (ex : AAPL, BTC, EUR/USD) \n" +
                "3- Intervalle de dates\n" +
                "4- Retour");
        System.out.print("entrez votre choix :");
        int c = sc.nextInt();
        if (c == 1) {
            System.out.println("choisisez : 1- Achat || 2- Vente ");
            System.out.print("entrez votre choix : ");
            int choix = sc.nextInt();
            market.filterByType(choix);
        }else if(c == 2){
            sc.nextLine();
            System.out.print("entrez le code d'Actif à chercher: ");
            market.filteByActif(sc.nextLine());
        }else if(c == 3){
            System.out.print("entrez la date de début: ");
           int debut = sc.nextInt();
            System.out.println("entrez la date de fin: ");
            int fin = sc.nextInt();
            market.filterBydate(debut,fin);
        }
    }

    public static void trierTransactions(){

        System.out.println("1- trier par montant || 2- trier par date ");
        System.out.print("entrez votre choix: ");
        int choix = sc.nextInt();
       if(choix == 1){
           market.trierBymontant();
        }else if(choix == 2){
           market.trierByDate();
       }
    }

    public static void calculeTransactions(){
        System.out.println("-----------------------------------------");
        System.out.println("1-  voir le volume total échangé par actif \n" +
                "2- voir le montant total des achats et des ventes");
        System.out.print("entrez votre choix: ");
        int c = sc.nextInt();
        if(c == 1){
            sc.nextLine();
            System.out.print("entrez le code de l'actif : ");
            market.calculeVolumeActif(sc.nextLine());
        }
        if(c == 2){
            market.calculeMontantAchat();
            market.calculeMonatantVente();
        }
    }


    public static void AnalyseTraders(){
        System.out.println("1- Calcul du volume total échangé par trader\n" +
                "2- Calcul du nombre total d’ordres passés\n" +
                "3- Classement des traders par volume (top N traders)");
        System.out.print("entrez votre choix: ");
        int c = sc.nextInt();
        if(c == 1){
            System.out.println("entrez l'id du trader: ");
            market.volumeTotalEchangesTrader(sc.nextInt());
        }else if (c == 2){
            System.out.print("entrez l'id du trader: ");
            market.calculeOrdres(sc.nextInt());
        }else if (c == 3){
            System.out.println("entrez un nombre: ");
            market.topTraders(sc.nextInt());

        }else{
            System.out.println("entrez un nombre entre 1 et 3 ");
        }

    }

    public static void analyseMarche(){
        System.out.println("1- Calcul du volume total échangé par instrument financier\n" +
                "2- Identification de l’instrument le plus échangé\n" +
                "3- Calcul du montant total des BUY et des SELL séparément\n");
        System.out.print("entrez votre choix: ");
        int choix = sc.nextInt();
        if(choix == 1){
            System.out.println("1- Stock\n" +
                    "2- Crypto");
            System.out.print("entrez votre choix: ");
            market.volumeActif(sc.nextInt());
        }else if(choix == 2){
            market.plusEchange();
        }else if(choix == 3){

        }else{
            System.out.println("entrez un nombre entre 1 et 3 ");
        }
    }



}