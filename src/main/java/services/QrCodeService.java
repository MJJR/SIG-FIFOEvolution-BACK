package services;

import dao.postgresql.QrCodeDaoImpl;
import model.Etage;
import model.QrCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/qrcode")
public class QrCodeService {

    @Resource
    QrCodeDaoImpl qrcodedao;

    @GetMapping(value = "/qrcodeList")
    public List<QrCode> getQrCode() {
        return qrcodedao.findAllQrCode();
    }

    @GetMapping(value = "/{name}")
    public QrCode getQrCodeByName(@PathVariable String name){
        return qrcodedao.findQrCodeByName(name);
    }

}
