
// import java.io.*;
import java.util.*;

class Tour{

    public static int cnt = 1;
    private String ma, tu, den;
    private int soNguoi;
    private double gia;

    public Tour(String tu, String den, double gia, int soNguoi){
        this.ma  = String.format("%03d", cnt++);
        if(tu.charAt(2) != '/'){
            tu = "0" + tu;
        }
        if(tu.charAt(5) != '/'){
            tu = tu.substring(0, 3) + "0" + tu.substring(3);
        }
        this.tu = tu;
        if(den.charAt(2) != '/'){
            den = "0" + den;
        }
        if(den.charAt(5) != '/'){
            den = den.substring(0, 3) + "0" + den.substring(3);
        }
        this.den = den;
        this.gia = gia;
        this.soNguoi = soNguoi;
    }

    public String getTu(){
        return tu;
    }

    public String getDen(){
        return den;
    }

    public String getMa(){
        return ma;
    }

    public int getSoNguoi(){
        return soNguoi;
    }

    public double getGia(){
        return gia;
    }
    public double getThanhTien(){
        if(getSoNguoi() < 5){
            return  getSoNguoi() * getGia();
        }
        if(getSoNguoi() >= 5 && getSoNguoi() <= 10){
            return (getSoNguoi() * getGia()) -(getSoNguoi() *getGia() * 0.1);
        }
        if(getSoNguoi() > 10)
            return (getSoNguoi() * getGia()) -(getSoNguoi() *getGia() * 0.2);

        return 0;
    }

    @Override
    public String toString(){
        return getTu() + "-" + getDen() +"*"+ getMa() + " " + getSoNguoi() + " " + String.format("%0.1f", getGia()) + " "+ String.format("%0.1f", getThanhTien()); 
    }
};
public class Bai1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tour[] a = new Tour[n];
        sc.nextLine();
        for(int i = 0 ; i < a.length; i++){
            String bd = sc.next();
            String kt = sc.next();
            int nguoi = sc.nextInt();
            double cost = sc.nextDouble();
            a[i] =  new Tour(bd, kt, cost, nguoi);
        }
        for(Tour i : a){
            System.out.print(i.getTu() + "-" + i.getDen() +"*" + i.getMa() + " " + i.getSoNguoi() + " " + String.format("%.1f", i.getGia()) + " "+ String.format("%.1f", i.getThanhTien()));
            System.out.println();
        }
        sc.close();
    }
}
