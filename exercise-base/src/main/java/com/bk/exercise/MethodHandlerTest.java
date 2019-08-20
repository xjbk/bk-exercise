package com.bk.exercise;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
/**
 * @author BK
 * @description:
 * @date 2019-08-19 22:34
 */
public class MethodHandlerTest {
    static class Person{
        public void sing(String songName){
            System.out.println("I'm sing " + songName);
        }
    }
    /**
     * 实现调用Person类的sing方法
     * @param args
     */
    public static void main(String[] args) throws Throwable {
        Person zhangsan = new Person();
        // void.class是方法返回的类型    String.class 是方法的入参类型
        MethodType mt = MethodType.methodType(void.class,String.class);
        MethodHandle handler = MethodHandles.lookup()
                //找到zhangsan对象中签名和mt指定的签名是一致的sing方法
                .findVirtual(zhangsan.getClass(), "sing", mt)
                //非静态方法的第一个参数隐藏的this指针，这步相当设置第一个参数this指针
                .bindTo(zhangsan);
        handler.invokeExact("Summer train ");
    }
}
