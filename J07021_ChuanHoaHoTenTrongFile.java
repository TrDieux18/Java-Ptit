import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class J07021_ChuanHoaHoTenTrongFile  {

    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("DATA.in"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("END")){
                break;
            }
            String[] words = line.trim().split("\\s+");
            for(int i = 0; i < words.length; i++){
                words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
                System.out.print(words[i]);
                if(i != words.length-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
