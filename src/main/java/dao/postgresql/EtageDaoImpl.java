package dao.postgresql;

import dao.EtageDao;
import mapper.EtageRowMapper;
import model.Etage;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtageDaoImpl implements EtageDao {

    NamedParameterJdbcTemplate template;

    public EtageDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }

    @Override
    public List<Etage> findAllEtage() {
        return template.query("select * from etage", new EtageRowMapper());
    }

    public Etage findEtageByName(String name){
        return null;
    }

    @Override
    public void insertEtage(Etage e) {

    }

    @Override
    public void updateEtage(Etage e) {

    }

    @Override
    public void executeUpdateEtage(Etage e) {

    }

    @Override
    public void deleteEtage(Etage e) {

    }
}
