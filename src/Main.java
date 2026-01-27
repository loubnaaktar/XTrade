
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
static Scanner sc = new Scanner(System.in);

public static void ajouterTrader(){
    System.out.print("entrez votre nom : ");
}

    public static void main(String[] args) {
    int ch;

        System.out.println("-----------------------MENU -----------------------------");
        System.out.println("1- ADMIN\n" +
                "2- UTILISATEUR");
        System.out.print("entrez votre choix: ");
        ch = sc.nextInt();
        if(ch == 1){
            System.out.println("1- ajouter actif \n" +
                    "2- modifier actitif");
            System.out.print("entrez votre choix: ");
            int choix = sc.nextInt();
            switch(choix){
                case 1 -> System.out.println("ajouter actif ");
                case 2 -> System.out.println("modifier actitif");
                default -> System.out.println("entrez 1 ou 2 ");
            }
        }else if(ch == 2){
            System.out.println("1- ajouter trader\n" +
                    "2- afficher les actifs\n" +
                    "3- Créer un portefeuille\n" +
                    "4- Consulter un portefeuille\n" +
                    "5- Acheter un actif\n" +
                    "6- Vendre un actif\n" +
                    "7- Historique");
            System.out.print("entrez votre choix: ");
            int c = sc.nextInt();
            switch(c){
                case 1 -> System.out.println("ajouter trader");
                case 2 -> System.out.println("afficher les actifs");
                case 3 -> System.out.println("réer un portefeuille");
                case 4 -> System.out.println("Acheter un actif");
                case 5 -> System.out.println("cheter un actif");
                case 6 -> System.out.println("Vendre un actif");
                case 7 -> System.out.println("Historique");
                default -> System.out.println("entrez un nombre entre 1 et 7");
            }
        }else{
            System.out.println("choisisez 1 ou 2 ");
        }


    }

}