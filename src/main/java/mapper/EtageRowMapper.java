package mapper;


import model.Etage;

import org.geolatte.geom.Geometry;
import org.postgresql.util.PGobject;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EtageRowMapper implements RowMapper<Etage> {
    @Override
    public Etage mapRow(ResultSet rs, int i) throws SQLException {
        Etage e = new Etage();
        e.setGid(rs.getInt("gid"));
        e.setId(rs.getInt("id"));
        e.setNom(rs.getString("nom"));
        e.setGeometry(rs.getObject("geom", PGobject.class));

        return e;
    }
}
