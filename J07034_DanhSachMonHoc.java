/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pc
 */

class MHoc{
    private  String id, name;
    private int stc;

    public MHoc(String id, String name, int stc) {
        this.id = id;
        this.name = name;
        this.stc = stc;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString(){
        return id + " " + name +" " + stc;
    }
}
public class J07034_DanhSachMonHoc {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\MONHOC.in"));
        int n = Integer.parseInt(sc.nextLine());
        List<MHoc> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            int stc = Integer.parseInt(sc.nextLine());
            list.add(new MHoc(id, name, stc));
        }
        
        list.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        
        for(MHoc i : list){
            System.out.println(i);
        }
        
        
    }
}
