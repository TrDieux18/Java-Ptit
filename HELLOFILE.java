// package CodeJ;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
public class HELLOFILE {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("Hello.txt"));
        while(sc.hasNext()){
            System.out.println(sc.nextLine());
        }
        sc.close();
        
    }
}
