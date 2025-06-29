// package CodeJ;
public class JavaOOP2  {
    public static void main(String[] args) {
        System.out.println("Run JavaOOP2");
        JavaOOP st1 = new JavaOOP("Tran Dieu",26);
        System.out.println(st1.getName() + " " + st1.getAge());
        st1.setAge(12);
        st1.setName("New Name");
        System.out.println(st1.getName() + " " + st1.getAge());
    }
}
