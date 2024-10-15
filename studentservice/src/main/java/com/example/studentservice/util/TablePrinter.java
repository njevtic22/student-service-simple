package com.example.studentservice.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

@Component
@Scope("prototype")
public class TablePrinter {
    private final ArrayList<String[]> rows = new ArrayList<>();
    private final HashSet<Integer> lineIndexes = new HashSet<>();
    private int[] widths;

    public TablePrinter() { }

    public void addRow(String... row) {
        if (widths == null) {
            widths = new int[row.length];
        }

        if (widths.length != row.length) {
            throw new IllegalArgumentException("Table must have fixed number of rows");
        }

        rows.add(row);
        for (int i = 0; i < widths.length; i++) {
            if (widths[i] - 4 < row[i].length()) {
                widths[i] = row[i].length() + 4;
            }
        }
    }

    public void addLine() {
        lineIndexes.add(rows.size());
    }

    public boolean isEmpty() {
        return rows.size() == 1 || rows.isEmpty();
    }

    public void clear() {
        rows.clear();
        lineIndexes.clear();
        widths = null;
    }

    public void print(PrintWriter out) {
        StringBuilder builder = new StringBuilder(widths.length * 5);
        builder.append("+");
        for (int width : widths) {
            builder.append("-".repeat(width)).append("+");
//             builder.append(new String(new char[width]).replace("\0", "-"));
        }
        String line = builder.toString();

        int i;
        for (i = 0; i < rows.size(); i++) {
            if (lineIndexes.contains(i)) {
                out.println(line);
            }

            String[] row = rows.get(i);
            for (int j = 0; j < row.length; j++) {
                out.print("|");
                out.print(center(row[j], widths[j]));
            }
            out.println("|");
        }

        if (lineIndexes.contains(i)) {
            out.println(line);
        }
    }

    private String center(String str, int width) {
        int emptySize = width - str.length();
        int leftInclusive = str.length() + emptySize / 2;

        str = String.format("%" + leftInclusive + "s", str);
        return String.format("%-" + width  + "s", str);
    }
}
