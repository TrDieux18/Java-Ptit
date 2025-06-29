import java.util.Scanner;
class ThiSinh {

    private String hoten, date;
    private float d1, d2, d3;

    public ThiSinh() {

    }

    public ThiSinh(String hoten, String date, float d1, float d2, float d3) {
        this.hoten = hoten;
        this.date = date;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getD1() {
        return d1;
    }

    public void setD1(float d1) {
        this.d1 = d1;
    }

    public float getD2() {
        return d2;
    }

    public void setD2(float d2) {
        this.d2 = d2;
    }

    public float getD3() {
        return d3;
    }

    public void setD3(float d3) {
        this.d3 = d3;
    }

    public float Sum(){
        return this.d1 + this.d2 + this.d3;
    }
};

public class J04005_KhaiBaoLopThiSinh {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String ht = sc.nextLine();
        String ns = sc.nextLine();
        float d1 = sc.nextFloat();
        float d2 = sc.nextFloat();
        float d3 = sc.nextFloat();
        ThiSinh a = new ThiSinh(ht, ns, d1, d2, d3);
        System.out.printf("%s %s %.1f", a.getHoten(),a.getDate(),a.Sum());
    }
}
