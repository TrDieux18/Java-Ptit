import java.util.*;

class TinhTien{

    private String id, name;
    private int soLuong;
    private long donGia, tienChietKhau;

    public TinhTien(String id, String name, int soLuong, long donGia, long tienChietKhau) {
        this.id = id;
        this.name = name;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tienChietKhau = tienChietKhau;
    }

    public long getTongTien(){
        return soLuong * donGia - tienChietKhau;
    }

    @Override
    public String toString(){
        return id + " " + name +" " + soLuong +" " + donGia + " " + tienChietKhau +" " + getTongTien();
    }
    
};

public class J05012_TinhTien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = Integer.parseInt(sc.nextLine());
        List<TinhTien> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String id = sc.nextLine();
            String name = sc.nextLine();
            int soLuong = Integer.parseInt(sc.nextLine());
            long donGia = Long.parseLong(sc.nextLine());
            long tienChietKhau = Long.parseLong(sc.nextLine());
            a.add(new TinhTien(id, name, soLuong, donGia, tienChietKhau));
        }

        a.sort((x,y) -> Long.compare(y.getTongTien(),x.getTongTien() ));

        for(TinhTien i : a){
            System.out.println(i);
        }
        sc.close();
    }
}
