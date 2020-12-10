package mapper;

import model.Chemin;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheminRowMapper implements RowMapper<Chemin> {
    @Override
    public Chemin mapRow(ResultSet rs, int i) throws SQLException {
        Chemin ch = new Chemin();
        ch.setGid(rs.getInt("gid"));
        ch.setId(rs.getInt("id"));
        ch.setGeometry(rs.getObject("geom", PGobject.class));

        return ch;
    }
}
