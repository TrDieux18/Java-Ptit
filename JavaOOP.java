// package CodeJ;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class JavaOOP {
    //class attributes
    private String name;
    private int age;

    public JavaOOP(){

    }

    //class overloading
    public JavaOOP(String ten, int tuoi){
        this.age = tuoi;
        this.name = ten;
    }

    //class method
    public void learnJava(){
        System.out.println("Hello OOP");
    }

    //function overloading
    public void learnJava(int n){
        System.out.println("Hello OOP");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "JavaOOP [name=" + name + ", age=" + age + "]";
    }
    
    
    // public String getName(){
    //     return this.name;
    // }

    // public int getAge(){
    //     return this.age;
    // }

    // public void setName(String name1){
    //     this.name =  name1;
    // }

    // public void setAge(int age1){
    //     this.age = age1;
    // }
    public static void main(String[] args) {
        JavaOOP s1 = new JavaOOP("Tran Trong Dieu", 19);
        JavaOOP s2 = new JavaOOP("Nguyen Huy Hoang",'2');
        JavaOOP s3 = new JavaOOP("Dinh Hoang Nam",'3');
        ArrayList<JavaOOP> a =  new ArrayList<>();
        a.add(s1);
        a.add(s2);
        a.add(s3);
        // for (int i = 0; i <  a.size();i++) {
        //     if(a.get(i).getName().startsWith("Tran")){
        //         System.out.println(a.get(i));
        //     }
        // }
        Pattern pat = Pattern.compile("w3shcools", Pattern.CASE_INSENSITIVE);
        Matcher mat = pat.matcher("java w3shcools");
        boolean matFound = mat.find();
        if(matFound){
            System.out.println("Found!");
        }
        else{
            System.out.println("Not Found!");
        }
    }
}