import java.util.*;

class Tiendien{
  
    private String id, SD;
    private int csc, csm;
    public static int cnt = 1;
    public Tiendien(){

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

public class J05051_SapXepBangTinhTienDien {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Tiendien> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            Tiendien td = new Tiendien();
            td.Input(sc);
            a.add(td);
        }

        Collections.sort(a, new Comparator<Tiendien>() {
           public int compare(Tiendien x, Tiendien y){
                return y.getTong() - x.getTong();
           } 
        });
        
        for(Tiendien i : a){
            System.out.println(i);
        }
    }
}
