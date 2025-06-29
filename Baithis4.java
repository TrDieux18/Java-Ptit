/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodePTIT;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author pc
 */
public class Baithis4 {

    public static void main(String[] args) throws FileNotFoundException, NumberFormatException {

        Scanner sc = new Scanner(new File("E:\\Java\\CodeJava_NetBeans\\src\\CodePTIT\\DATA.in"));
        Set<BigInteger> ts = new TreeSet<>();

        while (sc.hasNext()) {
            String s = sc.next();
            BigInteger n = new BigInteger(s);
            ts.add(n);
        }

        BigInteger sum = BigInteger.ZERO;
        BigInteger mul = BigInteger.ONE;
        for (BigInteger i : ts) {
            sum = sum.add(i);
            mul = mul.multiply(i);
        }
        System.out.println(sum);
        System.out.println(mul);
    }
}
