package mapper;

import model.Bordure;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BordureRowMapper implements RowMapper<Bordure> {
    @Override
    public Bordure mapRow(ResultSet rs, int i) throws SQLException {
        Bordure b = new Bordure();
        b.setGid(rs.getInt("gid"));
        b.setId(rs.getInt("id"));
        b.setGeometry(rs.getObject("geom", PGobject.class));

        return b;
    }
}
