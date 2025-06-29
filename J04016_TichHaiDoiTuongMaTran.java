import java.util.Scanner;

class Matrix {

    private int[][] a;

    public Matrix(int hang, int cot) {
        a = new int[hang][cot];
    }

    public Matrix(int[][] a) {
        this.a = a;
    }

    public int getHang() {
        return a.length;
    }

    public int getCot() {
        return a[0].length;
    }

    public void nextMatrix(Scanner sc) {
        for (int i = 0; i < getHang(); i++) {
            for (int j = 0; j < getCot(); j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    public int[][] getMaTrix() {
        return a;
    }


    public Matrix mul(Matrix b){
        int[][] ans =  new int[getHang()][b.getCot()];
        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                ans[i][j] = 0;
            }
        }

        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[0].length; j++){
                for(int k = 0; k < getCot(); k++){
                    ans[i][j] +=  a[i][k] * b.getMaTrix()[k][j];
                }
            }
        }
        return new Matrix(ans);
    }
    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < getHang(); i++) {
            for (int j = 0; j < getCot(); j++) {
                res += a[i][j] + " ";
            }
            res += "\n";
        }
        return res;
    }
};

public class J04016_TichHaiDoiTuongMaTran {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        Matrix a = new Matrix(n, m);
        a.nextMatrix(sc);
        Matrix b = new Matrix(m, p);
        b.nextMatrix(sc);
        System.out.println(a.mul(b));
        sc.close();
    }
}