import java.util.Scanner;
import java.util.ArrayList;
public class J02105_DanhSachKe {
    public static Scanner sc = new Scanner(System.in);
    @SuppressWarnings("unchecked")
    public static ArrayList<Integer>[] a = new ArrayList[1001];
    public static void main(String[] args) {
        int n = sc.nextInt();
       
        for(int i = 0; i <= n; i++){
            a[i] = new ArrayList<>();
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int x = sc.nextInt();
                if(x == 1){
                    a[i].add(j);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            System.out.printf("List(%d) = ", i);
            for(int j : a[i]){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}