import java.util.*;

class HocPhan2 {
    private String id, name, nhom, hoten;

    public HocPhan2() {

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

    

    public String getHoten() {
        return hoten;
    }

    @Override
    public String toString() {
        return id +" " + name +" " + nhom;
    }
}

public class J05080_LopHocPhan2 {

    public static String ChuanHoa(String s){
        String[] words = s.toUpperCase().trim().split("\\s+");
        StringBuilder ans  = new StringBuilder();
        for(String word : words){
            ans.append(word.charAt(0)).append(word.substring(1).toLowerCase()).append(" ");
        }
        return ans.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<HocPhan2> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            HocPhan2 hp = new HocPhan2();
            hp.Input(sc);
            a.add(hp);
            
        }

        a.sort((x, y) -> !x.getId().equals(y.getId()) ? x.getId().compareTo(y.getId()) : x.getNhom().compareTo(y.getNhom()));
        
        int m = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < m; i++) {
            String key = sc.nextLine();
            System.out.println("Danh sach cho giang vien " + key + ":");
            for (HocPhan2 x : a) {
                if (x.getHoten().equalsIgnoreCase(key)) {
                    System.out.println(x);
                }
            }
        }
        sc.close();
    }
}