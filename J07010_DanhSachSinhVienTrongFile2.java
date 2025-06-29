import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

class SinhVien3{
    public static int dem = 1;
    private String msv, hoten, dob, lop;
    private float gpa;

    public SinhVien3(String hoten, String lop, String dob, float gpa) throws ParseException{
        this.msv = "B20DCCN" + String.format("%03d", dem++);
        this.hoten = hoten;
        this.lop = lop;
        if(dob.charAt(2) != '/'){
            dob = "0" + dob;
        }
        if(dob.charAt(5) != '/'){
            dob = dob.substring(0,3) +"0" + dob.substring(3);
        }
        this.dob = dob;
     
        this.gpa = gpa;
    }
   
    @Override
    public String toString() {
        return msv + " " + hoten + " " + lop + " " + dob + " " + String.format("%.2f", gpa);
    }
    
};
public class J07010_DanhSachSinhVienTrongFile2 {

    public static void main(String[] args) throws FileNotFoundException, ParseException{
        Scanner sc = new Scanner(new File("SV.in"));
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            String ht = sc.nextLine();
            String lop = sc.nextLine();
            String ns = sc.nextLine();
            float gpa = Float.parseFloat(sc.nextLine());
            SinhVien3 sv = new SinhVien3(ht, lop, ns,gpa);
            System.out.println(sv);
        }
        sc.close();
    }
}
