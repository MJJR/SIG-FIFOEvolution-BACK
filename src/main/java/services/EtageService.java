package services;

import dao.postgresql.EtageDaoImpl;
import model.Bordure;
import model.Etage;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/etage")
public class EtageService {

    @Resource
    EtageDaoImpl etagedao;

    @GetMapping(value = "/etageList")
    public List<Etage> getEtage() {
        return etagedao.findAllEtage();
    }

    @GetMapping(value = "/{name}")
    public Etage getEtageByName(@PathVariable String name){
        return etagedao.findEtageByName(name);
    }

    @PutMapping(value = "/etageUpdate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateEtage(@RequestBody Etage et){
        etagedao.updateEtage(et);
    }

}
