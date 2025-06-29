// import java.util.Scanner;

// class TaiLieu {
//     private String ma, tenNXB;
//     private int soBan;

//     public TaiLieu(String ma, String tenNXB, int soBan) {
//         this.ma = ma;
//         this.tenNXB = tenNXB;
//         this.soBan = soBan;
//     }

//     public String getMa() {
//         return ma;
//     }

//     public String getTenNXB() {
//         return tenNXB;
//     }

//     public int getSoBan() {
//         return soBan;
//     }

//     public void setMa(String ma) {
//         this.ma = ma;
//     }

//     public void setTenNXB(String tenNXB) {
//         this.tenNXB = tenNXB;
//     }

//     public void setSoBan(int soBan) {
//         this.soBan = soBan;
//     }

//     @Override
//     public String toString() {
//         return "TaiLieu [getMa()=" + getMa() + ", getTenNXB()=" + getTenNXB() + ", getSoBan()=" + getSoBan()
//                 + ", getClass()=" + getClass() + "]";
//     }

// };

// class Sach extends TaiLieu {
//     private String tensach, tentg;
//     private int soTrang;

//     public Sach(String ma, String tenNXB, int soBan, String tensach, String tentg, int soTrang) {
//         super(ma, tenNXB, soBan);
//         this.tensach = tensach;
//         this.tentg = tentg;
//         this.soTrang = soTrang;
//     }

//     public String getTensach() {
//         return tensach;
//     }

//     public String getTentg() {
//         return tentg;
//     }

//     public int getSoTrang() {
//         return soTrang;
//     }

//     public void setTensach(String tensach) {
//         this.tensach = tensach;
//     }

//     public void setTentg(String tentg) {
//         this.tentg = tentg;
//     }

//     public void setSoTrang(int soTrang) {
//         this.soTrang = soTrang;
//     }

//     @Override
//     public String toString() {
//         return "Sach [getMa()=" + getMa() + ", getTenNXB()=" + getTenNXB() + ", getSoBan()=" + getSoBan()
//                 + ", getTensach()=" + getTensach() + ", getTentg()=" + getTentg() + ", getSoTrang()=" + getSoTrang()
//                 + "]";
//     }

//     ;
// }

// class TapChi extends TaiLieu {

//     private int so, thang;

//     public TapChi(String ma, String tenNXB, int soBan, int so, int thang) {
//         super(ma, tenNXB, soBan);
//         this.so = so;
//         this.thang = thang;
//     }

//     public int getSo() {
//         return so;
//     }

//     public void setSo(int so) {
//         this.so = so;
//     }

//     public int getThang() {
//         return thang;
//     }

//     public void setThang(int thang) {
//         this.thang = thang;
//     }

//     @Override
//     public String toString() {
//         return "TapChi [getMa()=" + getMa() + ", getTenNXB()=" + getTenNXB() + ", getSoBan()=" + getSoBan()
//                 + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", getSo()=" + getSo()
//                 + ", getThang()=" + getThang() + "]";
//     }

// };

// interface ChucNang {
//     public Sach nhapSach(Scanner sc);

//     public TapChi nhapTapChi(Scanner sc);

//     public void out(TaiLieu[] a);

//     public TaiLieu[] Nhap(int n, Scanner sc);
// };

// class ThucHien implements ChucNang {
//     private static int maStatic = 1;

//     private TaiLieu nhap(Scanner sc) {
//         TaiLieu t = new TaiLieu(String.format("%03d", maStatic++), sc.nextLine(), Integer.parseInt(sc.nextLine()));
//         return t;
//     }

//     @Override
//     public TaiLieu[] Nhap(int n, Scanner sc) {
//         TaiLieu[] a = new TaiLieu[2 * n];
//         for (int i = 0; i < n; i++) {
//             a[i] = nhapSach(sc);
//         }

//         for (int i = 0; i < n; i++) {
//             a[n + i] = nhapTapChi(sc);
//         }
//         return a;
//     }

//     @Override
//     public Sach nhapSach(Scanner sc) {
//         TaiLieu t = nhap(sc);
//         Sach s = new Sach("S" + t.getMa(), sc.nextLine(), Integer.parseInt(sc.nextLine()), sc.nextLine(), sc.nextLine(),
//                 Integer.parseInt(sc.nextLine()));
//         return s;
//     }

//     @Override
//     public TapChi nhapTapChi(Scanner sc) {
//         TaiLieu t = nhap(sc);
//         TapChi tc = new TapChi("TC" + t.getMa(), sc.nextLine(), Integer.parseInt(sc.nextLine()),
//                 Integer.parseInt(sc.nextLine()), Integer.parseInt(sc.nextLine()));
//         return tc;
//     }

//     @Override
//     public void out(TaiLieu[] a) {
//         for (TaiLieu i : a) {
//             System.out.println(i);
//         }
//         System.out.println("Tong: " + a.length);
//     }

// };

// public class KeThua_DaHinh {

//     public static void main(String[] args) {
//         // TaiLieu t = new Sach("S001", "Kim Dong", 120, "LTHDT", "Tran Van A", 120);
//         // System.out.println(t);
//         // ((Sach) t).setSoTrang(150);
//         // System.out.println(t);
//         // TaiLieu t1 = new TapChi("TC001", "Kim Dong", 100, 2, 6);
//         // System.out.println(t1);
//         Scanner sc = new Scanner(System.in);
//         ChucNang c = new ThucHien();
//         TaiLieu[] t = c.Nhap(1, sc);
//         c.out(t);

//     }

// }
