// package CodeJ;
import java.util.Scanner;

class Student {

    private String code, name, add;
    private int dob;
    public int hs;

    public Student() {

    }

    public Student(String code) {
        this.code = code;
    }

    public Student(String code, String name, String add, int dob) {
        this.code = code;
        this.name = name;
        this.add = add;
        this.dob = dob;
    }

    // public String getCode(){
    // return code;
    // }

    public void input() {
        Scanner sc = new Scanner(System.in);
        code = sc.nextLine();
        name = sc.nextLine();
        add = sc.nextLine();
        // sc.nextLine();
        dob = sc.nextInt();
        sc.close();
    }

    public void output() {
        System.out.println(code + ' ' + name + ' ' + add + ' ' + dob);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student [code=" + code + ", name=" + name + ", add=" + add + ", dob=" + dob + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((add == null) ? 0 : add.hashCode());
        result = prime * result + dob;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (add == null) {
            if (other.add != null)
                return false;
        } else if (!add.equals(other.add))
            return false;
        if (dob != other.dob)
            return false;
        return true;
    }

};

class Hsinh extends Student{
    protected int hs;
}

public class JavaOOP_Class {
    public static void main(String[] args) {
        Student s = new Student();
        s.input();
        System.out.println(s.toString());
        System.out.println(s.hashCode());
    }
}
