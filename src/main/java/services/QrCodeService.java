package services;

import dao.postgresql.QrCodeDaoImpl;
import model.QrCode;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<QrCode> getEtage() {
        return qrcodedao.findAllQrCode();
    }

}
