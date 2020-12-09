package services;

import dao.postgresql.EtageDaoImpl;
import model.Etage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/etage")
public class EtageService {

    @Resource
    EtageDaoImpl etagedao;

    @GetMapping(value="/etageList")
    public List<Etage> getEtage(){
        return etagedao.findAllEtage();
    }

}
