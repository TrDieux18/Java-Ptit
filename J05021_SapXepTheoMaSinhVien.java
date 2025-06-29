import java.util.*;

class SxmSinhVien {

    private String id, name, lop, email;

    public SxmSinhVien() {

    }

    public String getId() {
        return id;
    }

    

    public String getEmail() {
        return email;
    }

    public void Input(Scanner sc) {
        id = sc.nextLine();
        name = sc.nextLine();
        lop = sc.nextLine();
        email = sc.nextLine();
    }


    @Override
    public String toString() {
        return id + " " + name + " " + lop + " " + email;
    }
}

public class J05021_SapXepTheoMaSinhVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SxmSinhVien> ds = new ArrayList<>();
        while (sc.hasNext()) {
            SxmSinhVien sv = new SxmSinhVien();
            sv.Input(sc);
            ds.add(sv);
            if(sv.getEmail().contains(" ")){
                break;
            }
        }

        Collections.sort(ds, new Comparator<SxmSinhVien>() {
            @Override
            public int compare(SxmSinhVien o1, SxmSinhVien o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });

        for (SxmSinhVien sv : ds) {
            System.out.println(sv);
        }
    }
}
