// package CodeJ;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regx {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b");
        Matcher m = p.matcher("foobar@gmail.com");
        
        if (m.find())
            System.out.println("Correct!");
        else{
            System.out.println("Incorrect!");
        }
    }
}
