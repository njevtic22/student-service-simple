package com.example.studentservice.faker;

import com.example.studentservice.model.Address;
import com.example.studentservice.util.CycleIterator;
import com.github.javafaker.Faker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class FakerUtil {
    private static String[] courses = {"MR", "XA", "XE", "XO", "XG", "XF", "XI", "XZ", "XM", "XH", "XS", "AI", "AR", "AU",
            "BI", "GT", "E3", "ME", "EE", "GE", "GG", "GR", "GI", "II", "IN", "IM", "IT", "ZR", "ZZ", "MM", "MH", "EM",
            "SP", "PR", "MP", "RA", "ST", "SA", "SL", "SV", "SW", "ER", "MT", "ZK", "ZU", "ES", "ET", "EL", "RS", "LO",
            "SF", "SR", "F2", "A7", "A1", "B1", "C1", "A8", "A4", "E4", "M3", "E1", "I3", "O2", "O1", "G1", "F1", "I5",
            "I4", "I1", "I9", "E6", "E7", "I2", "I7", "I8", "Z3", "Z4", "Z2", "Z1", "I6", "V1", "V2", "M2", "H1", "E8",
            "A3", "S2", "E5", "M1", "E2", "A2", "S1", "A5", "A6", "R1", "R2", "M4", "ZP", "E9", "AJ", "AS", "TS", "EJ",
            "EF", "OJ", "NJ", "IS", "ID", "IJ", "ZS", "ZJ", "SS", "SE", "SI", "SZ", "MB", "PE", "PI", "PM", "DU", "DC",
            "DA", "DL", "DR", "DE", "DJ", "DO", "DG", "DF", "DI", "DV", "DD", "DZ", "DM", "DT", "DH", "DP", "DS", "DN",
            "DB", "DK"};

    public static String generateIndex(Faker faker, Long studentId) {
        String course = faker.options().option(courses);
        int year = faker.number().numberBetween(2010, 2024);
        return course + " " + studentId + "/" + year;
    }

    public static CycleIterator<Address> getAddressIterator() throws IOException {
        File file = new File("./../.././Locations - big.csv");
        BufferedReader in = new BufferedReader(new FileReader(file));

        ArrayList<Address> addresses = new ArrayList<>(1200);
        String line = in.readLine();        // header
        line = in.readLine();
        do {
            String[] addressSplit = line.split(",");
            Address address = new Address(addressSplit[1], addressSplit[2], Integer.parseInt(addressSplit[3]));
            addresses.add(address);
            line = in.readLine();
        } while (line != null);

        in.close();

        return new CycleIterator<>(addresses.toArray(new Address[]{}));
    }

    public static LocalDate generatePastLocalDate(Faker faker, LocalDate referenceDate) {
        return LocalDate.of(
                referenceDate.getYear(),
                faker.number().numberBetween(1, referenceDate.getMonthValue()),       // month
                faker.number().numberBetween(1, 28 + 1)                               // dayOfMonth
        );
    }

    public static String generatePhoneNumber(Faker faker) {
        return "064" + faker.number().digits(7);
    }

    public static String escapeApostrophe(String str) {
        return str.replaceAll("'", "''");
    }
}
