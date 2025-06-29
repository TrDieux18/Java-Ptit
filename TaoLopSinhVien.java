// package CodeJ;
import java.util.Scanner;

class Sinhvien{
    private String id, hoten, check;
    private int diem;

    public void input(){
        Scanner sc = new Scanner(System.in);
        id = "B21dccn123";
        hoten = sc.nextLine();
        check = sc.nextLine();
        diem = sc.nextInt();
        sc.close();
    }

    public void out(){
        id = id.toUpperCase();
        System.out.print(id + " " + hoten + " ");
        if(check.equals("true")){
            System.out.print("nam ");
        }
        else if(check.equals("false")){
            System.out.print("nu ");
        }
        if(diem < 5){
            System.out.print("hoc lai");
        }
        else{
            System.out.print("dat");
        }
    }
};

public class TaoLopSinhVien {

    public static void main(String[] args) {
        Sinhvien sv = new Sinhvien();
        //input
        sv.input();
        //output
        sv.out();
    }
}
