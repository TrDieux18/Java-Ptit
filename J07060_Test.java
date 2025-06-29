/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.attribute.PosixFilePermission;
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
class MHoc {

    private String idMonHoc, nameMonHoc, hinhThucThi;

   

    public MHoc(String idMonHoc, String nameMonHoc, String hinhThucThi) {
        this.idMonHoc = idMonHoc;
        this.nameMonHoc = nameMonHoc;
        this.hinhThucThi = hinhThucThi;
    }

    public String getIdMonHoc() {
        return idMonHoc;
    }

    public void setIdMonHoc(String idMonHoc) {
        this.idMonHoc = idMonHoc;
    }

    public String getNameMonHoc() {
        return nameMonHoc;
    }

    public void setNameMonHoc(String nameMonHoc) {
        this.nameMonHoc = nameMonHoc;
    }

    public String getHinhThucThi() {
        return hinhThucThi;
    }

    public void setHinhThucThi(String hinhThucThi) {
        this.hinhThucThi = hinhThucThi;
    }

}

class CThi {

    private String idCaThi, ngayThi, gioThi;
    private String phongThi;
    public static int sMa = 1;

    public CThi() {
    }

    public CThi(String ngayThi, String gioThi, String phongThi) throws ParseException {
        this.idCaThi = String.format("C%03d", sMa++);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.ngayThi = df.format(df.parse(ngayThi));
        DateFormat tf = new SimpleDateFormat("HH:mm");
        this.gioThi = tf.format(tf.parse(gioThi));
        this.phongThi = phongThi;
    }

    public String getIdCaThi() {
        return idCaThi;
    }

    public void setIdCaThi(String idCaThi) {
        this.idCaThi = idCaThi;
    }

    public String getNgayThi() {
        return ngayThi;
    }

    public void setNgayThi(String ngayThi) {
        this.ngayThi = ngayThi;
    }

    public String getGioThi() {
        return gioThi;
    }

    public void setGioThi(String gioThi) {
        this.gioThi = gioThi;
    }

    public String getPhongThi() {
        return phongThi;
    }

    public void setPhongThi(String phongThi) {
        this.phongThi = phongThi;
    }

}

class LThi {

    private MHoc mhoc;
    private CThi Cthi;
    private String nhom;
    private int soSinhVien;

    public LThi(MHoc mhoc, CThi Cthi, String nhom, int soSinhVien) {
        this.mhoc = mhoc;
        this.Cthi = Cthi;
        this.nhom = nhom;
        this.soSinhVien = soSinhVien;
    }
    
    public String getNgayThi(){
        String[] date = Cthi.getNgayThi().split("/");
        return date[2] + date[1] + date[0];
        
    }
    
    public String getGiothi(){
        return Cthi.getGioThi();
    }
    
    public String getIdCaThi(){
        return Cthi.getIdCaThi();
    }
   

    @Override
    public String toString() {
        return Cthi.getNgayThi() + " " + Cthi.getGioThi() + " " + Cthi.getPhongThi()
                + " " + mhoc.getNameMonHoc() + " " + nhom + " " + soSinhVien;
    }

}

public class J07060_Test {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        Scanner scMT = new Scanner(new File("MONTHI.in"));
        Scanner scCT = new Scanner(new File("CATHI.in"));
        Scanner scLT = new Scanner(new File("LICHTHI.in"));
        int n = Integer.parseInt(scMT.nextLine());
         Map<String, MHoc> danhsachMonThi = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String idMon = scMT.nextLine();
            String tenMon = scMT.nextLine();
            String hinhThucThi = scMT.nextLine();
            danhsachMonThi.put(idMon, new MHoc(idMon, tenMon, hinhThucThi));
        }

        int m = Integer.parseInt(scCT.nextLine());
        List<CThi> danhsachCaThi = new ArrayList<>();
        Map<String, CThi> mpCaThi = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String ngayThi = scCT.nextLine();
            String gioThi = scCT.nextLine();
            String phongThi = scCT.nextLine();
            danhsachCaThi.add(new CThi(ngayThi, gioThi, phongThi));
            mpCaThi.put(danhsachCaThi.get(i).getIdCaThi(), danhsachCaThi.get(i));
        }

        int k = Integer.parseInt(scLT.nextLine());
        List<LThi> danhsachLichThi = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] data = scLT.nextLine().split(" ");
            String idCaThi = data[0];
            String idMonHoc = data[1];
            String nhom = data[2];
            int soSinhVien = Integer.parseInt(data[3]);

            danhsachLichThi.add(new LThi(danhsachMonThi.get(idMonHoc), mpCaThi.get(idCaThi), nhom, soSinhVien));

        }
        
        danhsachLichThi.sort((o1, o2) -> {
          if(!o1.getNgayThi().equals( o2.getNgayThi())){  
              return o1.getNgayThi().compareTo(o2.getNgayThi());
          }
          if(!o1.getGiothi().equals(o2.getGiothi())){
              return o1.getGiothi().compareTo(o2.getGiothi());
          }
           return 0;
            
        });
        
        for(LThi i : danhsachLichThi){
            System.out.println(i);
        }
    }
}
