import java.util.*;


class BDTS{
    private String id, name;
    private double toan, ly, hoa;


    public BDTS(){

    }

    public void Input(Scanner sc){
        id =  sc.nextLine();
        name = sc.nextLine();
        toan = Double.parseDouble(sc.nextLine());
        ly = Double.parseDouble(sc.nextLine());
        hoa = Double.parseDouble(sc.nextLine());
    }

    public double getDiemCong(){
        String s = id.substring(0,3);
        double diem = 0;
        if(s.equals("KV1")){
            diem = 0.5;
        }
        if(s.equals("KV2")){
            diem = 1.0;
        }
        if(s.equals("KV3")){
            diem = 2.5;
        }
        return diem;
    }

    public double getTong(){
        return toan*2 + ly + hoa;
    }

    public String getXetTuyen(){
        if(getTong()+getDiemCong() >= 24){
            return "TRUNG TUYEN";
        }
        else{
            return "TRUOT";
        }
    }

    public String formatDiem(double c){
        double d = c * 10;
        if( d % 10 == 0){
            return String.format("%.0f", d /10);
        }
        else{
            return String.format("%.1f", d/10);
        }
    }

    @Override
    public String toString(){
        return id + " " + name + " " + formatDiem(getDiemCong()) +  " " + formatDiem(getTong()) + " "  + getXetTuyen();
    }

}

public class J05057_BangDiemTuyenSinh {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        BDTS[] a = new BDTS[n];
        for(int i = 0; i < n; i++){
            a[i] = new BDTS();
            a[i].Input(sc);
        }

        for(BDTS i : a){
            System.out.println(i);
        }
    }
}
