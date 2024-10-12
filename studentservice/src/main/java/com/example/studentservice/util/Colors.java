package com.example.studentservice.util;

// http://ascii-table.com/ansi-escape-sequences.php
// https://en.wikipedia.org/wiki/ANSI_escape_code#3/4_bit, kodovi sa * se razlikuju od wikipedije

// Revise this
public class Colors {
    public static final String end = "\033[0m";

    // sva tri resetuju boju, samo "end" resetuje sve modifikacije (ne samo boju)
    // end_color = "\033[39m";
    // end_color = "\033[49m";
    public static final String end_color = "\033[39;49m";
    // ///////////////////////////////

    // texture
    public static final String bold      = "\033[1m";
    public static final String underline = "\033[4m";
    public static final String blink     = "\033[5m";    // ne prikazuje nista
    public static final String reverse   = "\033[7m";
    public static final String concealed = "\033[8m";    // ne prikazuje nista

    // foreground
    public static final String fWhite    = "\033[30m";   // * na wikipediji je black
    public static final String fRed      = "\033[31m";
    public static final String fGreen    = "\033[32m";
    public static final String fYellow   = "\033[33m";
    public static final String fBlue     = "\033[34m";
    public static final String fMagenta  = "\033[35m";   // vise lici na ljubicastu
    public static final String fDarkCyan = "\033[36m";
    public static final String fGrey     = "\033[37m";   // * na wikipediji je white

    public static final String fBlack         = "\033[90m";  // * na wikipediji je bright black
    public static final String fBrightRed     = "\033[91m";
    public static final String fBrightGreen   = "\033[92m";
    public static final String fBrightYellow  = "\033[93m";
    public static final String fBrightBlue    = "\033[94m";
    public static final String fBrightMagenta = "\033[95m";  // opet vise lici na ljubicastu
    public static final String fBrightCyan    = "\033[96m";  // vise lici na svetlo plavu
    public static final String fDarkBlack     = "\033[97m";  // na wikipediji pise bright white

    // background
    public static final String bWhite   = "\033[40m";    // * na wikipediji je black
    public static final String bRed     = "\033[41m";
    public static final String bGreen   = "\033[42m";
    public static final String bYellow  = "\033[43m";
    public static final String bBlue    = "\033[44m";
    public static final String bMagenta = "\033[45m";    // vise lici na ljubicastu
    public static final String bCyan    = "\033[46m";
    public static final String bGrey    = "\033[47m";    // * na wikipediji je white

    public static final String bBrightBlack   = "\033[100m";
    public static final String bBrightRed     = "\033[101m";
    public static final String bBrightGreen   = "\033[102m";
    public static final String bBrightYellow  = "\033[103m";
    public static final String bBrightBlue    = "\033[104m";
    public static final String bBrightMagenta = "\033[105m"; // vise lici na ljubicastu
    public static final String bBrightCyan    = "\033[106m";
    public static final String bDarkBlack     = "\033[107m";

    public static String likeError(String toModify) {
        return modify(toModify, Colors.fRed);
    }

    public static String likeWarning(String toModify) {
        return modify(toModify, Colors.fYellow);
    }

    public static String modify(String toModify, String colorTexture) {
        String text;
        if (toModify.endsWith(Colors.end) || toModify.endsWith(Colors.end_color))
            text = colorTexture + toModify;
        else
            text = colorTexture + toModify + end;
        return text;
    }

    public static void main(String[] args) {
        String string = "Hello Colored World!";

        System.out.println(Colors.fGreen + Colors.bRed + string);
        System.out.println("asdfasdfasdfads");
        System.out.println(Colors.end);
        System.out.println("sdfasdfja");

        System.out.println(Colors.modify(string, Colors.fBlue + Colors.bYellow + Colors.underline + Colors.bold));
        System.out.println(string);

        System.out.println(Colors.likeError(string));
        System.out.println(Colors.likeWarning(string));
        System.out.println();

        System.out.println(Colors.modify(string, Colors.fBlue));
        System.out.println(Colors.modify(string, Colors.bBlue));

        System.out.println(Colors.likeError(Colors.modify(string, Colors.fBlue)));
        System.out.println(Colors.likeWarning(Colors.modify(string, Colors.bBlue)));
    }
}
