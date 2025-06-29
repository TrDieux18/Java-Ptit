/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */
class Sach {

    String ma;

    private String ten, tenNXB;
    private double gia;
    public static int sMa = 1;

    public Sach() {
    }

    public Sach(String ten, String tenNXB, double gia) {
        this.ten = ten;
        this.tenNXB = tenNXB;
        this.ma = formatMa(tenNXB) + String.format("%03d", sMa++);
        this.gia = gia;
    }

    public String formatMa(String s) {
        String[] words = s.toUpperCase().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(word.charAt(0));
        }
        return ans.toString();
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

}

interface ISach {

    double getGiaBan();
}

class SachThamKhao extends Sach implements ISach {

    private boolean dungChung;

    public SachThamKhao() {
    }

    public SachThamKhao(String ten, String tenNXB, double gia, boolean dungChung) {
        super(ten, tenNXB, gia);
        this.dungChung = dungChung;
    }

    public void Nhap(Scanner in) {
        setTen(in.nextLine());
        setTenNXB(in.nextLine());
        setMa(formatMa(getTenNXB()) + String.format("%03d", sMa++));
        setGia(Double.parseDouble(in.nextLine()));
        dungChung = Boolean.parseBoolean(in.nextLine());
    }

    public String loaiSach() {
        return dungChung ? "Dung chung sgk" : "khong";
    }

    @Override
    public double getGiaBan() {
        double giaBan = getGia();
        if (getTenNXB().equalsIgnoreCase("giao duc")) {
            giaBan = giaBan * 0.95;
        }
        if (dungChung) {
            giaBan = giaBan * 0.9;
        }
        return giaBan;
    }

    @Override
    public String toString() {
        return getMa() + " " + getTen() + " " + getTenNXB() + " " + loaiSach() + " " + String.format("%.0f", getGiaBan());
    }
}

public class BaiKtra2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        SachThamKhao[] a = new SachThamKhao[t];
        List<SachThamKhao> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            a[i] = new SachThamKhao();
            a[i].Nhap(sc);
            list.add(a[i]);
        }

        list.sort(((o1, o2) -> Double.compare(o2.getGiaBan(), o1.getGiaBan())));
        for (SachThamKhao i : list) {
            System.out.println(i);
        }
    }
}
