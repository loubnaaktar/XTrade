
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
static Scanner sc = new Scanner(System.in);
static Market market = new Market();


public static void ajouterTrader(){

    sc.nextLine();
    System.out.print("entrez votre nom :");
    String nom = sc.nextLine();
    System.out.print("entrez votre solde initial: ");
    double solde = sc.nextFloat();
    Trader tr = new Trader(nom,solde);
    market.AjouterTrader(tr);

}

public static void ajouterActif(){
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
    System.out.print("entrez la quantité ajoutée: ");
    int quantite = sc.nextInt();

    if(ch == 1){
     Stock stock = new Stock(code,nom,prix,quantite);
     market.AjouterActif(stock);
    }else if(ch == 2){
    CryptoCurrency cr = new CryptoCurrency(code,nom,prix,quantite);
    market.AjouterActif(cr);
    }else{
        System.out.println("entrez 1 ou 2 ");
    }
}

public static void afficherActifs(){
    System.out.println("choisisez le type que vous voulez consulter :\n" +
            "1- Stock\n" +
            "2- Crypto");
    System.out.print("entrez votre choix: ");
    int num = sc.nextInt();
    market.AfficherActifs(num);
}

public static void changerPrix(){
    sc.nextLine();
    System.out.print("Entrez le code de l’asset dont vous voulez changer le prix: ");
    String code = sc.nextLine();
    Asset a = market.chercherAsset(code);
    if(a != null){
        System.out.print("entrez le nouveau prix unitaire: ");
        double nvprix = sc.nextDouble();
        market.changerPrix(a, nvprix);
    }else{
        System.out.println("Asset n'existe pas! ");
    }
}

public static void consulterPf(){
    System.out.print("entrez Id du portefeuille: ");
    market.ConsulterPortefeuille(sc.nextInt());
}

    public static void main(String[] args) {
    int ch;
do{

        System.out.println("-----------------------MENU -----------------------------");
        System.out.println("1- ADMIN\n" +
                "2- UTILISATEUR\n" +
                "3- Quitter");
        System.out.print("entrez votre choix: ");
        ch = sc.nextInt();
        if(ch == 1){
            int choix;
            do{
            System.out.println("1- ajouter actif \n" +
                    "2- modifier actitif\n" +
                    "3- Retour");
            System.out.print("entrez votre choix: ");
            choix = sc.nextInt();
            switch(choix){
                case 1 -> ajouterActif();
                case 2 -> changerPrix();
                case 3 -> System.out.println("retour");
                default -> System.out.println("entrez un nombre entre 1 et 3 ");
            }
            }while(choix != 3);

        }else if(ch == 2){
            int c;
            do{
            System.out.println("1- ajouter trader\n" +
                    "2- afficher les actifs\n" +
                    "3- Consulter un portefeuille\n" +
                    "4- Acheter un actif\n" +
                    "5- Vendre un actif\n" +
                    "6- Historique\n" +
                    "7- Retour");
            System.out.print("entrez votre choix: ");
            c = sc.nextInt();
            switch(c){
                case 1 -> ajouterTrader();
                case 2 -> afficherActifs();
                case 3 -> consulterPf();
                case 4 -> System.out.println("cheter un actif");
                case 5 -> System.out.println("Vendre un actif");
                case 6 -> System.out.println("Historique");
                case 7 -> System.out.println("Retour");
                default -> System.out.println("entrez un nombre entre 1 et 7");
            }
            }while(c != 8 );
        }else if(ch == 3){
            System.out.println("Merci");
        }else{
            System.out.println("choisisez 1 ou 2 ");
        }
}while(ch != 3);

    }

}