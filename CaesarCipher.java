import java.util.Random;
import java.util.Scanner;

public class CaesarCipher {

    public static String encrypt(String text, int[] shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shiftValue = shift[i % shift.length];

                char encryptedChar = (char) ((c - base + shiftValue) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int[] shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                int shiftValue = shift[i % shift.length];

                char decryptedChar = (char) ((c - base - shiftValue + 26) % 26 + base);
                result.append(decryptedChar);
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String s = sc.nextLine();
        int[] shift = { random.nextInt(26), random.nextInt(26), random.nextInt(26) };
        System.out.println("Shift values: " + shift[0] + ", " + shift[1] + ", " + shift[2]);

        String encrypted = encrypt(s, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("Chuoi goc: " + s);
        System.out.println("Đa ma hoa: " + encrypted);
        System.out.println("Đa giai ma: " + decrypted);

        sc.close();
    }
}
