package com.barclaycard.test;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {

    private static String s;

    public static void main(String[] args) {

        s = "011100111111";
        System.out.println("1=>" + solution(s));
        System.out.println("2=>" + solution2(s));
        System.out.println("3=>" + solution3(s));
        System.out.println("4=>" + solution4(s));

        s = "11110";
        System.out.println("1=>" + solution(s));
        System.out.println("2=>" + solution2(s));
        System.out.println("3=>" + solution3(s));
        System.out.println("4=>" + solution4(s));

        s = "01001";
        System.out.println("1=>" + solution(s));
        System.out.println("2=>" + solution2(s));
        System.out.println("3=>" + solution3(s));
        System.out.println("4=>" + solution4(s));
    }

    public static int solution(String s) {
        int val = Integer.parseInt(s, 2);
        System.out.println("orig val=" + val);
        int count = 0;
        while (val != 0) {
            if (val % 2 != 0) {
                val = val - 1;
                count++;
            } else {
                count++;
                val = val >>> 1;
            }
        }
        return count;
    }

    /*
    Assuming the string starts with 0
     */
    public static int solution2(String s) {
        int total1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                total1++;
            }
        }
        return ((total1 - 1) * 2) + (s.length() - total1);
    }

    /*
   Assuming the string starts with 0
   with lambda reference
    */
    public static long solution3(String s) {

        Function<Long, Long> calFinal = total -> ((total - 1) * 2) + (s.length() - total);
        return (long) s.chars().mapToObj(c -> (char) c)
                .filter(c -> c == '1')
                .collect(Collectors.collectingAndThen(Collectors.counting(), calFinal));
    }

    /*
     Assuming the string starts with 0
     With method reference
  */
    public static long solution4(String s) {

        Function<Long, Long> calFinal = Test2::getFinalTotal;
        return (long) s.chars().mapToObj(c -> (char) c)
                .filter(c -> c == '1')
                .collect(Collectors.collectingAndThen(Collectors.counting(), calFinal));
    }

    private static long getFinalTotal(long total) {
        return ((total - 1) * 2) + (s.length() - total);
    }

}

