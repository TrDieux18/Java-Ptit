import java.util.*;

class GiaBan2 {

    private String id, name, dvt;
    private int dgn, sl;
    public static int cnt = 1;

    public GiaBan2 (){

    }

    public void Intput(Scanner sc){
        id = "MH" + String.format("%02d", cnt++);
        name = sc.nextLine();
        dvt = sc.nextLine();
        dgn = Integer.parseInt(sc.nextLine());
        sl = Integer.parseInt(sc.nextLine());        
    }

    public int getPhivanchuyen(){
        return (int) Math.round((dgn*sl)*0.05);
    }

    public int getThanhtien(){
        return (int) Math.round((dgn*sl) + getPhivanchuyen());
    }

    public int getGiaBanLe (){
        double gia = getThanhtien();
        double giaBan = (gia + gia*0.02)/sl;
        return (int) Math.ceil(giaBan / 100.0) *100;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + dvt+ " " + getPhivanchuyen() + " " + getThanhtien() + " " + getGiaBanLe ();
    }
};


public class J05037_TinhGiaBan2  {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiaBan2 > a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            GiaBan2  gb = new GiaBan2 ();
            gb.Intput(sc);
            a.add(gb);
        }

        Collections.sort(a, new Comparator<GiaBan2>() {
            public int compare(GiaBan2 x, GiaBan2 y){
                return y.getGiaBanLe() - x.getGiaBanLe();
            }
        });
        for(GiaBan2  i : a){
            System.out.println(i);
        }
    }
}
