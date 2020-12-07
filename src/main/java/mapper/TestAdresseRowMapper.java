package mapper;

import model.TestAdresse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TestAdresseRowMapper implements RowMapper<TestAdresse> {

    @Override
    public TestAdresse mapRow(ResultSet rs, int i) throws SQLException {
        TestAdresse ta = new TestAdresse();
        ta.setId(rs.getInt("id"));
        ta.setCity(rs.getString("city"));
        ta.setState(rs.getString("state"));
        ta.setZip(rs.getString("zip"));
        ta.setStreet_address("street_address");
        return ta;
    }
}
