// package BaiTest;
import java.util.Scanner;

public class J01001_Hinh_Chu_Nhat {
    public static Scanner nhap = new Scanner(System.in);
    public static void main(String[] args) {
        int cd = nhap.nextInt(), cr = nhap.nextInt();
        if (cd <= 0 || cr <= 0) {
            System.out.println("0");
        } else {
            int dt = cd * cr;
            int cv = (cd + cr) * 2;
            System.out.println(cv + " " + dt);
        }
    }
}
