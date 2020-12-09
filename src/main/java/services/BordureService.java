package services;

import dao.postgresql.BordureDaoImpl;
import model.Bordure;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bordure")
public class BordureService {

    @Resource
    BordureDaoImpl borduredao;

    @GetMapping(value = "/bordureList")
    public List<Bordure> getBordure() {
        return borduredao.findAllBordure();
    }

}
