import java.util.*;

class KyThi{

    private String msv, hoten, dob;
    private double mon1, mon2, mon3;

    public static int cnt = 1;
    public KyThi(){

    }

    
    public String getHoten() {
        return hoten;
    }

    
    public String getMsv() {
        return msv;
    }


    public void input(Scanner sc){
        msv = String.format("%01d", cnt++);
        hoten = sc.nextLine();
        dob = sc.nextLine();
        mon1 = Double.parseDouble(sc.nextLine());
        mon2 = Double.parseDouble(sc.nextLine());
        mon3 = Double.parseDouble(sc.nextLine());
    }

    public double getTongdiem(){
        return mon1 + mon2 + mon3;
    }

    @Override
    public String toString(){
        return msv + " " + hoten + " " + dob + " " + String.format("%.1f", getTongdiem());
    }
};

public class J05009_TimThuKhoaKiThi {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<KyThi> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            KyThi sv = new KyThi();
            sv.input(sc);
            list.add(sv);
        }

        list.sort((x,y) -> x.getTongdiem() != y.getTongdiem() ? Double.compare(y.getTongdiem(), x.getTongdiem()) : x.getMsv().compareTo(y.getMsv()));
        double maxdiem = list.get(0).getTongdiem();
        for(KyThi i : list){
            if(i.getTongdiem() == maxdiem){
                System.out.println(i);
            }
        }
    }
}
