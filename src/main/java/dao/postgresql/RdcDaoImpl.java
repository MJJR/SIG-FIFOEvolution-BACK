package dao.postgresql;

import dao.RdcDao;
import mapper.QrCodeRowMapper;
import mapper.RdcRowMapper;
import model.QrCode;
import model.Rdc;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RdcDaoImpl implements RdcDao {

    NamedParameterJdbcTemplate template;

    public RdcDaoImpl(NamedParameterJdbcTemplate template) {

        this.template = template;
    }

    @Override
    public List<Rdc> findAllRdc() {

        return template.query("select * from rdc", new RdcRowMapper());
    }

    @Override
    public Rdc findRdcByName(String name) {

        return template.query("select * from rdc where nom = '"+name+"'", new RdcRowMapper()).get(0);
    }

    @Override
    public void insertRdc(Rdc rdc) {

    }

    @Override
    public void updateRdc(Rdc rdc) {

    }

    @Override
    public void executeUpdateRdc(Rdc rdc) {

    }

    @Override
    public void deleteRdc(Rdc rdc) {

    }
}
