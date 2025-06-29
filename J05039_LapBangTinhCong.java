import java.util.*;

class TienLuong2{

    private String id, name, chucvu;
    private int luong, nc;
    public static int cnt = 1;

    public TienLuong2(){

    }

    public void Input(Scanner sc){
        id = "NV" + String.format("%02d", cnt++);
        name = sc.nextLine();
        luong =  Integer.parseInt(sc.nextLine());
        nc  = Integer.parseInt(sc.nextLine());
        chucvu = sc.nextLine();
    }

    public int getLuong(){
        return (int) (luong * nc);
    }

    public int getThuong(){
        double t = 0;
        if(this.nc >= 25){
            t = getLuong() * 0.2;
        }
        else if(this.nc >= 22){
            t = getLuong() *  0.1;
        }
        else{
            t = 0;
        }
        return (int) t;
    }

    public int getPhucap(){
        int pc = 0;
        if(chucvu.equals("GD")){
            pc = 250000;
        }
        if(chucvu.equals("PGD")){
            pc = 200000;
        }
        if(chucvu.equals("TP")){
            pc = 180000;
        }
        if(chucvu.equals("NV")){
            pc = 150000;
        }
        return pc;
    }

    public int getThuclinh(){
        return getLuong() + getThuong() + getPhucap();
    }

    @Override
    public String toString(){
        return id + " " + name + " " + getLuong() +" " + getThuong() +" " + getPhucap() + " " + getThuclinh();
    }

}

public class J05039_LapBangTinhCong {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<TienLuong2> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            TienLuong2 t = new TienLuong2();
            t.Input(sc);
            a.add(t);
        }

        for(TienLuong2 i : a){
            System.out.println(i);  
        }
    }
}
