package com.bk.exercise.base;

/**
 * @author BK
 * @description:
 * @date 2019-08-19 00:52
 */
public class OverLoadTest {
    static abstract class Fruit{
    }
    static class Apple extends Fruit{
    }
    static class Banana extends Fruit{
    }
    public void eat (Fruit fruit){
        System.out.println("eat fruit .");
    }
    public void eat (Apple fruit){
        System.out.println("eat apple .");
    }
    public void eat (Banana fruit){
        System.out.println("eat banana .");
    }

    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        OverLoadTest test = new OverLoadTest();
        test.eat(apple);
        test.eat(banana);
    }
}
