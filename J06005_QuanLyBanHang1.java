/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.awt.Color;
import java.security.spec.NamedParameterSpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */
class KhachHang {

    private String idKH, nameKH, gioiTinh, ngaySinh, diaChi;
    public static int cnt = 1;

    public KhachHang(String nameKH, String gioiTinh, String ngaySinh, String diaChi) {
        this.idKH = String.format("KH%03d", cnt++);
        this.nameKH = nameKH;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

}

class MatHang {

    private String idH, nameH, donviTinh;
    private int giaMua, giaBan;
    public static int cnt2 = 1;

    public MatHang(String nameH, String donviTinh, int giaMua, int giaBan) {
        this.idH = String.format("MH%03d", cnt2++);
        this.nameH = nameH;
        this.donviTinh = donviTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
    }

    public String getIdH() {
        return idH;
    }

    public void setIdH(String idH) {
        this.idH = idH;
    }

    public String getNameH() {
        return nameH;
    }

    public void setNameH(String nameH) {
        this.nameH = nameH;
    }

    public String getDonviTinh() {
        return donviTinh;
    }

    public void setDonviTinh(String donviTinh) {
        this.donviTinh = donviTinh;
    }

    public int getGiaMua() {
        return giaMua;
    }

    public void setGiaMua(int giaMua) {
        this.giaMua = giaMua;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

}

class HoaDon {

    private String idHD, tenKH, diaChi, tenMH, donviTinh;
    private int giaMua, giaBan, soLuong, thanhTien, tongMua;

    public HoaDon(String idHD, String tenKH, String diaChi, String tenMH, String donviTinh, int giaMua, int giaBan, int soLuong) {
        this.idHD = idHD;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.tenMH = tenMH;
        this.donviTinh = donviTinh;
        this.giaMua = giaMua;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.tongMua = soLuong * giaMua;
        this.thanhTien = soLuong * giaBan;
    }
    
    public int getLoiNhuan(){
        return thanhTien - tongMua;
    }

    public String getIdHD() {
        return idHD;
    }
    

    @Override
    public String toString() {
        return idHD + " " + tenKH + " " + diaChi + " " + tenMH
                +  " " + soLuong + " " + thanhTien + " " + getLoiNhuan();
    }

}

public class J06005_QuanLyBanHang1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> listKH = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listKH.add(new KhachHang(sc.nextLine(), sc.nextLine(),
                    sc.nextLine(), sc.nextLine()));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<MatHang> listMH = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            listMH.add(new MatHang(sc.nextLine(), sc.nextLine(),
                    Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine())));
        }

        int k = Integer.parseInt(sc.nextLine());
        List<HoaDon> listHD = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] data = sc.nextLine().split(" ");
            String idKH = data[0];
            String idMH = data[1];
            int soLuong = Integer.parseInt(data[2]);

            String idHD = String.format("HD%03d", i + 1);

            //Lấy thông tin khách hàng
            KhachHang kh = null;
            for (KhachHang j : listKH) {
                if (j.getIdKH().equals(idKH)) {
                    kh = j;
                    break;
                }
            }

            //Lấy thông mặt hàng
            MatHang mh = null;
            for (MatHang j : listMH) {
                if (j.getIdH().equals(idMH)) {
                    mh = j;
                    break;
                }
            }

            if (kh == null || mh == null) {
                continue;
            }
            listHD.add(new HoaDon(idHD, kh.getNameKH(), kh.getDiaChi(),
                    mh.getNameH(), mh.getDonviTinh(), mh.getGiaMua(),
                    mh.getGiaBan(), soLuong));

        }

        listHD.sort((o1, o2) -> {
            if(o1.getLoiNhuan() != o2.getLoiNhuan()){
                return o2.getLoiNhuan() - o1.getLoiNhuan();
            }
            else{
                return o1.getIdHD().compareTo(o2.getIdHD());
            }
        });
        
        for (HoaDon i : listHD) {
            System.out.println(i);
        }
    }
}
