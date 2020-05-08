package com.marathon.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.marathon.domain.Car;
import com.marathon.domain.QRModel;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class QREncoder {
    private static final int QR_HEIGHT = 100;
    private static final int QR_WIDTH = 100;

    public void encodeQRCode(Car car) throws WriterException, IOException {
        String content = "https://webapps.marathoncs.com";
        if (car != null) {
            String filePath = "C:\\Users\\Nawa\\Documents\\Projects\\QRCode\\qrcode-" + car.getId() + ".png";

            QRModel qrModel = new QRModel();
            qrModel.setId(111L);
            qrModel.setCar(car);
            if (qrModel.getIssueDate() == null) {
                qrModel.setIssueDate(new Date());

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.MONTH, 6);
                qrModel.setExpirationDate(calendar.getTime());
            }
            qrModel.setFilePath(filePath);
            //dao.save(qrModel)

            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QR_WIDTH, QR_HEIGHT);
            MatrixToImageWriter.writeToPath(bitMatrix, "png", new File(filePath).toPath());
        }
    }
}
