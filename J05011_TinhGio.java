import java.util.*;

class TinhGio{

    private String mnc, hoten, timeIn, timeOut;
    
    public TinhGio(){

    }

    public void Input(Scanner sc){
        mnc = sc.nextLine();
        hoten = sc.nextLine();
        timeIn = sc.nextLine();
        timeOut = sc.nextLine();
    }

    public int getPhut(){
        String[] tgvao = this.timeIn.split(":");
        String[] tgra = this.timeOut.split(":");

        int gvao = Integer.parseInt(tgvao[0]);
        int pvao = Integer.parseInt(tgvao[1]);
        int gra = Integer.parseInt(tgra[0]);
        int pra = Integer.parseInt(tgra[1]);

        int tg1 =  gvao*60 + pvao;
        int tg2 = gra*60 + pra;
        return tg2 - tg1;
    }

    public String getThoiGian(){
        int h = getPhut() /60;
        int p = getPhut() % 60;
        return h+" gio " + p + " phut"; 
    }

    @Override
    public String toString(){
        return mnc +" " + hoten + " " + getThoiGian();
    }
};

public class J05011_TinhGio {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<TinhGio> a = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            TinhGio tg = new TinhGio();
            tg.Input(sc);
            a.add(tg);
        }

        a.sort( new Comparator<TinhGio>(){
            public int compare(TinhGio x, TinhGio y){
                return y.getPhut() - x.getPhut();
            }
        });

        for(TinhGio i : a){
            System.out.println(i);
        }
    }
}
