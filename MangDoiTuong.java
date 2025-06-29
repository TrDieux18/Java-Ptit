// package CodeJ;
import java.util.Scanner;

public class MangDoiTuong {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MS ms = new MS();
        ms.input(in);
        ms.out();
    }
};

class Vehicle {
    private String vin, manufac, color;
    private int year;
    private double cost;

    public Vehicle() {

    }

    public Vehicle(String vin, String manufac, double cost, int year, String color) {
        this.vin = vin;
        this.manufac = manufac;
        this.year = year;
        this.cost = cost;
        this.color = color;
    }

    public String getVin() {
        return vin;
    }

//    public void setVin(String Vin) {
//        this.vin = vin;
//    }

    public String getManufac() {
        return manufac;
    }

    public void setManuface(String manufac) {
        this.manufac = manufac;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    public void Input(Scanner sc) {
        vin = sc.nextLine();
        manufac = sc.nextLine();
        color = sc.nextLine();
        year = sc.nextInt();
        cost = sc.nextDouble();
    }
};

class MS {
    private Vehicle[] a;
    int n;

    public MS() {

    }

    public void input(Scanner sc) {
        n = sc.nextInt();
        a = new Vehicle[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String ms = sc.next();
            String sx = sc.next();
            String c = sc.next();
            int y = sc.nextInt();
            double cost = sc.nextDouble();
            a[i] = new Vehicle(ms, sx, cost, y, c);
        }
    }

    public void out() {
        for (int i = 0; i < n; i++) {
            System.out.printf("%s %s %.1f %d %s", a[i].getVin(), a[i].getManufac().toUpperCase(), a[i].getCost(), a[i].getYear(),
                    a[i].getColor());
            System.out.println();
        }
        System.out.println(n);
    }
};