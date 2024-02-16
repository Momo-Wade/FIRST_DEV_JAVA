package Model;

public class Directeur extends Personne {
    private String matricule;
    public Directeur(String nom, String prenom, String adresse, String matricule) {
        super(nom, prenom, adresse);
        this.matricule = matricule;
    }

    public double getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Directeur{" +
                "matricule='" + matricule + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
