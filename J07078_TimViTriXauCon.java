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
public class J07078_TimViTriXauCon {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\STRING.in"));
        int n = Integer.parseInt(sc.nextLine());
        while (n-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            List<Integer> pos = new ArrayList<>();
            int index = s1.indexOf(s2);
            while(index != -1){
                pos.add(index+1);
                index = s1.indexOf(s2, index+1);
            }

            if(!pos.isEmpty()){
                for(int i : pos){
                    System.out.print(i +" ");
                }
            }
            System.out.println();
        }
    }
}
