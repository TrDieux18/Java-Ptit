import java.util.*;


class XuatHang{

    private String id;
    private int  slNhap;

    public XuatHang(){

    }

    public void Input(Scanner sc){
        id = sc.nextLine();
        slNhap = Integer.parseInt(sc.nextLine());
    }

    public int getslXuathang(){
        double xuat = 0;
        if(id.startsWith("A")){
            xuat = Math.round(slNhap * 0.6);
        }
        if(id.startsWith("B")){
            xuat = Math.round(slNhap * 0.7);
        }
        return (int) xuat;
    }

    public int getDongia(){
        int dongia = 0;
        if(id.endsWith("Y")){
            dongia = 110000;
        }
        if(id.endsWith("N")){
            dongia = 135000;
        }
        return dongia;
    }

    public int getTien(){
        return getslXuathang() * getDongia();
    }

    public int getThue(){
        double thue = 0;
        if(id.startsWith("A") && id.endsWith("Y")){
            thue = getTien() * 0.08;
        }
        if(id.startsWith("A") && id.endsWith("N")){
            thue = getTien() * 0.11;
        }
        if(id.startsWith("B") && id.endsWith("Y")){
            thue = getTien() * 0.17;
        }
        if(id.startsWith("B") && id.endsWith("N")){
            thue = getTien() * 0.22;
        }
        return (int) thue;
    }

    @Override
    public String toString(){
        return id + " " + slNhap + " " + getslXuathang() + " " + getDongia() + " " + getTien() + " " + getThue();
    }


};
public class J05048_BangTheoDoiNhapXuatHang {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        XuatHang[] a = new XuatHang[n];
        for(int i = 0; i < n; i++){
            a[i] = new XuatHang();
            a[i].Input(sc);
        }

        for(XuatHang i : a){
            System.out.println(i);
        }
    }
}
