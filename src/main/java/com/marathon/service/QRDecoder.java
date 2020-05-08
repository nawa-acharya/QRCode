package com.marathon.service;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.marathon.domain.QRModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QRDecoder {

    private QRModel decodeQRCode(String qrText) throws IOException {
        if (qrText != null) {
            File file = new File(qrText);
            if (file.exists()) {
                BufferedImage bufferedImage = ImageIO.read(file);
                LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedImage);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
                try {
                    Result result = new MultiFormatReader().decode(bitmap);
                    if (result != null) {
                        QRModel qrModel = new QRModel();
                        qrModel.setFilePath(qrText);
                        qrModel.setCar(null);
                        return qrModel;
                    }
                } catch (NotFoundException e) {
                    Logger.getLogger(this.getClass().getSimpleName()).log(Level.SEVERE, e.getMessage());
                    return null;
                }
            }
        }
        return null;
    }
}
