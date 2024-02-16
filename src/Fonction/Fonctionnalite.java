package Fonction;

import Model.Directeur;
import Model.Employe;
import Model.Personne;
import Repertoire.ImplPersonneMysql;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Fonctionnalite {
    Scanner clavier = new Scanner(System.in);
    private ImplPersonneMysql implPersonneMysql;
    public Fonctionnalite(){
        implPersonneMysql = new ImplPersonneMysql();
    }

    public int menu() {
        int choix;

        System.out.println("1-Ajout d'une personne");
        System.out.println("2-Lister les personnes");
        System.out.println("3-Supprimer");
        System.out.println("4-Mettre à jour");
        System.out.println("5-Quitter");
        do{
            choix = clavier.nextInt();
            if(choix<1 || choix >5){
                System.out.println("Le choix est incorrect .");
            }
        }while(choix<1 || choix >5);
        return  choix;
    }

    public int menuTypePersonne(){
        int choix;

        System.out.println("1-Employe");
        System.out.println("2-Directeur");
        do{
            choix = clavier.nextInt();
            if(choix<1 || choix >2){
                System.out.println("Le choix est incorrect .");
            }
        }while(choix<1 || choix >2);
        return  choix;
    }

    public void ajoutPersonne() throws SQLException {
        int type = menuTypePersonne();
        Personne personne = (type == 1) ? new Employe() : new Directeur();

        clavier.nextLine();
        System.out.println("Saisir le nom de la personne");
        personne.setNom(clavier.nextLine());
        System.out.println("Saisir le prenom de la personne");
        personne.setPrenom(clavier.nextLine());
        clavier.nextLine();
        System.out.println("Saisir l'adresse de la personne");
        personne.setAdresse(clavier.nextLine());
        clavier.nextLine();
        if( type == 1 ){
            System.out.println("Saisir le salaire");
            ((Employe)personne).setSalaire(clavier.nextInt());
        }else {
            System.out.println("Saisir le matricule");
            ((Directeur)personne).setMatricule(clavier.nextLine());
        }
        implPersonneMysql.addPersonne(personne);
    }

    public void DeleteByMatricule() throws SQLException {
        int choix;
        printAllPersonne();
        choix = clavier.nextInt();
        implPersonneMysql.DeleteByMatricule(choix);
    }

    private void printAllPersonne() {
        List<Personne> personnes =  implPersonneMysql.findAll();
        for (Personne p: personnes) {
            System.out.println(p.toString());
        }
    }
}
