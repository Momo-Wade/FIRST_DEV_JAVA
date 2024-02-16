import Fonction.Fonctionnalite;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        int choix;

        Fonctionnalite fonctionnalite = new Fonctionnalite();

        do{
            choix = fonctionnalite.menu();

            switch (choix){

                case  1:
                    fonctionnalite.ajoutPersonne();
                    break;
                case  2:
                    //fonctionnalite.printAllPersonne();
                    break;
                case  3:
                    fonctionnalite.DeleteByMatricule();
                    break;
                case  4:
                    break;
                default:
                    System.out.println("!!!");

            }
        }while(choix != 5);




    }
}