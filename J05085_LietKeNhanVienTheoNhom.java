/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */
class NVTN {

    private String id, name, maChucVu, soHieu, bacLuong;

    public NVTN(String id, String name) {
        if (id.substring(0, 2).equalsIgnoreCase("GD")) {
            id = id.substring(0, 2).replace("GD", "NV");
        }
        this.id = id;
        this.name = name;
        this.maChucVu = id.substring(0, 2).toUpperCase();
        this.soHieu = id.substring(id.length() - 3);
        this.bacLuong = id.substring(2, 4);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public String getSoHieu() {
        return soHieu;
    }

    public String getBacLuong() {
        return bacLuong;
    }

    @Override
    public String toString() {
        return name + " " + maChucVu + " " + soHieu + " " + bacLuong;
    }
};

public class J05085_LietKeNhanVienTheoNhom {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<NVTN> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String id = parts[0];
            String name = parts[1];
            NVTN nv = new NVTN(id, name);
            a.add(nv);
        }
        
        for(NVTN i : a){
            System.out.println(i);
        }
    }
}
