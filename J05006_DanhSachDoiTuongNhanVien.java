import java.util.*;

class DSNhanVien{
    private String mnv, hoten, gt, dob, add, tax, date;
    public static int cnt = 1;
    public DSNhanVien(){

    }

    public void input(Scanner sc){

        mnv = String.format("%05d", cnt++);
        hoten = sc.nextLine();
        gt = sc.nextLine();
        dob = sc.nextLine();
        if(dob.charAt(2) != '/'){
            dob = "0" + dob;
        }
        if(dob.charAt(5) != '/'){
            dob = dob.substring(0, 3) + "0" + dob.substring(3);
        }

        add = sc.nextLine();
        tax = sc.nextLine();
        date = sc.nextLine();
        if(date.charAt(2) != '/'){
            date = "0" + date;
        }
        if(date.charAt(5) != '/'){
            date = date.substring(0, 3) + "0" + date.substring(3);
        }
    }

    @Override
    public String toString() {
        return  mnv + " " + hoten + " " + gt + " " + dob + " " + add  + " " + tax + " " + date;
    }

    
}

public class J05006_DanhSachDoiTuongNhanVien {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        DSNhanVien[] a = new DSNhanVien[n];
        for(int i = 0; i < n; i++){
            a[i] = new DSNhanVien();
            a[i].input(sc);
        }

        for(DSNhanVien i : a){
            System.out.println(i);
        }
    }
}