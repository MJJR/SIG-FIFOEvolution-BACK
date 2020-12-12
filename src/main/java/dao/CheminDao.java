package dao;

import model.Chemin;
import model.QrCode;

import java.util.List;

public interface CheminDao {
    List<Chemin> findAllChemin();

    Chemin findCheminById(int id);

    void insertChemin(Chemin ch);

    void updateChemin(Chemin ch);

    void executeUpdateChemin(Chemin ch);

    void deleteChemin(Chemin ch);
}
