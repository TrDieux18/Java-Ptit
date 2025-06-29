

import java.io.*;
import java.util.*;

public class J07006_SoKhacNhauTrongFile3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream op = new ObjectInputStream(new FileInputStream("DATA.in"));
        List<Integer> al = (ArrayList<Integer>) op.readObject();
        int[] cnt = new int[1000];
        for (Integer i : al) {
            cnt[i]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (cnt[i] > 0) {
                System.out.println(i + " " + cnt[i]);
            }
        }
        op.close();
    }
}
