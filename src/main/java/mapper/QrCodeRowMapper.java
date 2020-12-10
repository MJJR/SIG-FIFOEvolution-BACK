package mapper;

import model.QrCode;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QrCodeRowMapper implements RowMapper<QrCode> {
    @Override
    public QrCode mapRow(ResultSet rs, int i) throws SQLException {
        QrCode qr = new QrCode();
        qr.setGid(rs.getInt("gid"));
        qr.setId(rs.getInt("id"));
        qr.setNom(rs.getString("nom"));
        qr.setGeometry(rs.getObject("geom", PGobject.class));

        return qr;
    }
}
