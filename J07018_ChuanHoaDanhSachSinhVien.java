/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.IDN;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */
class SinhVien{
    private String id, name, idL, ngaySinh;
    private double gpa;
    public static int cnt = 1;

    public SinhVien(String name, String idL, String ngaySinh, double gpa) {
        this.id = "B20DCCN" + String.format("%03d", cnt++);
        this.name = ChuanHoaTen(name);
        this.idL = idL;
        this.ngaySinh = ChuanHoaNS(ngaySinh);
        this.gpa = gpa;
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
    
    @Override
    public String toString(){
        return id +" " +name +" " + idL +" " + ngaySinh +" " + String.format("%.2f", gpa);
    }
}
public class J07018_ChuanHoaDanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException, ParseException{
        Scanner sc = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<SinhVien> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String idL = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            list.add(new SinhVien(name, idL, ngaySinh, gpa));
        }
        for(SinhVien i : list){
            System.out.println(i);
        }
    }
}
