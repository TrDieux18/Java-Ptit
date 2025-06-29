import java.util.Scanner;

class Rectange {

    private double width, height;
    private String color;

    public Rectange() {
        width = 1;
        height = 1;
    }

    public Rectange(double w1, double h1, String c1) {
        this.color = c1;
        this.height = h1;
        this.width = w1;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color.substring(0, 1).toUpperCase() + color.substring(1).toLowerCase();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double findArea() {
        return getWidth() * getHeight();
    }

    public double findPerimeter() {
        return 2 * (getHeight() + getWidth());
    }
};

public class J04002_KhaiBaoLopHinhChuNhat {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Rectange hcn = new Rectange();
        hcn.setWidth(sc.nextDouble());
        hcn.setHeight(sc.nextDouble());
        hcn.setColor(sc.next());
        // hcn.setColor(hc.getColor) = hcn.getColor().substring(1).toLowerCase();
        if(hcn.getHeight() > 0 && hcn.getWidth() > 0){
            System.out.println((int) hcn.findPerimeter() + " " + (int) hcn.findArea() + " " + hcn.getColor());
        }
        else{
            System.out.println("INVALID");
        }
    }
}