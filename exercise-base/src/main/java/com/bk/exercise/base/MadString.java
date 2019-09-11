package com.bk.exercise.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author BK
 * @description: 疯狂的String
 * @date 2019-08-28 19:13
 */
public class MadString {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        demo2();
    }

    /**
     * "美"==
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private static void demo3() throws NoSuchFieldException, IllegalAccessException {
        String operateA = "QWER";
        //private final char value[];

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        int base = unsafe.arrayBaseOffset(char[].class);
        int scale = unsafe.arrayIndexScale(char[].class);
        System.out.println(base);
        System.out.println(scale);
        Field valueFieldString = String.class.getDeclaredField("value");
        valueFieldString.setAccessible(true);
        char[] value = (char[]) valueFieldString.get(operateA);
        unsafe.putChar(value, base + 1 * scale, 'Q');
        unsafe.putChar(value, base + 2 * scale, 'Q');
        unsafe.putChar(value, base + 3 * scale, 'Q');
        String operateB = "QWER";
        System.out.println(operateA);
        System.out.println(operateB);
        System.out.println(operateA == operateB);
        System.out.println("QWER" == operateB);
        System.out.println("QQQQ" == operateA);
        System.out.println(operateA.equals("QQQQ"));
        System.out.println(operateA.equals("QWER"));
        System.out.println("QWER".equals("QQQQ"));
    }

    /**
     * 比如我们玩游戏时候经常用的QWER四个键，可以组合出不同的操作
     */
    private static void demo2() throws NoSuchFieldException, IllegalAccessException {
        //定义操作A QWER
        String operateA = "QWER";
        //获取字符串对象中存储字符的value字段  private final char value[];
        Field valueFieldString = String.class.getDeclaredField("value");
        valueFieldString.setAccessible(true);
        //获取value数组中的值 [Q,W,E,R]
        char[] value = (char[]) valueFieldString.get(operateA);
        //将value数组的值改为 [Q,Q,Q,Q]
        value[1] = 'Q';
        value[2] = 'Q';
        value[3] = 'Q';
        //定义操作B和操作A一样 QWER
        String operateB = "QWER";
        System.out.println("1.operateA :" + operateA);
        System.out.println("2.operateB :" + operateB);
        System.out.println("3.operateA == operateB :" + (operateA == operateB));
        System.out.println("4.\"QWER\" == operateB :" + ("QWER" == operateB));
        System.out.println("5.\"QQQQ\" == operateA : " + ("QQQQ" == operateA));
        System.out.println("6.operateA.equals(\"QQQQ\") : " + operateA.equals("QQQQ"));
        System.out.println("7.operateA.equals(\"QWER\") : " + operateA.equals("QWER"));
        System.out.println("8.\"QWER\".equals(\"QQQQ\") : " + "QWER".equals("QQQQ"));
    }

    /**
     * 一般奔溃
     */
    private static String B = "B";
    private static String K = "K";
    private static final String B1 = "B";
    private static final String K1 = "K";

    private static void demo1() {
        String s1 = "BK";
        String s2 = "BK";
        String emp = "";
        String s3 = "B" + "K";
        String s4 = "B" + emp + "K";
        String s5 = "B" + new String("K");
        s5=s5.intern();
        String s6 = new String("BK");
        String s7 = s6.intern();
        String s8 = "B";
        String s9 = "K";
        String s10 = s8 + s9;
        String s11 = B + K;
        String s12 = B1 + K1;
        System.out.println("1 : s1 == s2 : " + (s1 == s2));
        System.out.println("2 : s1 == s3 : " + (s1 == s3));
        System.out.println("3 : s1 == s4 : " + (s1 == s4));
        System.out.println("4 : s1.equals(s4): " + s1.equals(s4));
        System.out.println("5 : s1 == s5 : " + (s1 == s5));
        System.out.println("6 : s1 == s10 : " + (s1 == s10));
        System.out.println("7 : s5 == s6 : " + (s5 == s6));
        System.out.println("8 : s1 == s7 : " + (s1 == s7));
        System.out.println("9 : s1 == s11 : " + (s1 == s11));
        System.out.println("10: s1 == s12 : " + (s1 == s12));
    }
}
