// Code
import java.util.Scanner;
// import java.util.Arrays;

class Dso {
    private int[] a;
    
    public Dso(int n){
        a = new int[n];
    }

    public Dso(int a[]){
        this.a = a;
    }

    public int[] getA() {
        return a;
    }

    public void setA(int[] a) {
        this.a = a;
    }

    public void input(Scanner sc){
        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
    }

    public void output(){
        for(int i = 0; i  < a.length; i++){
            System.out.print(a[i] +" ");
        }
    }

    private boolean isPrime(int n){
        if( n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if( n % i ==0){
                return false;
            }
        }
        return true;
    }

    public Dso NguyenTo(){
        Dso t ;
        int dem = 0;
        for(int i = 0; i < a.length; i++){
            if(isPrime(a[i])){
                dem++;
            }
        }
        t = new Dso(dem);
        int k = 0;
        for(int i = 0; i < a.length; i++){
            if(isPrime(a[i])){
                t.a[k++] = a[i];
            }
        }
        return t;
    }

    public Dso Sapxep(){
        for(int i = 0; i < a.length - 1; i++){
            for(int j = i + 1; j < a.length; j++){
                if(a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        Dso t = new Dso(a.length);
        for(int i : a){
            t.a[i] = a[i];
        }
        return t;
    }

    public int tongChan(){
        int cnt = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i]  % 2 == 0){
                cnt += a[i];
            }
        }
        return cnt;
    }
};

public class DaySo {

    public static  Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        Dso a = new Dso(n);
        a.input(sc);
        Dso t = a.NguyenTo();
        t.output();
        System.out.println(a.tongChan());
        System.out.println();
        Dso l = a.Sapxep();
        l.output();   
    }
}