package services;

import dao.postgresql.TestAdresseDaoImpl;
import model.TestAdresse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestAdresseService {


    @Resource
    TestAdresseDaoImpl taDao;

    @GetMapping(value = "/testList")
    public List<TestAdresse> getTestAdresse() {

        return taDao.findAll();
    }

    /*
    @GetMapping(value="/createTA")
    public void createTestAdresse(@RequestBody TestAdresse ta){

    }
    */

}
