package dao.postgresql;

import dao.BordureDao;
import mapper.BordureRowMapper;
import model.Bordure;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BordureDaoImpl implements BordureDao {

    NamedParameterJdbcTemplate template;

    public BordureDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Bordure> findAllBordure() {
        return template.query("select * from bordure", new BordureRowMapper());
    }

    public Bordure findBordureById(int id) {
        return null;
    }

    @Override
    public void insertBordure(Bordure b) {

    }

    @Override
    public void updateBordure(Bordure b) {

    }

    @Override
    public void executeUpdateBordure(Bordure b) {

    }

    @Override
    public void deleteBordure(Bordure b) {

    }
}
