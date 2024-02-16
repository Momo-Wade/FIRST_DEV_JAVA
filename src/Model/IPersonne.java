package Model;

import java.sql.SQLException;
import java.util.List;

public interface IPersonne<T> {

    List<T> getAllEmploye(int salaire, String zone) throws SQLException;
    List<T> getAllDirecteur(String matricule) throws SQLException;
    void addPersonne(T t) throws SQLException;
    void DeleteByMatricule(int id) throws SQLException;
    void updatePersonne(int id,T t) throws SQLException;
}
