import java.util.Scanner;
import java.util.TreeSet;

public class J03009_TapTuRiengCuaHaiXau{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){
            String s1 = sc.nextLine().trim();
            String s2 = sc.nextLine().trim();
            TreeSet<String> tse =  new TreeSet<>();
            String[] str = s1.split("\\s+");
            for(int i = 0; i < str.length; i++){
                if(!s2.contains(str[i])){
                    tse.add(str[i]);
                }
            }
            for(String i : tse){
                System.out.print(i);
                if(i != tse.last()){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
