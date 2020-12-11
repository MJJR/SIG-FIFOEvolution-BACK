package services;

import dao.postgresql.RdcDaoImpl;
import model.Etage;
import model.Rdc;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/rdc")
public class RdcService {

    @Resource
    RdcDaoImpl rdcdao;

    @GetMapping(value = "/rdcList")
    public List<Rdc> getRdc() {

        return rdcdao.findAllRdc();
    }

    @GetMapping(value = "/{name}")
    public Rdc getRdcByName(@PathVariable String name){
        return rdcdao.findRdcByName(name);
    }

    @PutMapping(value = "/rdcUpdate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRdc(@RequestBody Rdc rdc){
        rdcdao.updateRdc(rdc);
    }


}
