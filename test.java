public class test {
    public static void main(String[] args) {
        int a = 2;
        int b = (--a) + (a++) + (++a) - (a--);
        // int c = a++;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
    }
}
