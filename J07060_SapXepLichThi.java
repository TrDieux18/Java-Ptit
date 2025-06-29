/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author pc
 */
class MonThi {

    private String idMon, tenMon, hinhThucThi;

    public MonThi(String idMon, String tenMon, String hinhThucThi) {
        this.idMon = idMon;
        this.tenMon = tenMon;
        this.hinhThucThi = hinhThucThi;
    }

    public String getHinhThucThi() {
        return hinhThucThi;
    }

    public String getIdMon() {
        return idMon;
    }

    public String getTenMon() {
        return tenMon;
    }

}

class CaThi {

    private String idCaThi;
    private String ngayThi;
    private String gioThi;
    private String phongThi;
    public static int cnt = 1;

    public CaThi(String ngayThi, String gioThi, String phongThi) throws ParseException {
        this.idCaThi = String.format("C%03d", cnt++);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.ngayThi = df.format(df.parse(ngayThi));
        DateFormat tf = new SimpleDateFormat("HH:mm");
        this.gioThi = tf.format(tf.parse(gioThi));
        this.phongThi = phongThi;
    }

    public String getIdCaThi() {
        return idCaThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

}

class LichThi {

    private MonThi monthi;
    private CaThi cathi;
    private String soNhom;
    private int soSinhVien;

    public LichThi(MonThi monthi, CaThi cathi, String soPhong, int soSinhVien) {
        this.monthi = monthi;
        this.cathi = cathi;
        this.soNhom = soPhong;
        this.soSinhVien = soSinhVien;
    }

    public CaThi getCathi() {
        return cathi;
    }

    public MonThi getMonthi() {
        return monthi;
    }

    public String getNgayThi(){
        String[] ngay = cathi.getNgayThi().split("/");
        return ngay[2] + ngay[1] + ngay[0];
    }
    
    public String getGioThi() {
        return cathi.getGioThi();
    }

    public String getIdCaThi() {
        return cathi.getIdCaThi();
    }

    @Override
    public String toString() {
        return cathi.getNgayThi() + " " + cathi.getGioThi() + " " + cathi.getPhongThi()
                + " " + monthi.getTenMon() + " " + soNhom + " " + soSinhVien;
    }
}

public class J07060_SapXepLichThi {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner scMT = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\MONTHI.in"));
        int n = Integer.parseInt(scMT.nextLine());
        Map<String, MonThi> danhsachMonThi = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String idMon = scMT.nextLine();
            String tenMon = scMT.nextLine();
            String hinhThucThi = scMT.nextLine();
            danhsachMonThi.put(idMon, new MonThi(idMon, tenMon, hinhThucThi));
        }

        Scanner scCT = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\CATHI.in"));
        List<CaThi> listCaThi = new ArrayList<>();
        int m = Integer.parseInt(scCT.nextLine());
        for (int i = 0; i < m; i++) {
            String ngayThi = scCT.nextLine();
            String gioThi = scCT.nextLine();
            String phongThi = scCT.nextLine();
            listCaThi.add(new CaThi(ngayThi, gioThi, phongThi));
        }

        Scanner scLT = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\LICHTHI.in"));
        int k = Integer.parseInt(scLT.nextLine());
        List<LichThi> listLichThi = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] data = scLT.nextLine().split(" ");
            String idCaThi = data[0];
            String idMon = data[1];
            String soNhom = data[2];
            int soSinhVien = Integer.parseInt(data[3]);

            CaThi cathi = null;
            for (CaThi j : listCaThi) {
                if (j.getIdCaThi().equals(idCaThi)) {
                    cathi = j;
                    break;
                }
            }

            listLichThi.add(new LichThi(danhsachMonThi.get(idMon), cathi, soNhom, soSinhVien));

        }

        listLichThi.sort((o1, o2) -> {
             if (!o1.getNgayThi().equals(o2.getNgayThi())) {
                return o1.getNgayThi().compareTo(o2.getNgayThi());
            } else if (!o1.getGioThi().equals(o2.getGioThi())) {
                return o1.getGioThi().compareTo(o2.getGioThi());
            } else {
                return o1.getIdCaThi().compareTo(o2.getIdCaThi());
            }

        });
        for (LichThi i : listLichThi) {
            System.out.println(i);
        }
    }
}
