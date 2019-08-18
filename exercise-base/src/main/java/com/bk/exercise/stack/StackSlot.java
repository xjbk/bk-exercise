package com.bk.exercise.stack;
/**
 * @author BK
 * @description: 栈变量槽
 * 启动参数 ： -Xms20M -Xmx20M -verbose:gc -server
 * @date 2019-08-18 23:22
 */
public class StackSlot {
    public static void main(String[] args) {
        byte[] byteArrays = new byte[5 * 1024 * 1024];
        byteArrays = null ;
        System.gc();
    }
}
