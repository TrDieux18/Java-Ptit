import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GV {
    private String maNgach, hoTen;
    private int luongCoBan, bacLuong, phuCap;
    private long thuNhap;
    
    private static int countHT = 0;
    private static int countHP = 0;

    public GV() {
    }

    public void Input(Scanner sc) {
        maNgach = sc.nextLine();
        hoTen = sc.nextLine();
        luongCoBan = Integer.parseInt(sc.nextLine());
        this.bacLuong = Integer.parseInt(maNgach.substring(2)); 
        setPhuCap();
        tinhThuNhap();
    }

    public String getMaNgach() {
        return maNgach;
    }

    public long getThuNhap() {
        return thuNhap;
    }

    private void setPhuCap() {
        String chucVu = maNgach.substring(0, 2); 
        switch (chucVu) {
            case "HT":
                if (countHT < 1) {
                    phuCap = 2000000;
                    countHT++;
                } else {
                    phuCap = 0; 
                }
                break;
            case "HP":
                if (countHP < 2) {
                    phuCap = 900000;
                    countHP++;
                } else {
                    phuCap = 0; 
                }
                break;
            case "GV":
                phuCap = 500000;
                break;
            default:
                phuCap = 0; 
                break;
        }
    }

    private void tinhThuNhap() {
        if (phuCap > 0) {
            thuNhap = luongCoBan * bacLuong + phuCap;
        } else {
            thuNhap = 0; 
        }
    }

    @Override
    public String toString() {
        return maNgach + " " + hoTen + " " + bacLuong + " " + phuCap + " " + thuNhap;
    }
}

public class J05064_BangThuNhapGiaoVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<GV> danhSachGV = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            GV gv = new GV();
            gv.Input(sc);
            if (gv.getThuNhap() > 0) { 
                danhSachGV.add(gv);
            }
        }

        for (GV gv : danhSachGV) {
            System.out.println(gv);
        }
        
        sc.close();
    }
}
