/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author pc
 */
public class J07029_SoNguyenToLonNhatTrongFile {

    public static final int N = (int) 1e6;
    public static int[] prime = new int[N + 1];

    public static void Sang() {
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;

        for (int i = 2; i <= (int) 1e3; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= N; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, StreamCorruptedException, IOException {
        Sang();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\DATA.in"));
        List<Integer> list = (ArrayList<Integer>) ois.readObject();
        int[] dd = new int[N + 1];
        for (Integer i : list) {
            dd[i] += prime[i];
        }

        int cnt = 0;
        for (int i = N; i >= 2; i--) {
            if (dd[i] > 0) {
                System.out.println(i + " " + dd[i]);
                cnt++;
                if (cnt == 10) {
                    break;
                }
            }
        }
    }
}
