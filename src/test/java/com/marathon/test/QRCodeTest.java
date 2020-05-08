package com.marathon.test;

import com.google.zxing.WriterException;
import com.marathon.domain.Car;
import com.marathon.domain.Resident;
import com.marathon.service.QREncoder;

import java.io.IOException;

public class QRCodeTest {
    private static void encodeQRCode() {
        QREncoder qrEncoder = new QREncoder();
        try {
            Resident resident = new Resident();
            resident.setName("John Doe");

            Car car = new Car();
            car.setId(222L);
            car.setColor("Blue");
            car.setMake("Toyota");
            car.setModel("Camry");
            car.setYear("2020");
            car.setLicenseNumber("123TUJ");
            car.setResident(resident);

            qrEncoder.encodeQRCode(car);
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        QRCodeTest.encodeQRCode();
    }
}
