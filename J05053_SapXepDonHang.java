import java.util.*;

class Donhang{

    private String name, id;
    private int donGia, soLuong;

    public Donhang(){

    }

    public void Input(Scanner sc){
        name = sc.nextLine();
        id = sc.nextLine();
        donGia = Integer.parseInt(sc.nextLine());
        soLuong = Integer.parseInt(sc.nextLine());
    }

    public int getTong(){
        return donGia * soLuong;
    }

    public int getGiam(){
        double giam = 0;
        if(id.endsWith("1")){
            giam = Math.ceil(getTong() * 0.5);
        }
        if(id.endsWith("2")){
            giam = Math.ceil(getTong() * 0.3);
        }
        return (int) giam;
    }

    public String getSTT(){
        return id.substring(1,4);
    }

    public int getThanhTien(){
        return getTong() - getGiam();
    }

    @Override
    public String toString(){
        return name + " " + id + " " + getSTT() +" " + getGiam() + " " + getThanhTien();
    }
};

public class J05053_SapXepDonHang {
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Donhang> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            Donhang dh = new Donhang();
            dh.Input(sc);
            a.add(dh);
        }

        Collections.sort(a, new Comparator<Donhang>(){
            public int compare(Donhang x, Donhang y){
                return x.getSTT().compareTo(y.getSTT());
            }
        });
        
        for(Donhang i : a){
            System.out.println(i);
        }
    }
}
