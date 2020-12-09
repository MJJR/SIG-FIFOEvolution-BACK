package dao;

import model.QrCode;

import java.util.List;

public interface QrCodeDao {
    List<QrCode> findAllQrCode();

    QrCode findQrCodeByName(String name);

    void insertQrCode(QrCode qr);

    void updateQrCode(QrCode qr);

    void executeUpdateQrCode(QrCode qr);

    void deleteQrCode(QrCode qr);
}
