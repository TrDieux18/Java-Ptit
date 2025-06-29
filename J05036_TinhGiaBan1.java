import java.util.*;

class GiaBan{

    private String id, name, dvt;
    private int dgn, sl;
    public static int cnt = 1;

    public GiaBan(){

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

    public int getGiaban(){
        return (int) Math.round(getThanhtien() *1.02);
    }

    @Override
    public String toString(){
        return id + " " + name + " " + dvt+ " " + getPhivanchuyen() + " " + getThanhtien() + " " + getGiaban();
    }
};


public class J05036_TinhGiaBan1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiaBan> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            GiaBan gb = new GiaBan();
            gb.Intput(sc);
            a.add(gb);
        }

        for(GiaBan i : a){
            System.out.println(i);
        }
    }
}
