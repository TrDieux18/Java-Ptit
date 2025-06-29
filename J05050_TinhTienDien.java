import java.util.*;

class TienDien{
  
    private String id, SD;
    private int csc, csm;
    public static int cnt = 1;
    public TienDien(){

    }

    public void Input(Scanner sc){
        id = "KH" +  String.format("%02d", cnt++);
        SD = sc.nextLine().toUpperCase();
        csc = Integer.parseInt(sc.nextLine());
        csm = Integer.parseInt(sc.nextLine());
    }

    public int getHeSo(){
        int hs = 0;
        if(SD.equals("KD")){
            hs = 3;
        }
        if(SD.equals("NN")){
            hs = 5;
        }
        if(SD.equals("TT")){
            hs = 4;
        }
        if(SD.equals("CN")){
            hs = 2;
        }
        return hs;
    }

    public int getThanhTien(){
        return (csm - csc) * getHeSo() * 550;
    }

    public int getPhutroi(){
        int sub = csm - csc;
        double phutroi = 0;
        if(sub < 50){
            phutroi = 0;
        }
        else if(sub <= 100){
            phutroi = Math.ceil(getThanhTien() * 0.35);
        }
        else{
            phutroi = Math.ceil(getThanhTien() * 1.00);
        }
        return (int) phutroi;
    }

    public int getTong(){
        return getThanhTien() + getPhutroi();
    }

    @Override
    public String toString(){
        return id +  " " + getHeSo() + " " + getThanhTien() +" " + getPhutroi() + " " + getTong();
    }
};

public class J05050_TinhTienDien {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<TienDien> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            TienDien td = new TienDien();
            td.Input(sc);
            a.add(td);
        }

        for(TienDien i : a){
            System.out.println(i);
        }
    }
}
