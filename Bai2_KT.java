import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai2_KT {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("numbers.dat"));
        double sum = 0;
        while (sc.hasNext()) {
            if (sc.hasNextDouble()) {
                double so = sc.nextDouble();
                System.out.println("number = " + so);
                sum += so;
            }
            else{
                sc.next();
            }
        }
        System.out.println("Sum = " + sum);
        sc.close();
    }
}
