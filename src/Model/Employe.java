package Model;

public class Employe extends Personne{
    private int salaire;
    private String zone;

    public Employe(String nom, String prenom, String adresse, int salaire, String zone) {
        super(nom, prenom, adresse);
        this.salaire = salaire;
        this.zone = zone;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public int getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "salaire=" + salaire +
                ", zone='" + zone + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
