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
import java.util.regex.Pattern;

/**
 *
 * @author pc
 */
class TrungTuyen {

    private String id, name;
    private double d1, d2, d3;

    public TrungTuyen(String id, String name, double d1, double d2, double d3) {
        this.id = id;
        this.name = ChuanHoaTen(name);
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }
    
    public String ChuanHoaTen(String s){
        String[] words = s.trim().split("\\s+");
        StringBuilder res  = new StringBuilder();
        for(String word : words){
            res.append(word.substring(0,1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
            
        }
        return res.toString().trim();
    }

    public double getDiemUuTien() {
        String s = id.substring(0, 3);
        double diem = 0;
        if (s.equalsIgnoreCase("KV1")) {
            diem = 0.5;
        }
        if (s.equalsIgnoreCase("KV2")) {
            diem = 1.0;
        }
        if (s.equalsIgnoreCase("KV3")) {
            diem = 2.5;
        }
        return diem;
    }

    public double getTongDiem() {
        return d1 * 2 + d2 + d3 + getDiemUuTien();
    }

    public String formatDiem(double d) {
        double chuanhoa = d * 10;
        if (chuanhoa % 10 == 0) {
            return String.format("%.0f", d);
        } else {
            return String.format("%.1f", d);
        }
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + formatDiem(getDiemUuTien()) + " " + formatDiem(getTongDiem());
    }
}

public class J07052_DanhSachTrungTuyen {
    public static void main(String[] args) throws FileNotFoundException,ParseException {
        Scanner sc= new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\THISINH.in"));
        int n =  Integer.parseInt(sc.nextLine());
        List<TrungTuyen> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            double d1 = Double.parseDouble(sc.nextLine());
            double d2 = Double.parseDouble(sc.nextLine());
            double d3 = Double.parseDouble(sc.nextLine());
            list.add(new TrungTuyen(id, name, d1, d2, d3));
        }

        list.sort((x, y) -> x.getTongDiem() != y.getTongDiem() ? Double.compare(y.getTongDiem(), x.getTongDiem()) : x.getId().compareTo(y.getId()));
        int q = Integer.parseInt(sc.nextLine());
        double diem = list.get(q - 1).getTongDiem();
        System.out.println(diem);
        for(TrungTuyen i : list){
            System.out.print(i);
            System.out.println(i.getTongDiem() >= diem ? " TRUNG TUYEN" : " TRUOT" );
        }
        sc.close();
    }
}
