import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
// import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


class VDV2{
    
    private String id, name, dob;
    private LocalTime begin, finish;
    public static int cnt = 1;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public VDV2(){

    }

    public void Input(Scanner sc){
        id = "VDV"  + String.format("%02d", cnt++);
        name =  sc.nextLine();
        dob = sc.nextLine();
        begin = LocalTime.parse(sc.nextLine());
        finish = LocalTime.parse(sc.nextLine());
    }

    public LocalTime getReal(){
        return finish.minusHours(begin.getHour()).minusMinutes(begin.getMinute()).minusSeconds(begin.getSecond());
    }

    public short getAge(){
        return (short) (2021 - Short.parseShort(dob.substring(6)));
    }

    public LocalTime getPrior(){
        LocalTime prior;
        if(getAge() < 18){
            prior = LocalTime.of(0, 0, 0);
        }
        else if(getAge() < 25){
            prior = LocalTime.of(0, 0, 1);
        }
        else if(getAge() < 32){
            prior = LocalTime.of(0, 0, 2);
        }
        else{
            prior = LocalTime.of(0, 0, 3);
        }
        return prior;
    }

    public LocalTime getAchieve(){
        return getReal().minusSeconds(getPrior().getSecond());
    }

    @Override
    public String toString(){
        return id +  " " +  name + " " + getReal().format(formatter) + " " + getPrior().format(formatter) +" " + getAchieve().format(formatter);
    }
}
public class J05056_XepHangVanDongVien2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<VDV2> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            VDV2 vdv = new VDV2();
            vdv.Input(sc);
            a.add(vdv);
        }


        //Xếp hạng
        List<VDV2> listsx = new ArrayList<>(a);
        listsx.sort((x,y) -> x.getAchieve().compareTo(y.getAchieve()));

        int rank = 1;
        Map<VDV2, Integer> xepHang = new HashMap<>(n);
        for(int i = 0; i < n; i++){
            if(i > 0 && listsx.get(i).getAchieve().equals(listsx.get(i-1).getAchieve())){
                xepHang.put(listsx.get(i), xepHang.get(listsx.get(i-1)));
            }
            else{
                xepHang.put(listsx.get(i), rank);
            }
            rank++;
        }

        a.sort((x,y) -> x.getAchieve().compareTo(y.getAchieve()));

        for(VDV2 i : a){
            System.out.println(i + " " + xepHang.get(i));
        }
        sc.close();
    }
}
