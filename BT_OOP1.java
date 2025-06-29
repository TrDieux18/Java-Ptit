public class BT_OOP1 {
    private String name;
    private double price;
    private double tax;

    public BT_OOP1() {
    }

    public BT_OOP1(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public BT_OOP1 nhapThongTin(String name, double price, double tax) {
        BT_OOP1 pr = new BT_OOP1(name, price, tax);

        return pr;
    }

    public void xuatThongTin(BT_OOP1 Pr) {
        System.out.println("Name = " + Pr.getName());
        System.out.printf("Price = %.3f \n", Pr.getPrice());
        System.out.printf("Tax = %.3f \n", Pr.getTax());
    }

    public double getTaxPrice(double price, double tax) {
        return price * tax;
    }

    public static void main(String[] args) {
        System.out.println("Run BT_OOP1");
        BT_OOP1 pr1 = new BT_OOP1();
        BT_OOP1 pr2 = pr1.nhapThongTin("Computer", 200, 0.1);
        pr1.xuatThongTin(pr2);

        System.out.println("Tra them: " + pr1.getTaxPrice(pr2.getPrice(), pr2.getTax()));
    }
}
