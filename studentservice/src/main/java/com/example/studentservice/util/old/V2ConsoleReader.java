package com.example.studentservice.util.old;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Class is designed as wrapper around class ConsoleReader in order
 * to handle InputMismatchException and ParseException in a specific vay.
 * Since RawConsoleReader is designed as singleton, this class is also
 * designed as Singleton.
 * Meant for reading exclusively from console (System.in).
 *
 * VEB project
 */
public class V2ConsoleReader {
    private static V2ConsoleReader instance;
    private V2RawConsoleReader reader = V2RawConsoleReader.getInstance();

    private V2ConsoleReader() { }

    public static V2ConsoleReader getInstance() {
        if (instance == null)
            instance = new V2ConsoleReader();
        return instance;
    }

    public byte nextByte() {
        return nextByte("");
    }

    public byte nextByte(String label) {
        byte b = 0;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                b = reader.nextByte();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet broj veličine tipa byte ili je došlo do prekoračenja."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return b;
    }

    public char nextChar() {
        return nextChar("");
    }

    public char nextChar(String label) {
        char c = '\u0000';
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                c = reader.nextChar();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet jedan karakter."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return c;
    }

    public short nextShort() {
        return nextShort("");
    }

    public short nextShort(String label) {
        short s = 0;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                s = reader.nextShort();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet ceo broj ili je došlo do prekoračenja."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return s;
    }

    public int nextInt() {
        return nextInt("");
    }

    public int nextInt(String label) {
        int i = 0;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                i = reader.nextInt();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet ceo broj ili je došlo do prekoračenja."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
//           Another way
//            try {
//                i = Integer.parseInt(nextLine(label));
//                notRead = false;
//            } catch (NumberFormatException e) {
//                e.printStackTrace();
//            }
        } while (notRead);
        return i;
    }

//    Without RawConsoleReader
//    public int nextInt(String label) {
//        int input = 0;
//        boolean read = false;
//
//        do {
//            try {
//                cout.print(label);
//                input = cin.nextInt();
//                read = true;
//
//            } catch (InputMismatchException e) {
//                cout.println("\nYou did not enter integer or there was an overflow.\nTry again.\n");
//            } finally {
//                cin.nextLine();
//            }
//
////           Another way
////            try {
////                i = Integer.parseInt(nextLine(label));
////                read = true;
////            } catch (NumberFormatException e) {
////                e.printStackTrace();
////            }
//        } while (!read);
//        return input;
//    }

    public long nextLong() {
        return nextLong("");
    }

    public long nextLong(String label) {
        long l = 0L;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                l = reader.nextLong();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet ceo broj ili je došlo do prekoračenja."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return l;
    }

    public float nextFloat() {
        return nextFloat("");
    }

    public float nextFloat(String label) {
        float f = 0f;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                f = reader.nextFloat();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet realan broj ili je došlo do prekoračenja."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return f;
    }

    public double nextDouble() {
        return nextDouble("");
    }

    public double nextDouble(String label) {
        double d = 0d;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                d = reader.nextDouble();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet realan broj ili je došlo do prekoračenja."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return d;
    }

    public String nextLine() {
        return nextLine("");
    }

    public String nextLine(String label) {
        String s = "";
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                s = reader.nextLine();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška. Niste ništa uneli.\nPokušajte ponovo.\n"));
            }
        } while (notRead);
        return s;
    }

    public boolean nextBoolean() {
        return nextBoolean("");
    }

    public boolean nextBoolean(String label) {
        boolean b = false;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                b = reader.nextBoolean();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije uneta boolean/logička vrednost."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return b;
    }

    public boolean nextDecision() {
        return nextDecision("");
    }

    public boolean nextDecision(String label) {
        boolean b = false;
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                b = reader.nextDecision();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Niste uneli \"da\" ili \"ne\"."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return b;
    }

    public String nextStringDecision() {
        return nextStringDecision("");
    }

    public String nextStringDecision(String label) {
        String s = "";
        boolean notRead = true;

        do {
            try {
                System.out.print(label);
                s = reader.nextStringDecision();
                notRead = false;

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Niste uneli \"da\" ili \"ne\"."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));
            }
        } while (notRead);
        return s;
    }

    public void changeDateFormat(String newDateFormat) {
        reader.setDateFormat(newDateFormat);
    }

    public Date nextDate() {
        return nextDate("");
    }

    public Date nextDate(String label) {
        Date date = null;
        boolean notRead = true;

        do {
            try {
                // System.out.println(Colors.modifyLikeWarning("Datum mora biti unet u formatu \"" + reader.getDateFormat() + "\""));
                System.out.print(label);
                date = reader.nextDate();
                notRead = false;

            } catch (ParseException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška u unosu. Nije unet ispravan oblik datuma."));
                // System.out.println(Colors.modifyLikeError("Pokušajte ponovo.\n"));

            } catch (InputMismatchException e) {
                // System.out.println(Colors.modifyLikeError("\nGreška. Niste ništa uneli.\nPokušajte ponovo.\n"));
            }
        } while (notRead);
        return date;
    }

    public void closeScanner() {
        reader.closeScanner();
    }
}
