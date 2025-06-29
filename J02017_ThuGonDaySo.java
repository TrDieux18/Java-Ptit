import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class J02017_ThuGonDaySo {
    public static Scanner sc  = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        List<Integer> b = new ArrayList<>();
        for(int i = 0; i < n; i++){
            b.add(sc.nextInt());
        }
        while(true){
            boolean pos  = true;
            for(int i = 0; i < b.size()-1; i++){
                if((b.get(i) + b.get(i+1)) % 2 == 0){
                    b.remove(i+1);
                    b.remove(i);
                    i--;
                    pos = false;
                }
            }
            if(pos){
                System.out.println(b.size());
                return;
            }
        }
    }
}