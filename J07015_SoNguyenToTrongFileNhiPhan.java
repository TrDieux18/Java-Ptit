import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;

public class J07015_SoNguyenToTrongFileNhiPhan {

    public static final int MAX = 10000;
    public static int[] prime = new int[MAX];

    // Sieve of Eratosthenes to mark prime numbers
    public static void sieveOfEratosthenes() {
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;
        for (int i = 2; i * i < MAX; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j < MAX; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        sieveOfEratosthenes();

        // Use try-with-resources to ensure automatic resource management
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SONGUYEN.in"))) {
            List<Integer> list = (List<Integer>) ois.readObject();
            int[] count = new int[MAX];

            // Count occurrences of prime numbers
            for (Integer number : list) {
                if (number < MAX && prime[number] == 1) {
                    count[number]++;
                }
            }

            // Print the prime numbers and their counts
            for (int i = 2; i < MAX; i++) {
                if (count[i] > 0) {
                    System.out.println(i + " " + count[i]);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
