// import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;



class XeDap{

    private String name, khuVuc;
    private LocalTime finish;

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

    public XeDap(String name, String khuVuc, LocalTime finish){
        this.name =  name;
        this.khuVuc = khuVuc;
        this.finish = finish;
    }

    public LocalTime getThoiGian(){
        LocalTime begin = LocalTime.of(6,0);
        LocalTime value = finish.minusHours(begin.getHour()).minusMinutes(begin.getMinute());
        return value;
    }

    public double formatTG(){
        double gio = Double.valueOf(getThoiGian().getHour());
        double phut = Double.valueOf(getThoiGian().getMinute())/60;
        return gio + phut;
    }

    public double getVanToc(){
        double vanToc = 120 / formatTG();
        return Math.round(vanToc * 100.0)/100.0;
    }

    public String getKiTu(String khuVuc, String name){
        String ans ="";
        String[] data1 = khuVuc.toUpperCase().split("\\s+");
        for(String i : data1){
            ans += i.charAt(0);
        }

        String[] data2 = name.toUpperCase().split("\\s+");
        for(String i : data2){
            ans += i.charAt(0);
        }

        return ans;
    }

    @Override
    public String toString(){
        return getKiTu(khuVuc, name) +" " + name + " " + khuVuc +" "+String.format("%.0f Km/h", getVanToc());
    }
};

public class J05015_DuaXeDap {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<XeDap> a = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String name = sc.nextLine();
            String khuVuc = sc.nextLine();
            LocalTime finish = LocalTime.parse(sc.nextLine(), formatter);
            a.add(new XeDap(name, khuVuc, finish));
        }

        a.sort((x, y) -> Double.compare(y.getVanToc(), x.getVanToc()));

        for(XeDap i : a){
            System.out.println(i);
        }
        sc.close();
    }
}
