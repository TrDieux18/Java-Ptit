import java.util.*;

class Nhavien {

    private String id, name, chucVu;
    private int luongCoBan, soNgayCong;
    public static int cnt = 1;

    public Nhavien() {
    }

    public void Input(Scanner sc) {
        id = "NV" + String.format("%02d", cnt++);
        name = sc.nextLine();
        chucVu = sc.nextLine().toUpperCase();
        luongCoBan = Integer.parseInt(sc.nextLine());
        soNgayCong = Integer.parseInt(sc.nextLine());
    }

    public String getChucVu() {
        return chucVu;
    }

    public int getLuong() {
        return luongCoBan * soNgayCong;
    }

    public String getId() {
        return id;
    }

    public int getPhuccap() {
        int phuCap = 0;
        switch (chucVu) {
            case "GD":
                phuCap = 500;
                break;
            case "PGD":
                phuCap = 400;
                break;
            case "TP":
                phuCap = 300;
                break;
            case "KT":
                phuCap = 250;
                break;
            default:
                phuCap = 100;
                break;
        }
        return phuCap;
    }

    public int getLuongchinh(){
        return getLuong()+getPhuccap();
    }
    public int getTamung() {
        int tongLuongPhuCap = getPhuccap() + getLuong();
        int tamung = 0;
        if (tongLuongPhuCap * 2 / 3 < 25000) {
            double tu = tongLuongPhuCap * 2 / 3.0;
            tamung = (int) (Math.round(tu / 1000) * 1000);
        } else {
            tamung = 25000;
        }
        return tamung;
    }

    public int getConLai() {
        return getLuong() + getPhuccap() - getTamung();
    }

    public String Chuanhoa(String s){
        String[] words = s.split("\\s+");
        StringBuilder ans =  new StringBuilder();
        for(int i = 0; i < words.length; i++){
            ans.append(words[i].substring(0, 1).toUpperCase()).append(words[i].substring(1).toLowerCase()).append(" ");
        }
        return ans.toString().trim();
    }

    @Override
    public String toString() {
        return id + " " + Chuanhoa(name) + " " + getPhuccap() + " " + getLuong() + " " + getTamung() + " " + getConLai();
    }
}

public class J05045_SapXepNhanVienTheoThuNhap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Nhavien> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            Nhavien nv = new Nhavien();
            nv.Input(sc);
            a.add(nv);
        }

        Collections.sort(a, new Comparator<Nhavien>() {
            public int compare(Nhavien x, Nhavien y) {
                if (x.getLuongchinh() != y.getLuongchinh()) {
                    return y.getLuongchinh() - x.getLuongchinh();
                }
                return x.getId().compareTo(y.getId());
            }
        });

        for (Nhavien nv : a) {
            System.out.println(nv);
        }
        sc.close();
    }
}
