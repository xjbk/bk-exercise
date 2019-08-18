package com.bk.exercise.base;

/**
 * @author BK
 * @description:
 * @date 2019-08-19 01:16
 */
public class OverRide {
    static abstract class Fruit{
        public abstract void eat ();
    }
    static class Apple extends Fruit {
        public void eat() {
            System.out.println("eat apple .");
        }
    }
    static class Banana extends Fruit {
        public void eat() {
            System.out.println("eat banana .");
        }
    }
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        apple.eat();
        banana.eat();
    }
}
