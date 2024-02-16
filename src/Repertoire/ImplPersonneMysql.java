package Repertoire;

import Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImplPersonneMysql implements IPersonne<Personne> {

    private Connection connection;

    public ImplPersonneMysql() {
        this.connection = new BD().getConnection();
    }

    @Override
    public List<Personne> getAllEmploye(int salaire, String zone) throws SQLException {
        return null;
    }

    @Override
    public List<Personne> getAllDirecteur(String matricule) throws SQLException {
        return null;
    }

    @Override
    public void addPersonne(Personne personne) throws SQLException {
        Boolean result= personne instanceof Employe;
        String choix = (result) ? "salaire" :"matricule";
        String sql = "INSERT INTO personne (nom,prenom,adresse,"+choix+") values (?,?,?,?)";
        PreparedStatement statement= connection.prepareStatement(sql);
        statement.setDouble(1,personne.getNom());
        statement.setString(2,personne.getPrenom());
        statement.setString(3,personne.getAdresse());
        if ((result)) {
            statement.setInt(4, ((Employe) personne).getSalaire());
        }else {
            statement.setDouble(4, ((Directeur) personne).getMatricule());
        }

        statement.executeUpdate();
    }

    @Override
    public void DeleteByMatricule(int id) throws SQLException {
        String sql = "Delete from matricule where id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        statement.executeUpdate();
    }

    @Override
    public void updatePersonne(int id, Personne personne) throws SQLException {
        Boolean result= personne instanceof Employe;
        String choix = (result) ? "salaire" :"matricule";

        String sql = "Update personne SET nom = ? , prenom = ? " +
                ", adresse = ?, "+choix+" = ? where id= ?";

        System.out.println(sql);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1,personne.getNom());
        statement.setString(2,personne.getPrenom());
        statement.setString(3,personne.getAdresse());
        if ((result)) {
            statement.setInt(4, ((Employe) personne).getSalaire());
        } else {
            statement.setDouble(4, ((Directeur) personne).getMatricule());
        }
        statement.setInt(5,id);

        int mw= statement.executeUpdate();

        if(mw == 0){
            throw new SQLException();
        }
    }
}
