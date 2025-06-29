import java.util.*;

class TuyenXeBuyt{
    private String ma, hoten;
    private int soHieu, soLuot;
    public static int sMa = 1;

    public TuyenXeBuyt(String hoten, int soHieu, int soLuot) {
        
        this.hoten = hoten;
        this.soHieu = soHieu;
        this.ma =  "HN" + String.valueOf(soHieu) +  String.format("%02d", sMa++);
        this.soLuot = soLuot;
    }

    public int getDoanhThu(){
        return soLuot * 300000;
    }

    @Override 
    public String toString(){
        return ma + " " +  hoten + " " + soHieu + " " + soLuot + " " + getDoanhThu();
    }
    
}
public class Bai1_KTra2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<TuyenXeBuyt> a=new ArrayList<>();
        int n=Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            a.add(new TuyenXeBuyt(in.nextLine(),
                    Integer.parseInt(in.nextLine()),
                    Integer.parseInt(in.nextLine())));
        }
        a.forEach(gv->System.out.println(gv));
    }
}
