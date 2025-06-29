import java.util.*;


class BDTS2{
    private String id, name;
    private double toan, ly, hoa;


    public BDTS2(){

    }

    public void Input(Scanner sc){
        id =  sc.nextLine();
        name = sc.nextLine();
        toan = Double.parseDouble(sc.nextLine());
        ly = Double.parseDouble(sc.nextLine());
        hoa = Double.parseDouble(sc.nextLine());
    }

    

    public String getId() {
        return id;
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
        return toan*2 + ly + hoa +  getDiemCong();
    }

    public String getXetTuyen(){
        if(getTong() >= 24){
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

public class J05058_SapXepKetQuaTuyenSinh {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<BDTS2> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            BDTS2 ts = new BDTS2();
            ts.Input(sc);
            a.add(ts);
        }

        a.sort((x,y) -> x.getTong() != y.getTong() ? Double.compare(y.getTong(), x.getTong()) : x.getId().compareTo(y.getId()));
        for(BDTS2 i : a){
            System.out.println(i);
        }
    }
}
