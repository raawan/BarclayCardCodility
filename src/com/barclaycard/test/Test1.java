package com.barclaycard.test;

public class Test1 {

    public static void main(String[] args) {

        System.out.println(solution(11111, 1111));

       /* int count = solution(99999999,99999999);
        System.out.println("count==>" + count);*/

    }

    public static int solution(int A, int B) {

        String binaryRepre = Integer.toBinaryString(A * B);
        System.out.println("String result ==>" + binaryRepre);
        return (int) binaryRepre.chars().peek(c -> System.out.println("after chars =>" + c)).
                mapToObj(c -> (char) c).peek(c -> System.out.println("after maptoobj =>" + c)).
                filter(c -> c == '1').peek(c -> System.out.println("after filter =>" + c)).
                count();
        //  return (int)binaryRepre.chars().mapToLong(c -> c).filter(c->c==1).count();//R
    }
}
