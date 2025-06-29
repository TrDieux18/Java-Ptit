/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.FileInputStream;
import java.io.IOException;
//import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pc
 */
public class J07030_CapSoNguyenToTrongFile1 {

    public static boolean Prime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
            List<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
            ois1.close();
            Set<Integer> ts1 = new TreeSet<>();
            for (int i : list1) {
                if (Prime(i)) {
                    ts1.add(i);
                }
            }

            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
            List<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
            ois2.close();

            final int SUM = 1000000;
            for (Integer i : ts1) {
                Integer j = SUM - i;
                if (i >= j) {
                    break;
                }
                if (ts1.contains(j) && !list2.contains(i) && !list2.contains(j)) {
                    System.out.println(i + " " + (SUM - i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
