/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */

class KhachHang{
    private String id, name, gioiTinh, ngaySinh, diaChi;
    public static int cnt= 1;
    public KhachHang( String name, String gioiTinh, String ngaySinh, String diaChi) {
        this.id = String.format("KH%03d", cnt++);
        this.name = ChuanHoaTen(name);
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ChuanHoaNS(ngaySinh);
        this.diaChi = diaChi;
    }

     public String ChuanHoaTen(String s){
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for(String word : words){
           res.append(word.substring(0,1).toUpperCase()).
                   append(word.substring(1).toLowerCase()).append(" ");
        }
        return res.toString().trim();
    }
    
    public String ChuanHoaNS(String s){
        StringBuilder res = new StringBuilder();
        res = res.append(s);
        if(res.charAt(2) != '/') res.insert(0,'0');
        if(res.charAt(5) != '/') res.insert(3, '0');
        return res.toString();
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    
    public int Dob(){
        String[] dobs = ngaySinh.split("/");
        return Integer.parseInt(dobs[2] + dobs[1] + dobs[0]);
    }
    
    @Override
    public String toString(){
        return id + " " + name +" " +gioiTinh + " "+diaChi +" " + ngaySinh;
    }
}
public class J07025_DanhSachKhachHangTrongFile {
    public static void main(String[] args) throws FileNotFoundException, ParseException{
        Scanner sc = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\KHACHHANG.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<KhachHang> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String ngaySinh = sc.nextLine();
            String diaChi = sc.nextLine();
            list.add(new KhachHang(name, gioiTinh, ngaySinh, diaChi));
        }
        
        list.sort((o1, o2) -> o1.Dob() - o2.Dob());
        for(KhachHang i : list){
            System.out.println(i);
        }
    }
}
