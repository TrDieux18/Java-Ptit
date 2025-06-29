import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
// import java.lang.ArrayIndexOutOfBoundsException;

public class J07005_SoKhacNhauTrongFile2 {

    public static void main(String[] args) throws IOException {
        int[] cnt = new int[1001];

        try (DataInputStream dis = new DataInputStream(new FileInputStream("DATA.IN"))) {
            while (dis.available() > 0) {
                int n = dis.readInt(); 
                cnt[n]++;
            }
        }

        for (int i = 0; i < 1001; i++) {
            if (cnt[i] > 0) {
                System.out.println(i + " " + cnt[i]);
            }
        }
    }
}
