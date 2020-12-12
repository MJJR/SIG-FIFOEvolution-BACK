package model;

import org.postgresql.util.PGobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bordure")
public class Bordure {
    @Id
    private int gid;
    private int id;
    private PGobject geometry;

    public Bordure() {

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
