import java.util.*;

class SxSinhVien{

    private String id, name, lop, email;

    public SxSinhVien(){

    }

    
    public String getId() {
        return id;
    }


    public String getLop() {
        return lop;
    }


    public void input(Scanner sc){
        id = sc.nextLine();
        name = sc.nextLine();
        lop = sc.nextLine();
        email = sc.nextLine();
    }

    @Override
    public String toString(){
        return id + " " +name + " " + lop + " " + email; 
    }
};

public class J05020_SapXepSinhVienTheoLop {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SxSinhVien> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            SxSinhVien sv = new SxSinhVien();
            sv.input(sc);
            a.add(sv);
        }

        Collections.sort(a, new Comparator<SxSinhVien>() {
            public int compare(SxSinhVien x, SxSinhVien y){
                if(x.getLop().equals(y.getLop())){
                    return x.getId().compareTo(y.getId());
                }
                return x.getLop().compareTo(y.getLop());
            }
        });
        
        for(SxSinhVien i : a){
            System.out.println(i);
        }
    }
}