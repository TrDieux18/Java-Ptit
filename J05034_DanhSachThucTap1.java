import java.util.*;

class ThucTap{

    private  String stt, id, name, lop, email, dn;
    public static int cnt = 1;
    public ThucTap(){

    }

    public String getName(){
        return name;
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

public class J05034_DanhSachThucTap1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ThucTap> ds = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            ThucTap tt =  new ThucTap();
            tt.Input(sc);
            ds.add(tt);
        }

        Collections.sort(ds, new Comparator<ThucTap>() {
           public int compare(ThucTap x, ThucTap y){
                return x.getName().compareTo(y.getName());
           } 
        });

        int q = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < q; i++){
            String s = sc.nextLine();
            for(ThucTap x : ds){
                if(x.getDn().equals(s)){
                    System.out.println(x);
                }
            }
        }
    }
}
