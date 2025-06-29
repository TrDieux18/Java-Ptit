import java.util.Scanner;

class sach {
    private String ma, ten, nhaXB;
    private double gia;
    public static int sMa = 1;

    public sach(String ten, String nhaXB, double gia) {
        this.ten = ten;
        this.nhaXB = nhaXB;
        this.ma = gMa(nhaXB) + String.format("%03d", sMa++);
        this.gia = gia;
    }

    public String gMa(String s) {
        String[] words = s.toUpperCase().split("\\s+");
        String ans = "";
        for (String word : words) {
            ans += word.charAt(0);
        }
        return ans;
    }

    public String getTen() {
        return ten;
    }

    public String getNhaXB() {
        return nhaXB;
    }

    public String getMa() {
        return ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setNhaXB(String nhaXB) {
        this.nhaXB = nhaXB;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}

// interface ISach {
//     double getGiaBan();
// }

class SachThamKhao extends sach  {
    private boolean dungChung;

    public SachThamKhao(String ten, String nhaXB, double gia, boolean dungChung) {
        super(ten, nhaXB, gia);
        this.dungChung = dungChung;
    }

    public void nhap(Scanner in) {
        setTen(in.nextLine());
        setNhaXB(in.nextLine());
        setGia(Double.parseDouble(in.nextLine()));
        dungChung = Boolean.parseBoolean(in.nextLine());
    }

    public String loaiSach() {
        return dungChung ? "Dung chung sgk" : "khong";
    }

  
    public double getGiaBan() {
        double giaBan = getGia();
        if (getNhaXB().equalsIgnoreCase("giao duc")) {
            giaBan = giaBan * 0.95;
        }
        if(dungChung) giaBan = giaBan *0.9;
        return Math.round(giaBan);
    }

    @Override
    public String toString() {
        return getMa() + " " + getTen() + " " + getNhaXB() + " " + loaiSach() + " " + String.format("%.0f", getGiaBan());
    }
}

public class Bai5_Ktr2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        SachThamKhao book1 = new SachThamKhao("de va van mau", "giao duc", 67000, true);
        SachThamKhao book2 = new SachThamKhao("so tay toan", "thien an", 36000, false);

      
        System.out.println(book1.toString());
        System.out.println(book2.toString());

        scanner.close();
    }
}
