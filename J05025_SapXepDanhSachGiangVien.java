import java.util.*;

class GiangVien{

    private String id, name, mon;
    public static int cnt = 1;

    public GiangVien(){

    }

    public String getId(){
        return id;
    }

    public String getName(){
        String[] res = name.split("\\s+");
        return res[res.length - 1];
    }

    public void Input(Scanner sc){
        id = "GV" + String.format("%02d", cnt++);
        name = sc.nextLine();
        mon = sc.nextLine();
    }

    public String formatMon(String s){
        String ans ="";
        String[] words = s.trim().split("\\s+");
        for(String word : words){
            ans += word.substring(0, 1).toUpperCase();
        }
        return ans;
    }

    @Override
    public String toString(){
        return id + " " + name + " " + formatMon(mon);
    }
};

public class J05025_SapXepDanhSachGiangVien {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<GiangVien> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            GiangVien gv = new GiangVien();
            gv.Input(sc);
            a.add(gv);
        }
        

        a.sort( new Comparator<GiangVien>() {
            public int compare(GiangVien x, GiangVien y){
                if(x.getName() != y.getName()){
                    return x.getName().compareTo(y.getName());
                }
                return x.getId().compareTo(y.getId());
            }
        });

        for(GiangVien i : a){
            System.out.println(i);
        }
    }
}
