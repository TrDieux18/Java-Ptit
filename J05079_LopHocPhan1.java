import java.util.*;

class HocPhan {
    private String id, name, nhom, hoten;

    public HocPhan() {

    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        nhom = sc.nextLine();
        hoten = sc.nextLine();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNhom() {
        return nhom;
    }

    @Override
    public String toString() {
        return nhom + " " + hoten;
    }
}

public class J05079_LopHocPhan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, String> mp = new HashMap<>();
        List<HocPhan> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HocPhan hp = new HocPhan();
            hp.Input(sc);
            a.add(hp);
            mp.put(hp.getId(), hp.getName());
        }

        a.sort((x, y) -> !x.getNhom().equals( y.getNhom()) ? x.getNhom().compareTo(y.getNhom()) : x.getName().compareTo(y.getName()));
        
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String key = sc.nextLine();
            System.out.println("Danh sach nhom lop mon " + mp.get(key) + ":");
            for (HocPhan x : a) {
                if (x.getId().equals(key)) {
                    System.out.println(x);
                }
            }
        }
    }
}