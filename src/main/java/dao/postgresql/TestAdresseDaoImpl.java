package dao.postgresql;

import dao.TestAdresseDao;
import mapper.TestAdresseRowMapper;
import model.TestAdresse;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestAdresseDaoImpl implements TestAdresseDao {

    NamedParameterJdbcTemplate template;

    public TestAdresseDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    @Override
    public List<TestAdresse> findAll() {
        return template.query("select * from addresses", new TestAdresseRowMapper());
    }

    @Override
    public void insertTestAdresse(TestAdresse ta) {

    }

    @Override
    public void updateTestAdresse(TestAdresse ta) {

    }

    @Override
    public void executeUpdateTestAdresse(TestAdresse ta) {

    }

    @Override
    public void deleteTestAdresse(TestAdresse ta) {

    }
}
