package dao.postgresql;

import dao.QrCodeDao;
import mapper.EtageRowMapper;
import mapper.QrCodeRowMapper;
import mapper.RdcRowMapper;
import model.Etage;
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

    /*
    * On part principe que seul le nom changera durant la mise à jour
    * */
    @Override
    public void updateQrCode(QrCode qr) {

        //Nom que l'on souhaite
        String name = qr.getNom();

        //IL FAUT D'ABORD ATTRAPER LE NOM AVANT QUE L'ON DEMANDE LA MISE A JOUR !
        String nameBefore = template.query("select * from qr where gid = '"+qr.getGid()+"'", new QrCodeRowMapper()).get(0).getNom();

        //DEBUG
        System.out.println( "name = "+name );
        System.out.println( "nameBefore = "+nameBefore );

        String requete = "update qr set id=:id, nom=:nom, geom=:geom where gid=:gid";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", qr.getId())
                .addValue("nom", qr.getNom())
                .addValue("geom", qr.getGeometry())
                .addValue("gid",qr.getGid());

        template.update(requete, param, holder );

        //RECHERCHE RDC de meme NOM
        List<Rdc> rdc = template.query("select * from rdc where nom = '"+nameBefore+"'", new RdcRowMapper());

        //RECHERCHE ETAGE DE MEME NOM
        List<Etage> et = template.query("select * from etage where nom = '"+nameBefore+"'", new EtageRowMapper());

        //DEBUG
        System.out.println( "!rdc.isEmpty() = "+!rdc.isEmpty() );
        System.out.println( "!et.isEmpty() = "+!et.isEmpty() );

        if(!rdc.isEmpty()){
            requete = "update rdc set id=:id, nom=:nom, geom=:geom where gid=:gid";
            holder = new GeneratedKeyHolder();
            param = new MapSqlParameterSource()
                    .addValue("id", rdc.get(0).getId())
                    // LE NOM DOIT CHANGER !!!
                    .addValue("nom", name)
                    .addValue("geom", rdc.get(0).getGeometry())
                    .addValue("gid",rdc.get(0).getGid());

            template.update(requete, param, holder );
        }
        else if(!et.isEmpty()){
            requete = "update etage set id=:id, nom=:nom, geom=:geom where gid=:gid";
            holder = new GeneratedKeyHolder();
            param = new MapSqlParameterSource()
                    .addValue("id", et.get(0).getId())
                    // LE NOM DOIT CHANGER !!!
                    .addValue("nom", name)
                    .addValue("geom", et.get(0).getGeometry())
                    .addValue("gid",et.get(0).getGid());

            template.update(requete, param, holder );
        }


    }

    @Override
    public void executeUpdateQrCode(QrCode qr) {

    }

    @Override
    public void deleteQrCode(QrCode qr) {

    }
}
