package CodePTIT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class HoaDon {

    private String id, name;
    private int donGiaLoai1, dGiaLoai2;

    public HoaDon() {
    }

    public HoaDon(String id, String name, int donGiaLoai1, int dGiaLoai2) {
        this.id = id;
        this.name = name;
        this.donGiaLoai1 = donGiaLoai1;
        this.dGiaLoai2 = dGiaLoai2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDonGiaLoai1() {
        return donGiaLoai1;
    }

    public void setDonGiaLoai1(int donGiaLoai1) {
        this.donGiaLoai1 = donGiaLoai1;
    }

    public int getdGiaLoai2() {
        return dGiaLoai2;
    }

    public void setdGiaLoai2(int dGiaLoai2) {
        this.dGiaLoai2 = dGiaLoai2;
    }

}

class LoaiHang {

    private String id, idfull, name;
    private int giamGia, Gia;

    public LoaiHang() {
    }

    public LoaiHang(String idfull, String name, int giamGia, int Gia) {
        this.idfull = idfull;
        this.name = name;
        this.giamGia = giamGia;
        this.Gia = Gia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdfull() {
        return idfull;
    }

    public void setIdfull(String idfull) {
        this.idfull = idfull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int Gia) {
        this.Gia = Gia;
    }

}

public class BaiTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, HoaDon> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int dGiaLoai1 = Integer.parseInt(sc.nextLine());
            int dgiaLoai2 = Integer.parseInt(sc.nextLine());
            mp.put(id, new HoaDon(id, name, dGiaLoai1, dgiaLoai2));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<LoaiHang> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] data = sc.nextLine().split(" ");
            String id1 = data[0];
            int soLuong = Integer.parseInt(data[1]);

            String id2 = id1.substring(0, 2);
            int type = Integer.parseInt(id1.substring(2, 3));
            HoaDon hd = mp.get(id2);

            int giaLoai = (type == 1) ? hd.getDonGiaLoai1() : hd.getdGiaLoai2();
            int tongGia = giaLoai * soLuong;

            double giamGia = 0;
            if (soLuong >= 150) {
                giamGia = (int) tongGia * 0.5;
            } else if (soLuong >= 100) {
                giamGia = (int) tongGia * 0.3;
            } else if (soLuong >= 50) {
                giamGia = (int) tongGia * 0.15;
            }

            int giaThucte = tongGia - (int) giamGia;
            String idfull = id1 + "-" + String.format("%03d", i+1);
            list.add(new LoaiHang(idfull, hd.getName(), (int) giamGia, giaThucte));

        }
        
        list.sort(((o1, o2) -> o2.getGia() - o1.getGia()));

        for (LoaiHang i : list) {
            System.out.println(i.getIdfull() + " " + i.getName() + " " + i.getGiamGia() + " " + i.getGia());
        }
    }
}

