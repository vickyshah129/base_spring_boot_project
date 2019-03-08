package com.project.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class RandomNumeric {

    private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
        for (char ch = '0'; ch <= '9'; ++ch)
            tmp.append(ch);
	   /* for (char ch = 'a'; ch <= 'z'; ++ch)
	      tmp.append(ch);
	    for (char ch = 'A'; ch <= 'Z'; ++ch)
		      tmp.append(ch);*/
        symbols = tmp.toString().toCharArray();
    }

    private final Random random = new Random();

    private final char[] buf;

    public RandomNumeric(int length) {
        if (length < 1)
            throw new IllegalArgumentException("length < 1: " + length);
        buf = new char[length];
    }

    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static void main(String[] args) {
        RandomNumeric randomString = new RandomNumeric(8);
        Set<String> strings = new HashSet<>();
        String randomStr;
        for (int i = 0; i < 100; i++){
            randomStr = randomString.nextString();
            if(!strings.add(randomStr)){
                System.out.println("Duplicate==>"+randomStr);
            }else{

                System.out.println(i+" = "+randomStr);
            }
        }

    }

}
