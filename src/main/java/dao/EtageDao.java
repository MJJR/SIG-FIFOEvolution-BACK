package dao;

import model.Etage;

import java.util.List;

public interface EtageDao {
    List<Etage> findAllEtage();

    Etage findEtageByName(String name);

    void insertEtage(Etage e);

    void updateEtage(Etage e);

    void executeUpdateEtage(Etage e);

    void deleteEtage(Etage e);
}
