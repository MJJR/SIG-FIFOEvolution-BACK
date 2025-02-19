package dao.postgresql;

import dao.CheminDao;
import mapper.CheminRowMapper;
import model.Chemin;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CheminDaoImpl implements CheminDao {

    NamedParameterJdbcTemplate template;

    public CheminDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    @Override
    public List<Chemin> findAllChemin() {
        return template.query("select * from chemins", new CheminRowMapper());
    }

    @Override
    public Chemin findCheminById(int id) {
        return template.query("select * from chemins where id = "+id, new CheminRowMapper()).get(0);
    }

    @Override
    public void insertChemin(Chemin ch) {

    }

    @Override
    public void updateChemin(Chemin ch) {

    }

    @Override
    public void executeUpdateChemin(Chemin ch) {

    }

    @Override
    public void deleteChemin(Chemin ch) {

    }
}
