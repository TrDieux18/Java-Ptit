import java.util.*;

class Age{

    private String dob, name;

    public Age(){

    }

    public void Input(Scanner sc){
        name = sc.next();
        dob = sc.next();
    }

    public String getTuoi(){
        String[] words = dob.split("/");
        String ans = "";
        for(int i = words.length - 1; i >= 0; i--){
            ans += words[i];
        }
        return ans;
    }

    @Override
    public String toString(){
        return name;
    }
};

public class J05032_TreNhatGiaNhat {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Age> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            Age t = new Age();
            t.Input(sc);
            a.add(t);
        }

        Collections.sort(a, new Comparator<Age>() {
            public int compare(Age x, Age y){
                return y.getTuoi().compareTo(x.getTuoi());
            }
        });
        System.out.println(a.get(0));
        System.out.println(a.get(a.size()-1));
        sc.close();
    }
}
