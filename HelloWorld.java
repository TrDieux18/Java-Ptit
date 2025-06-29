// package CodeJ;
import java.util.Scanner;

public class HelloWorld {
	public static void main(String[]args) 
	{
		Scanner sc = new Scanner(System.in);
		// String name = sc.next();
		// int  tuoi = sc.nextInt();
		// System.out.println(name);
		// System.out.println(tuoi);
		System.out.println("Hello, World!");
		String s = sc.next();
		char c = sc.next().charAt(0);
		int ans = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == c){
				++ans;
			}
		}
		System.out.println(ans);
		// s.substring(0, 2);
		// s.toLowerCase();
		// s.toUpperCase();
		// s.indexOf(s1);
		// s.replace('0','e');

		sc.close();
	}
}