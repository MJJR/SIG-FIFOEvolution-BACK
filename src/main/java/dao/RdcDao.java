package dao;

import model.Rdc;

import java.util.List;

public interface RdcDao {
    List<Rdc> findAllRdc();

    Rdc findRdcByName(String name);

    void insertRdc(Rdc rdc);

    void updateRdc(Rdc rdc);

    void executeUpdateRdc(Rdc rdc);

    void deleteRdc(Rdc rdc);

}
