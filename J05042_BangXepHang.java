import java.util.*;

class XepHang {
    private String name;
    private int correct, submit;

    public XepHang() {}

    public String getName() {
        return name;
    }

    public int getCorrect() {
        return correct;
    }

    public void Input(Scanner sc) {
        name = sc.nextLine().toLowerCase();
        correct = sc.nextInt();
        submit = sc.nextInt();
        sc.nextLine(); 
    }

    public String Chuanhoa(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            ans.append(Character.toUpperCase(word.charAt(0)))
               .append(word.substring(1))
               .append(" ");
        }
        return ans.toString().trim();
    }

    @Override
    public String toString() {
        return Chuanhoa(name) + " " + correct + " " + submit;
    }
}

public class J05042_BangXepHang {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<XepHang> a = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            XepHang xh = new XepHang();
            xh.Input(sc);
            a.add(xh);
        }

        Collections.sort(a, new Comparator<XepHang>() {
            public int compare(XepHang x, XepHang y) {
                if (x.getCorrect() != y.getCorrect()) {
                    return y.getCorrect() - x.getCorrect(); 
                }
                return x.getName().compareTo(y.getName());
            }
        });

        for (XepHang i : a) {
            System.out.println(i);
        }
    }
}
