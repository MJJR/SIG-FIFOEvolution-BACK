package dao.postgresql;

import dao.EtageDao;
import mapper.EtageRowMapper;
import model.Etage;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtageDaoImpl implements EtageDao {

    NamedParameterJdbcTemplate template;

    public EtageDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Etage> findAllEtage() {
        return template.query("select * from etage", new EtageRowMapper());
    }

    public Etage findEtageByName(String name) {

        return template.query("select * from etage where nom = '"+name+"'", new EtageRowMapper()).get(0);
    }

    @Override
    public void insertEtage(Etage e) {

    }

    @Override
    public void updateEtage(Etage e) {
        String requete = "update etage set id=:id, nom=:nom, geom=:geom where gid=:gid";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", e.getId())
                .addValue("nom", e.getNom())
                .addValue("geom", e.getGeometry())
                .addValue("gid",e.getGid());

        template.update(requete, param, holder );
    }

    @Override
    public void executeUpdateEtage(Etage e) {

    }

    @Override
    public void deleteEtage(Etage e) {

    }
}
