package dao.postgresql;

import dao.QrCodeDao;
import mapper.QrCodeRowMapper;
import model.QrCode;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QrCodeDaoImpl implements QrCodeDao {

    NamedParameterJdbcTemplate template;

    public QrCodeDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<QrCode> findAllQrCode() {
        return template.query("select * from qr", new QrCodeRowMapper());
    }

    @Override
    public QrCode findQrCodeByName(String name) {

        return template.query("select * from qr where nom = '"+name+"'", new QrCodeRowMapper()).get(0);
    }

    @Override
    public void insertQrCode(QrCode qr) {

    }

    @Override
    public void updateQrCode(QrCode qr) {
        String requete = "update qr set id=:id, nom=:nom, geom=:geom where gid=:gid";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", qr.getId())
                .addValue("nom", qr.getNom())
                .addValue("geom", qr.getGeometry())
                .addValue("gid",qr.getGid());

        template.update(requete, param, holder );
    }

    @Override
    public void executeUpdateQrCode(QrCode qr) {

    }

    @Override
    public void deleteQrCode(QrCode qr) {

    }
}
