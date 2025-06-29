import java.util.*;

class CLB2 {
    private String id, name;
    private int giaVe;

    public CLB2(String id, String name, int giaVe) {
        this.id = id;
        this.name = name;
        this.giaVe = giaVe;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGiaVe() {
        return giaVe;
    }
}

class TD2 {
    private String idtrandau;
    private int socoDongVien;
    private CLB2 CLB2;

    public TD2(String idtrandau, int socoDongVien, CLB2 CLB2) {
        this.idtrandau = idtrandau;
        this.socoDongVien = socoDongVien;
        this.CLB2 = CLB2;
    }
    

    public String getIdtrandau() {
        return idtrandau;
    }


    public long getDoanhThu() {
        return CLB2.getGiaVe() * socoDongVien;
    }

    @Override
    public String toString() {
        return idtrandau + " " + CLB2.getName() + " " + getDoanhThu();
    }
}

public class J05070_CauLacBoBongDa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        // Danh sách các câu lạc bộ
        List<CLB2> CLB2List = new ArrayList<>();

        // Đọc thông tin các câu lạc bộ
        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            String name = sc.nextLine();
            int giaVe = Integer.parseInt(sc.nextLine());
            CLB2List.add(new CLB2(id, name, giaVe));
        }

        int m = Integer.parseInt(sc.nextLine());
        List<TD2> dsTranDau = new ArrayList<>();

        for(int i = 0; i < m ; i++){
            String[] tranDauInfor = sc.nextLine().split(" ");
            String idtran = tranDauInfor[0];
            int soNguoi = Integer.parseInt(tranDauInfor[1]);

            String clbId = idtran.substring(1,3);
            CLB2 clb = null;

            for(CLB2 c : CLB2List){
                if(c.getId().equals(clbId)){
                    clb = c;
                    break;
                }
            }

            if(clb != null){
                dsTranDau.add(new TD2(idtran, soNguoi, clb));
            }
        }

        dsTranDau.sort((x,y) ->  x.getDoanhThu() != y.getDoanhThu() ? Long.compare(y.getDoanhThu(), x.getDoanhThu()) : x.getIdtrandau().compareTo(y.getIdtrandau()));

       
        for (TD2 tranDau : dsTranDau) {
            System.out.println(tranDau);
        }
        sc.close();
    }
}
