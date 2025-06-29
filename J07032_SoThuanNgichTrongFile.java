/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
//import java.util.Map;

/**
 *
 * @author pc
 */
public class J07032_SoThuanNgichTrongFile {

    public static boolean isValid(String s) {
        StringBuilder res = new StringBuilder();
        res = res.append(s).reverse();
        if (!res.toString().equals(s)) {
            return false;
        }
        if (s.length() % 2 == 0 || s.length() == 1) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\DATA1.in"));
        List<Integer> list1 = (ArrayList<Integer>) ois1.readObject();
        ois1.close();
        
        ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\DATA2.in"));
        List<Integer> list2 = (ArrayList<Integer>) ois2.readObject();
        ois2.close();
        
        int[] cnt = new int[1000001];
       
        for(var x : list1){
            if(isValid(x.toString()) && list2.contains(x)){
                cnt[x]++;
            }
        }
        
        for(var x : list2){
            if(isValid(x.toString()) && cnt[x] !=0){
                cnt[x]++;
            }   
        }
        
        int dem = 0;
        for(int i = 0; i <= 1000000; i++){
            if(cnt[i] > 0){
                System.out.println(i + " "+cnt[i]);
                dem++;
            }
            if(dem == 10){
                break;
            }
        }
    }
}
