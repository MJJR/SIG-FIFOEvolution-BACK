package dao.postgresql;

import dao.RdcDao;
import mapper.QrCodeRowMapper;
import mapper.RdcRowMapper;
import model.QrCode;
import model.Rdc;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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

    /*
     * On part principe que seul le nom changera durant la mise à jour
     * */
    @Override
    public void updateRdc(Rdc rdc) {

        //Nom que l'on souhaite
        String name = rdc.getNom();

        //IL FAUT D'ABORD ATTRAPER LE NOM AVANT QUE L'ON DEMANDE LA MISE A JOUR !
        String nameBefore = template.query("select * from rdc where gid = '"+rdc.getGid()+"'", new RdcRowMapper()).get(0).getNom();

        //DEBUG
        System.out.println( "name = "+name );
        System.out.println( "nameBefore = "+nameBefore );

        String requete = "update rdc set id=:id, nom=:nom, geom=:geom where gid=:gid";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", rdc.getId())
                .addValue("nom", rdc.getNom())
                .addValue("geom", rdc.getGeometry())
                .addValue("gid",rdc.getGid());

        template.update(requete, param, holder );

        //RECHERCHE RDC de meme NOM
        List<QrCode> qrc = template.query("select * from qr where nom = '"+nameBefore+"'", new QrCodeRowMapper());

        //DEBUG
        System.out.println( "!qrc.isEmpty() = "+!qrc.isEmpty() );

        if(!qrc.isEmpty()){
            requete = "update qr set id=:id, nom=:nom, geom=:geom where gid=:gid";
            holder = new GeneratedKeyHolder();
            param = new MapSqlParameterSource()
                    .addValue("id", qrc.get(0).getId())
                    // LE NOM DOIT CHANGER !!!
                    .addValue("nom", name)
                    .addValue("geom", qrc.get(0).getGeometry())
                    .addValue("gid",qrc.get(0).getGid());

            template.update(requete, param, holder );
        }



    }

    @Override
    public void executeUpdateRdc(Rdc rdc) {

    }

    @Override
    public void deleteRdc(Rdc rdc) {

    }
}
