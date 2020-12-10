package services;

import dao.postgresql.RdcDaoImpl;
import model.Rdc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
