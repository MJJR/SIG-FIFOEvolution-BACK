package dao;

import model.Bordure;

import java.util.List;

public interface BordureDao {
    List<Bordure> findAllBordure();

    Bordure findBordureById(int id);

    void insertBordure(Bordure b);

    void updateBordure(Bordure b);

    void executeUpdateBordure(Bordure b);

    void deleteBordure(Bordure b);
}
