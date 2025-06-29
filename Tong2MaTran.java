import java.util.Scanner;

class MaTran{

    private int[][] a;

    public MaTran(int n){
        a = new int[n][n];
    }

    public MaTran(int[][] a){
        this.a = a;
    }

    public int[][] getMaTran(){
        return a;
    }

    public int getKT(){
        return a.length;
    }

    public void input(Scanner sc){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                a[i][j] = sc.nextInt();
            }
        }
    }

    public void out(){
        for(int i = 0; i < this.a.length; i++){
            for(int j = 0; j < this.a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public MaTran tong(int[][] b){
       int[][] sum = new int[this.a.length][this.a.length];
       for(int i = 0; i < this.a.length; i++){
            for(int j = 0; j < this.a.length; j++){
                sum[i][j] = this.a[i][j] + b[i][j];
            }
       }
       return new MaTran(sum);
    }
};

public class Tong2MaTran {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        MaTran a = new MaTran(n);
        a.input(sc);
        MaTran b = new MaTran(a.getKT());
        b.input(sc);
        MaTran t = a.tong(b.getMaTran());
        t.out();
    }
}