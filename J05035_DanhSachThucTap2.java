import java.util.*;

class ThucTap2 {

    private  String stt, id, name, lop, email, dn;
    public static int cnt = 1;
    public ThucTap2 (){

    }

    public String getId(){
        return id;
    }

    public String getDn(){
        return dn;
    }
    
    public void Input(Scanner sc){
        stt = String.format("%01d", cnt++);
        id = sc.nextLine();
        name = sc.nextLine();
        lop = sc.nextLine();
        email = sc.nextLine();
        dn = sc.nextLine();
    }

    @Override
    public String toString(){
        return stt + " " +  id + " " + name + " " + lop + " " + email + " "  +dn;
    }
};

public class J05035_DanhSachThucTap2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ThucTap2 > ds = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            ThucTap2  tt =  new ThucTap2 ();
            tt.Input(sc);
            ds.add(tt);
        }

        Collections.sort(ds, new Comparator<ThucTap2 >() {
           public int compare(ThucTap2  x, ThucTap2  y){
                return x.getId().compareTo(y.getId());
           } 
        });

        int q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < q; i++){
            String s = sc.nextLine();
            for(ThucTap2  x : ds){
                if(x.getDn().equals(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
