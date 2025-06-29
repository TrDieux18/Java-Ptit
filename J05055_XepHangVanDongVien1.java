/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

/**
 *
 * @author pc
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class VDV {

    private String id, name, dob;
    private LocalTime begin, finish;
    public static int cnt = 1;

    //Định dạng thời gian
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public VDV() {
    }

    public void Input(Scanner sc) {
        id = "VDV" + String.format("%02d", cnt++);
        name = sc.nextLine();
        dob = sc.nextLine();
        begin = LocalTime.parse(sc.nextLine());
        finish = LocalTime.parse(sc.nextLine());
    }

    public LocalTime getReal() {
        return finish.minusHours(begin.getHour()).minusMinutes(begin.getMinute()).minusSeconds(begin.getSecond());
    }

    public short getAge() {
        return (short) (2021 - Short.parseShort(dob.substring(6)));
    }

    public LocalTime getPrior() {
        if (getAge() < 18) {
            return LocalTime.of(0, 0, 0);
        } else if (getAge() < 25) {
            return LocalTime.of(0, 0, 1);
        } else if (getAge() < 32) {
            return LocalTime.of(0, 0, 2);
        } else {
            return LocalTime.of(0, 0, 3);
        }
    }

    public LocalTime getAchive() {
        return getReal().minusSeconds(getPrior().getSecond());
    }

    @Override
    public String toString() {
        return id + " " + name + " " + getReal().format(formatter) + " " + getPrior().format(formatter) + " "
                + getAchive().format(formatter);
    }

}

public class J05055_XepHangVanDongVien1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<VDV> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            VDV vdv = new VDV();
            vdv.Input(sc);
            a.add(vdv);
        }

        // Sắp xếp theo thứ tự thành tích đạt được
        List<VDV> listsx = new ArrayList<>(a);
        listsx.sort((x, y) -> x.getAchive().compareTo(y.getAchive()));

        // Xác định hạng của từng vận động viên
        Map<VDV, Integer> xepHang = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && listsx.get(i).getAchive().equals(listsx.get(i - 1).getAchive())) {
                xepHang.put(listsx.get(i), xepHang.get(listsx.get(i - 1)));
            } else {
                xepHang.put(listsx.get(i), rank);
            }
            rank++;
        }

        for (VDV i : a) {
            System.out.println(i + " " + xepHang.get(i));
        }
    }
}
