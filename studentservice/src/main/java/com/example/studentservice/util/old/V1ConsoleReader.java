package com.example.studentservice.util.old;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Klasa je razvijena kao singleton radi obezbedjivanja postojanja isključivo
 * jedne instance skenera, što omogućava njegovo bezbedno zatvaranje
 * prilikom zatvaranja programa
 *
 * OOP1 project
 */
public class V1ConsoleReader {
    private static V1ConsoleReader instance;
    private Scanner sc = new Scanner(System.in);

    private V1ConsoleReader(){ }

    public static V1ConsoleReader getInstance() {
        if (instance == null)
            instance = new V1ConsoleReader();
        return instance;
    }

    // nextShort

    public String nextLine(String label) {
        System.out.print(label);
        String s = sc.nextLine();
        while (s.isEmpty()) {
            System.out.println("\nGreška. Niste ništa uneli.\nPokušajte ponovo.\n");
            System.out.print(label);
            s = sc.nextLine();
        }
        return s.trim();
    }

    public int nextInt(String label) {
        int i = 0;
        boolean notRead = true;
        do {
            try {
                System.out.print(label);
                i = sc.nextInt();
                notRead = false;
            } catch (InputMismatchException e) {
                System.out.println("\nGreška u unosu. Nije unet ceo broj ili je došlo do prekoračenja.");
                System.out.println("Pokušajte ponovo.\n");
            }
            sc.nextLine();

//            try {
//                i = Integer.parseInt(nextLine(label));
//                notRead = false;
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
        } while (notRead);
        return i;
    }

    public long nextLong() {
        long l = 0L;
        boolean notRead = true;
        do {
            try {
                l = sc.nextLong();
                notRead = false;
            } catch (InputMismatchException e) {
                System.out.println("\nGreška u unosu. Nije unet ceo broj ili je došlo do prekoračenja.");
                System.out.println("Pokušajte ponovo.");
                System.out.print("Unesite ceo broj: ");
            }
            sc.nextLine();
        } while (notRead);
        return l;
    }

    public float nextFloat() {
        float f = 0f;
        boolean notRead = true;
        do {
            try {
                f = sc.nextFloat();
                notRead = false;
            } catch (InputMismatchException e) {
                System.out.println("\nGreška u unosu. Nije unet realan broj ili je došlo do prekoračenja.");
                System.out.println("Pokušajte ponovo.");
                System.out.print("Unesite realni broj: ");
            }
            sc.nextLine();
        } while (notRead);
        return f;
    }

    public double nextDouble(String label) {
        double d = 0D;
        boolean notRead = true;
        do {
            try {
                System.out.print(label);
                d = sc.nextDouble();
                notRead = false;
            } catch (InputMismatchException e) {
                System.out.println("\nGreška u unosu. Nije unet realni broj ili je došlo do prekoračenja.");
                System.out.println("Pokušajte ponovo.\n");
            }
            sc.nextLine();
        } while (notRead);
        return d;
    }

    public byte nextByte() {
        byte b = 0;
        boolean notRead = true;
        do {
            try {
                b = sc.nextByte();
                notRead = false;
            } catch (InputMismatchException e) {
                System.out.println("\nGreška u unosu. nije uneta 8-bitna vrednost.");
                System.out.println("Pokušajte ponovo.");
                System.out.print("Unesite 8-bitnu vrednost: ");
            }
            sc.nextLine();
        } while (notRead);
        return b;
    }

    public char nextChar() {
        char c = '\u0000';
        boolean notRead = true;
        do {
            String s = sc.nextLine().trim();
            if (s.length() == 1) {
                c = s.charAt(0);
                notRead = false;
            } else {
                System.out.println("\nGreška u unosu. Nije unet jedan karakter.");
                System.out.println("Pokušajte ponovo.");
                System.out.print("Unesite jedan karakter: ");
            }
        } while (notRead);
        return c;
    }

    public boolean nextBoolean() {
        boolean b = false;
        boolean notRead = true;
        do {
            try {
                b = sc.nextBoolean();
                notRead = false;
            } catch (InputMismatchException e) {
                System.out.println("\nGreška u unosu. Nije uneta boolean vrednost.");
                System.out.println("Pokušajte ponovo.");
                System.out.print("Unesite boolean vrednost: ");
            }
            this.sc.nextLine();
        } while (notRead);
        return b;
    }

    public String nextStringDecision() {
        String s = sc.nextLine().trim();
        while (!s.equalsIgnoreCase("da") && !s.equalsIgnoreCase("ne")) {
            System.out.println("\nGreška u unosu. Niste uneli \"da\" ili \"ne\".");
            System.out.println("Pokušajte ponovo.");
            System.out.print("Donesite odluku (unesite \"da\" ili \"ne\"): ");
            s = sc.nextLine().trim();
        }
        return s;
    }

    public boolean nextDecision(String label) {
        System.out.print(label);
        String s = sc.nextLine().trim();
        while (!s.equalsIgnoreCase("da") && !s.equalsIgnoreCase("ne")) {
            System.out.println("\nGreška u unosu. Niste uneli \"da\" ili \"ne\".");
            System.out.println("Pokušajte ponovo.\n");
            System.out.print(label);
            s = sc.nextLine().trim();
        }
        return s.equalsIgnoreCase("da");
    }

    public Date nextDate(String label) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
        formatter.setLenient(false);
        Date date = null;

        boolean notRead = true;
        do {
            try {
                System.out.println("Datum mora biti unet u formatu \"dd.MM.yyyy. HH:mm\"");
                System.out.print(label);
                date = formatter.parse(sc.nextLine().trim());
                notRead = false;
            } catch (ParseException e) {
                System.out.println("\nGreška u unosu. Nije unet ispravan oblik datuma.");
                System.out.println("Pokušajte ponovo.\n");
            }
        } while (notRead);
        return date;
    }

    public void closeScanner() {
        sc.close();
    }
}
