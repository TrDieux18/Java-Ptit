import java.util.*;
import java.io.File;
import java.io.IOException;

class SV {
    private String idSV, nameSV, lop, email;

    public SV(String id, String name, String lop, String email) {
        this.idSV = id;
        this.nameSV = ChuanHoa(name);
        this.lop = lop;
        this.email = email;
    }

    private String ChuanHoa(String ten) {
        String[] words = ten.trim().toLowerCase().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return ans.toString().trim();
    }

    public String getIdSV() {
        return idSV;
    }

    public String getNameSV() {
        return nameSV;
    }

    public String getLop() {
        return lop;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return idSV + " " + nameSV + " " + lop;
    }
}

class DN {
    private String idDN, nameDN;
    private int nhan;

    public DN(String id, String name, int nhan) {
        this.idDN = id;
        this.nameDN = name;
        this.nhan = nhan;
    }

    public String getIdDN() {
        return idDN;
    }

    public String getNameDN() {
        return nameDN;
    }

    public int getNhan() {
        return nhan;
    }
}

class TT {
    private String idSV, idDN;

    public TT(String idSV, String idDN) {
        this.idSV = idSV;
        this.idDN = idDN;
    }

    public String getIdSV() {
        return idSV;
    }

    public String getIdDN() {
        return idDN;
    }
}

public class J07038_DanhSachThucTap3 {

    public static void main(String[] args) throws IOException {
        Scanner scSV = new Scanner(new File("SINHVIEN.in"));
        Scanner scDN = new Scanner(new File("DN.in"));
        Scanner scTT = new Scanner(new File("THUCTAP.in"));
        // Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(scSV.nextLine());
        Map<String, SV> mpSV = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String idSV = scSV.nextLine();
            String nameSV = scSV.nextLine();
            String lop = scSV.nextLine();
            String email = scSV.nextLine();
            SV sv = new SV(idSV, nameSV, lop, email);
            mpSV.put(idSV, sv);
        }

        int m = Integer.parseInt(scDN.nextLine());
        Map<String, DN> mpDN = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String idDN = scDN.nextLine();
            String nameDN = scDN.nextLine();
            int nhan = Integer.parseInt(scDN.nextLine());
            DN dn = new DN(idDN, nameDN, nhan);
            mpDN.put(idDN, dn);
        }

        int h = Integer.parseInt(scTT.nextLine());
        List<TT> TTs = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            String idSV = scTT.next();
            String idDN = scTT.next();
            TTs.add(new TT(idSV, idDN));
        }

        scTT.nextLine();
        int q = Integer.parseInt(scTT.nextLine());
        for (int i = 0; i < q; i++) {
            String key = scTT.nextLine();
            DN dn = mpDN.get(key);
            System.out.println("DANH SACH THUC TAP TAI " + dn.getNameDN() + ":");

            List<SV> list = new ArrayList<>();
            for (TT tt : TTs) {
                if (tt.getIdDN().equals(key)) {
                    SV sv = mpSV.get(tt.getIdSV());
                    if (sv != null) {
                        list.add(sv);
                    }
                }
            }

            list.sort(Comparator.comparing(SV::getIdSV));

            int cnt = 0;
            for (SV sv : list) {
                cnt++;
                System.out.println(sv);
                if (cnt == dn.getNhan())
                    break;
            }
        }

        scSV.close();
        scDN.close();
        scTT.close();
    }
}