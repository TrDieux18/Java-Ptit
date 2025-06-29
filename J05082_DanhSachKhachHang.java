import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

class KH {
    private String id, ten, gioiTinh, address;
    private LocalDate dob;

    public static int cnt = 1;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public KH(String ten, String gioiTinh, String dob, String address) {
        this.id =  "KH" + String.format("%03d", cnt++);
        this.ten = chuanHoa(ten);
        this.gioiTinh = gioiTinh;
        if(dob.charAt(2) != '/'){
            dob = "0" +dob;
        }
        if(dob.charAt(5) != '/'){
            dob = dob.substring(0,3) + "0" + dob.substring(3);
        }
        this.dob = LocalDate.parse(dob, formatter);
        this.address = address;
    }

    public LocalDate getDob() {
        return dob;
    }

    private String chuanHoa(String str) {
        String[] words = str.trim().toLowerCase().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        return ans.toString().trim();
    }

    public String toString() {
        return id + " " + ten + " " + gioiTinh + " " + address + " " + dob.format(formatter);
    }
}

public class J05082_DanhSachKhachHang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<KH> a= new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String gioiTinh = sc.nextLine();
            String dob = sc.nextLine();
            String address = sc.nextLine();
            a.add(new KH(ten, gioiTinh, dob, address));
        }

        a.sort((x, y) -> x.getDob().compareTo(y.getDob()));

        for (KH i : a) {
            // System.out.println(i.getDob());
            System.out.println(i);
        }
       
        sc.close();
    }
}
