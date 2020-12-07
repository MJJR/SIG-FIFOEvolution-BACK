package dao;

import model.TestAdresse;

import java.util.List;

public interface TestAdresseDao {
    List<TestAdresse> findAll();

    void insertTestAdresse(TestAdresse ta);

    void updateTestAdresse(TestAdresse ta);

    void executeUpdateTestAdresse(TestAdresse ta);

    void deleteTestAdresse(TestAdresse ta);
}
