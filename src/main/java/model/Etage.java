package model;



import org.geolatte.geom.Geometry;
import org.postgresql.util.PGobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etage")
public class Etage {
    @Id
    private int gid;
    private int id;
    private String nom;
    private PGobject geometry;

    public Etage(){

    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public PGobject getGeometry() {
        return geometry;
    }

    public void setGeometry(PGobject geometry) {
        this.geometry = geometry;
    }
}
