import java.util.*;

class DD{

    private String id, name, lop;
    private int diemCC;
    private String ghiChu;

    public DD(){
        this.diemCC = 10;
        this.ghiChu ="";
    }

    public void Input(Scanner in){
        id = in.nextLine();
        name = in.nextLine();
        lop = in.nextLine();
    }

    public String getId() {
        return id;
    }

    public void getDiemCC(String dd){
        int diem = 10;
        for(char c : dd.toCharArray()){
            if(c =='m'){
                diem -= 1;
            }
            else if(c == 'v'){
                diem -= 2;
            }
        }
        this.diemCC = Math.max(diem, 0);
        if(this.diemCC == 0){
            this.ghiChu = "KDDK";
        }
    }

    @Override
    public String toString(){
        return id + " " + name  + " " + lop + " " + diemCC  + (ghiChu.isEmpty() ? "" : " " + ghiChu);
    }


}

public class J05074_DiemDanh1 {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        DD[] a = new DD[n];
        for(int i = 0; i < n; i++){
            a[i] = new DD();
            a[i].Input(in);
        }

        for(int i = 0; i < n; i++){
            String[] data = in.nextLine().split(" ");
            String maSv =  data[0];
            String diemd = data[1];

            for(DD c : a){
                if(c.getId().equalsIgnoreCase(maSv)){
                    c.getDiemCC(diemd);
                    break;
                }
            }
        }

        for(DD i : a){
            System.out.println(i);
        }

        in.close();
    }
}
