import java.util.Scanner;
import java.util.Stack;

public class J03027_RutGonXauKyTu {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && st.peek() == s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }

        if(st.isEmpty()){
            System.out.println("Empty String");
        }
        else{
            for(char c : st){
                System.out.print(c);
            }
        }
        sc.close();
    }
  
}
