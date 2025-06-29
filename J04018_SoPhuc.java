import java.util.Scanner;

class SoPhuc {

    private int thuc, ao;

    public SoPhuc(int thuc, int ao) {
        this.thuc = thuc;
        this.ao = ao;
    }

    public SoPhuc TongSP(SoPhuc B) {
        return new SoPhuc(this.thuc + B.thuc, this.ao + B.ao);
    }

    public SoPhuc TichSP(SoPhuc B) {
        int thucM = this.thuc * B.thuc - this.ao * B.ao;
        int aoM = this.thuc * B.ao + this.ao * B.thuc;
        return new SoPhuc(thucM, aoM);
    }

    public SoPhuc BinhPhuong() {
        int thucM = this.thuc * this.thuc - this.ao * this.ao;
        int aoM = 2 * this.thuc * this.ao;
        return new SoPhuc(thucM, aoM);
    }

    public String toString() {
        if (ao >= 0) {
            return thuc + " + " + ao + "i";
        } else {
            return thuc + " - " + Math.abs(ao) + "i";
        }
    }

};

public class J04018_SoPhuc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            SoPhuc A = new SoPhuc(a, b);
            SoPhuc B = new SoPhuc(c, d);

            SoPhuc tong = A.TongSP(B);

            SoPhuc C = tong.TichSP(A);

            SoPhuc D = tong.BinhPhuong();

            System.out.println(C + ", " + D);

        }
        sc.close();
    }
}
