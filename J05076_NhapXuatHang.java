// import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

import java.util.*;

class NXH{
    private String id, name, rate;
    private double soLuongNhap, donGiaNhap, soLuongXuat;

    public NXH(){

    }

    public void Input(Scanner in){
        id = in.nextLine();
        name = in.nextLine();
        rate = in.nextLine();
    }

    public String getId(){
        return id;
    }

    public void setNhapXuat(double soLuongNhap, double donGiaNhap, double soLuongXuat){
        this.soLuongNhap = soLuongNhap;
        this.donGiaNhap = donGiaNhap;
        this.soLuongXuat = soLuongXuat;
    }

    public double getGiaTriXuat(){
        double tongXuat = soLuongXuat * donGiaNhap;
        double laiXuat = 0;
        switch (rate) {
            case "A":
                laiXuat = 0.08;
                break;
            case "B":
                laiXuat = 0.05;
                break;
            case "C":
                laiXuat = 0.01;
                break;
        }

        return tongXuat *(1+laiXuat);
    }

    @Override
    public String toString(){
        double giaTriNhap = soLuongNhap * donGiaNhap;
        double giaTriXuat =  getGiaTriXuat();

        return id + " " +  name + " " + String.format("%.0f", giaTriNhap) + " " +  String.format("%.0f", giaTriXuat);
     }

};

public class J05076_NhapXuatHang {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        NXH[] a = new NXH[n];
        Map<String, NXH> products =  new HashMap<>();

        for(int i = 0; i < n; i++){
            a[i] = new NXH();
            a[i].Input(in);
            products.put(a[i].getId(), a[i]);
        }

        int m =  Integer.parseInt(in.nextLine());
        for(int i = 0; i < m; i++){
            String[] data = in.nextLine().split(" ");
            String idHang = data[0];
            double soLuongNhap = Double.parseDouble(data[1]);
            double donGiaNhap = Double.parseDouble(data[2]);
            double soLuongXuat = Double.parseDouble(data[3]);

            NXH product = products.get(idHang);
            if(product != null){
                product.setNhapXuat(soLuongNhap, donGiaNhap, soLuongXuat);
                System.out.println(product);
            }
        }
        in.close();
    }
}