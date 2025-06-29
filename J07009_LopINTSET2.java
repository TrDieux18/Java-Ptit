import java.util.*;
import java.io.File;
import java.io.IOException;

class IntSet{

    private Set<Integer> set;

    public IntSet(){
        set = new TreeSet<>();
    }

    public IntSet(int[] arr){
        set = new TreeSet<>();
        for(int i : arr){
            set.add(i);
        }
    }

    public IntSet intersection(IntSet other){
        IntSet ans = new IntSet();
        for(int i : this.set){
            for(int j : other.set){
                if(i == j){
                    ans.set.add(i);
                }
            }
        }
        return ans;
    }

    @Override 
    public String toString(){
        StringBuilder res = new StringBuilder();
        for(int i : this.set){
            res.append(i).append(" ");
        }
        return res.toString().trim();
    }
}

public class J07009_LopINTSET2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
        sc.close();
    }
}
