import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class LuongMua {

    private String tenTram;
    private LocalTime begin, finish;
    private double luongMua;

    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    public LuongMua(String tenTram, String begin, String finish, double luongMua) {
        this.tenTram = tenTram;
        this.begin = LocalTime.parse(begin, formatter);
        this.finish = LocalTime.parse(finish, formatter);
        this.luongMua = luongMua;
    }

    public String getTenTram() {
        return tenTram;
    }

    public double getLuongMua() {
        return luongMua;
    }

    public double getThoiGian() {
        return Duration.between(begin, finish).toMinutes() / 60.0;
    }

};

public class J05019_LuongMuaTrungBinh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, List<LuongMua>> tramData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String tenTram = sc.nextLine();
            String begin = sc.nextLine();
            String finish = sc.nextLine();
            double luongMua = Double.parseDouble(sc.nextLine());

            LuongMua lm = new LuongMua(tenTram, begin, finish, luongMua);

            tramData.putIfAbsent(tenTram, new ArrayList<>());
            tramData.get(tenTram).add(lm);
        }

        int maTram = 1;

        for (Map.Entry<String, List<LuongMua>> entry : tramData.entrySet()) {
            String tenTram = entry.getKey();
            List<LuongMua> dsLuongMua = entry.getValue();

            double tongLuongMua = 0;
            double tongThoiGian = 0;

            for (LuongMua lm : dsLuongMua) {
                tongLuongMua += lm.getLuongMua();
                tongThoiGian += lm.getThoiGian();
            }

            double luongMuaTrungBinh = tongLuongMua / tongThoiGian;

            System.out.printf("T%02d %s %.2f\n", maTram, tenTram, luongMuaTrungBinh);
            maTram++;
        }
        sc.close();
    }
}
