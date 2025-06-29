import java.util.*;

class TuyenGV {

    private String mgv, hoten, mst;
    private double dth, dcm;
    public static int cnt = 1;

    public void Input(Scanner sc) {
        mgv = "GV" + String.format("%02d", cnt++);
        hoten = sc.nextLine();
        mst = sc.nextLine();
        dth = Double.parseDouble(sc.nextLine());
        dcm = Double.parseDouble(sc.nextLine());
    }

    

    public String getMgv() {
        return mgv;
    }



    public String getMon() {
        String s = "";
        if (mst.substring(0, 1).equals("A")) {
            s += "TOAN";
        }
        if (mst.substring(0, 1).equals("B")) {
            s += "LY";
        }
        if (mst.substring(0, 1).equals("C")) {
            s += "HOA";
        }
        return s;

    }

    public double getDiemUT() {
        double d = 0;
        if (this.mst.substring(1).equals("1")) {
            d = 2.0;
        }
        if (this.mst.substring(1).equals("2")) {
            d = 1.5;
        }
        if (this.mst.substring(1).equals("3")) {
            d = 1.0;
        }
        if (this.mst.substring(1).equals("4")) {
            d = 0.0;
        }
        return d;
    }

    public double getTongdiem() {
        return this.dth * 2 + this.dcm + getDiemUT();
    }

    public String getXT() {
        if (getTongdiem() >= 18) {
            return "TRUNG TUYEN";
        } else {
            return "LOAI";
        }
    }

    @Override
    public String toString(){
        return mgv +" " + hoten + " " +getMon() + " " +  String.format("%.1f", getTongdiem()) + " " + getXT();
    }

};

public class J05014_TuyenGiaoVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<TuyenGV> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            TuyenGV gv =  new TuyenGV();
            gv.Input(sc);
            a.add(gv);
        }

        a.sort( new Comparator<TuyenGV>() {
            public int compare(TuyenGV x, TuyenGV y) {
                int ans = Double.compare(y.getTongdiem(), x.getTongdiem()); 
                if (ans != 0) {
                    return ans;
                }
                return x.getMgv().compareTo(y.getMgv());
            }
        });

        for(TuyenGV i : a){
            System.out.println(i);
        }

    }
}
