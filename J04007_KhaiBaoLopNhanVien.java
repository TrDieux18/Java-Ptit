import java.util.Scanner;

class NhanVien{
    private String mnv, hoten, gt, ns, add, tax, doc;

    public NhanVien(){

    }

    public NhanVien(String mnv, String hoten, String gt, String ns, String add, String tax, String doc){
        this.mnv = mnv;
        this.hoten = hoten;
        this.gt = gt;
        this.ns = ns;
        this.add = add;
        this.tax = tax;
        this.doc = doc;
    }

    public String getMnv() {
        return mnv;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        mnv = "00001";
        hoten = sc.nextLine();
        gt = sc.nextLine();
        ns = sc.nextLine();
        if(ns.charAt(2) != '/'){
            ns = "0" + ns;
        }
        if(ns.charAt(5) != '/'){
            ns = ns.substring(0, 3) +  "0" + ns.substring(3);
        }
        add = sc.nextLine();
        tax = sc.nextLine();
        doc = sc.nextLine();
        if(doc.charAt(2) != '/'){
            doc = "0" + doc;
        }
        if(doc.charAt(5) != '/'){
            doc = doc.substring(0, 3) + "0" + doc.substring(3);
        }
        sc.close();
    }

    public void output(){
        System.out.println(mnv +" " + hoten + " " + gt + " " + ns + " " + add + " " + tax + " " + doc);
    }
};

public class J04007_KhaiBaoLopNhanVien {
    
    public static void main(String[] args) {
        NhanVien nv = new NhanVien();
        nv.input();
        nv.output();
    }
}
