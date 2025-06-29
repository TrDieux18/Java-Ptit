import java.util.*;

class BLTPB {

    private String id, name, phongBan;
    private int luongCoBan, soNgayCong;
    private Map<String, String> phongBanMap;

    public BLTPB(Map<String, String> phongBanMap) {
        this.phongBanMap = phongBanMap;
    }

    public void setDuLieu(String id, String name, int luongCoBan, int soNgayCong) {
        this.id = id;
        this.name = name;
        this.luongCoBan = luongCoBan;
        this.soNgayCong = soNgayCong;
        getPhongBan();
    }

    public void getPhongBan() {
        String maPhong = id.substring(3).toUpperCase();
        this.phongBan = phongBanMap.get(maPhong);
    }

    public String getMaPhong() {
        return id.substring(3).toUpperCase();
    }

    public int getHeSo() {
        String ans = id.substring(0, 1).toUpperCase();
        int heSo = 0;
        int nam = Integer.parseInt(id.substring(1, 3));
        if (ans.equals("A")) {
            if (nam < 4) {
                heSo = 10;
            } else if (nam < 9) {
                heSo = 12;
            } else if (nam < 16) {
                heSo = 14;
            } else {
                heSo = 20;
            }
        } else if (ans.equals("B")) {
            if (nam < 4) {
                heSo = 10;
            } else if (nam < 9) {
                heSo = 11;
            } else if (nam < 16) {
                heSo = 13;
            } else {
                heSo = 16;
            }
        } else if (ans.equals("C")) {
            if (nam < 4) {
                heSo = 9;
            } else if (nam < 9) {
                heSo = 10;
            } else if (nam < 16) {
                heSo = 12;
            } else {
                heSo = 14;
            }
        } else if (ans.equals("D")) {
            if (nam < 4) {
                heSo = 8;
            } else if (nam < 9) {
                heSo = 9;
            } else if (nam < 16) {
                heSo = 11;
            } else {
                heSo = 13;
            }
        }
        return heSo;
    }

    public long getTong() {
        return (long) soNgayCong * luongCoBan * getHeSo() * 1000;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getTong();
    }

};

public class J05078_BangLuongTheoPhongBan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n =  Integer.parseInt(in.nextLine());
        Map<String, String> phongBanMap = new HashMap<>();
        for(int i =0; i < n; i++){
            String id = in.next();
            String tenPhong = in.nextLine().trim();
            phongBanMap.put(id, tenPhong);
        }

        int m =  Integer.parseInt(in.nextLine());
        List<BLTPB> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String id = in.nextLine();
            String name = in.nextLine();
            int luongCoBan = Integer.parseInt(in.nextLine());
            int soNgayCong = Integer.parseInt(in.nextLine());

            BLTPB a = new BLTPB(phongBanMap);
            a.setDuLieu(id, name, luongCoBan, soNgayCong);
            list.add(a);
        }

        String s = in.nextLine().toUpperCase();
        System.out.println("Bang luong phong " + phongBanMap.get(s) + ":");
        for(BLTPB i : list){
            if(i.getMaPhong().equals(s)){
                System.out.println(i);
            }
        }
        in.close();
    }
}
