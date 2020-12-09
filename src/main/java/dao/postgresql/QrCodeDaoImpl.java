package dao.postgresql;

import dao.QrCodeDao;
import mapper.QrCodeRowMapper;
import model.QrCode;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

    public QrCode findQrCodeByName(String name) {
        return null;
    }

    @Override
    public void insertQrCode(QrCode qr) {

    }

    @Override
    public void updateQrCode(QrCode qr) {

    }

    @Override
    public void executeUpdateQrCode(QrCode qr) {

    }

    @Override
    public void deleteQrCode(QrCode qr) {

    }
}
