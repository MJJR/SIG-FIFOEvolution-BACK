package services;

import dao.postgresql.QrCodeDaoImpl;
import model.Etage;
import model.QrCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(value = "/qrcodeUpdate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateQrCode(@RequestBody QrCode qr){
        qrcodedao.updateQrCode(qr);
    }

}
