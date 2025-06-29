import java.util.*;

class NHANVIEN {

    private String id, name, chucVu;
    private int luongCoBan, soNgayCong;
    public static int cnt = 1;

    public NHANVIEN() {
    }

    public void Input(Scanner sc) {
        id = "NV" + String.format("%02d", cnt++); 
        name = sc.nextLine(); 
        chucVu = sc.nextLine(); 
        luongCoBan = Integer.parseInt(sc.nextLine()); 
        soNgayCong = Integer.parseInt(sc.nextLine()); 
    }

   
    public int getLuong() {
        return luongCoBan * soNgayCong;
    }

    public int getPhuccap() {
        int phuCap = 0;
        switch (chucVu) {
            case "GD":
                phuCap = 500;
                break;
            case "PGD":
                phuCap = 400;
                break;
            case "TP":
                phuCap = 300;
                break;
            case "KT":
                phuCap = 250;
                break;
            default:
                phuCap = 100;
                break;
        }
        return phuCap;
    }

    public int getTamung() {
        int tongLuongPhuCap = getPhuccap() + getLuong();
        int tamung = 0;
        if (tongLuongPhuCap * 2 / 3 < 25000) {
            double tu = tongLuongPhuCap * 2 / 3.0;
            tamung = (int) (Math.round(tu / 1000) * 1000);
        } else {
            tamung = 25000;
        }
        return tamung;
    }

   
    public int getConLai() {
        return getLuong() + getPhuccap() - getTamung();
    }

   
    @Override
    public String toString() {
        return id + " " + name + " " + getPhuccap() + " " + getLuong() + " " + getTamung() + " " + getConLai();
    }
}

public class J05043_TinhThuNhapChoNhanVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine()); 
        NHANVIEN[] NHANVIENs = new NHANVIEN[n];
        for (int i = 0; i < n; i++) {
            NHANVIENs[i] = new NHANVIEN();
            NHANVIENs[i].Input(sc); 
        }

        for (NHANVIEN nv : NHANVIENs) {
            System.out.println(nv);
        }
        sc.close();
    }
}
