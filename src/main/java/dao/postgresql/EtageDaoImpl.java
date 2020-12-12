package dao.postgresql;

import dao.EtageDao;
import mapper.EtageRowMapper;
import mapper.QrCodeRowMapper;
import model.Etage;
import model.QrCode;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EtageDaoImpl implements EtageDao {

    NamedParameterJdbcTemplate template;

    public EtageDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Etage> findAllEtage() {
        return template.query("select * from etage", new EtageRowMapper());
    }

    public Etage findEtageByName(String name) {

        return template.query("select * from etage where nom = '"+name+"'", new EtageRowMapper()).get(0);
    }

    @Override
    public void insertEtage(Etage et) {

    }

    @Override
    public void updateEtage(Etage et) {

        //Nom que l'on souhaite
        String name = et.getNom();

        //IL FAUT D'ABORD ATTRAPER LE NOM AVANT QUE L'ON DEMANDE LA MISE A JOUR !
        String nameBefore = template.query("select * from etage where gid = '"+et.getGid()+"'", new EtageRowMapper()).get(0).getNom();

        //DEBUG
        System.out.println( "name = "+name );
        System.out.println( "nameBefore = "+nameBefore );

        String requete = "update etage set id=:id, nom=:nom, geom=:geom where gid=:gid";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", et.getId())
                .addValue("nom", et.getNom())
                .addValue("geom", et.getGeometry())
                .addValue("gid",et.getGid());

        template.update(requete, param, holder );


        //RECHERCHE RDC de meme NOM
        List<QrCode> qrc = template.query("select * from qr where nom = '"+nameBefore+"'", new QrCodeRowMapper());

        //DEBUG
        System.out.println( "!qrc.isEmpty() = "+!qrc.isEmpty() );

        if(!qrc.isEmpty()) {
            requete = "update qr set id=:id, nom=:nom, geom=:geom where gid=:gid";
            holder = new GeneratedKeyHolder();
            param = new MapSqlParameterSource()
                    .addValue("id", qrc.get(0).getId())
                    // LE NOM DOIT CHANGER !!!
                    .addValue("nom", name)
                    .addValue("geom", qrc.get(0).getGeometry())
                    .addValue("gid", qrc.get(0).getGid());

            template.update(requete, param, holder);
        }

    }

    @Override
    public void executeUpdateEtage(Etage et) {

    }

    @Override
    public void deleteEtage(Etage et) {

    }
}
