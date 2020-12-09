package mapper;

import model.Rdc;
import org.geolatte.geom.MultiPolygon;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RdcRowMapper implements RowMapper<Rdc> {
    @Override
    public Rdc mapRow(ResultSet rs, int i) throws SQLException {
        Rdc rdc = new Rdc();
        rdc.setGid(rs.getInt("gid"));
        rdc.setId(rs.getInt("id"));
        rdc.setNom(rs.getString("nom"));
        rdc.setGeometry(rs.getObject("geom", PGobject.class));

        return rdc;
    }
}
