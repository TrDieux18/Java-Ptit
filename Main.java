// package CodeJ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

class text {
    final String id, name;
    double total = 0, per;

    public text(String s) {
        String[] ss = s.split("\\s+");
        id = "(" + "ID#" + ss[0] + ")";
        name = ss[1];
        for (int i = 2; i < ss.length; i++)
            total += Double.parseDouble(ss[i]);
        per = total / (ss.length - 2);
    }

    @Override
    public String toString() {
        return String.format("%s %s worked %.2f hours (%.2f hours/day)",name, id, total, per);
    }
}

public class Main {
    static PrintStream out = System.out;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("numbers.dat"));
        while (sc.hasNextLine())
            out.println(new text(sc.nextLine()));
        sc.close();
    }
}