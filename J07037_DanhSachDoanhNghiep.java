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
class DSDN {

    private String id, name;
    private int soSinhVien;

    public DSDN(String id, String name, int soSinhVien) {
        this.id = id;
        this.name = name;
        this.soSinhVien = soSinhVien;
    }

    public DSDN() {
    }

    public void nhap(Scanner sc) throws FileNotFoundException, NumberFormatException {
        id = sc.nextLine();
        name = sc.nextLine();
        soSinhVien = Integer.parseInt(sc.nextLine());
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + soSinhVien;
    }

}

public class J07037_DanhSachDoanhNghiep {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\DN.in"));
        List<DSDN> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
       
        for (int i = 0; i < n; i++) {
            DSDN x = new DSDN();
            x.nhap(sc);
            list.add(x);
        }

        list.sort(((o1, o2) -> o1.getId().compareTo(o2.getId())));

        for (DSDN i : list) {
            System.out.println(i);
        }
    }
}
