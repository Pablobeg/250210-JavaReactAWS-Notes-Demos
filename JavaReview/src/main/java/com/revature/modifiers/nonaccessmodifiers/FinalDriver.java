package com.revature.modifiers.nonaccessmodifiers;

public class FinalDriver {

    public static void main(String[] args) {
        Parent p1 = new Parent(42);

        // We can access the final variable just like normal
        System.out.println(p1.age);
        // But we cannot update the value
//        p1.age = 43;
        // This doesn't work because age is final, making it a constant
    }

}
