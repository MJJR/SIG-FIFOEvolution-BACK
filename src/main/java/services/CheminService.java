package services;

import dao.postgresql.CheminDaoImpl;
import model.Chemin;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/chemin")
public class CheminService {

    @Resource
    CheminDaoImpl chdao;

    @GetMapping(value = "/cheminList")
    public List<Chemin> getChemin(){
        return chdao.findAllChemin();
    }

    @GetMapping(value = "/{id}")
    public Chemin getCheminById( @PathVariable int id){ return chdao.findCheminById(id);}

}
