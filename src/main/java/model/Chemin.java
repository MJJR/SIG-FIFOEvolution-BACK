package model;

import org.postgresql.util.PGobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chemins")
public class Chemin {
    @Id
    private int gid;
    private int id;
    private PGobject geometry;

    public Chemin(){

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

    public PGobject getGeometry() {
        return geometry;
    }

    public void setGeometry(PGobject geometry) {
        this.geometry = geometry;
    }
}
