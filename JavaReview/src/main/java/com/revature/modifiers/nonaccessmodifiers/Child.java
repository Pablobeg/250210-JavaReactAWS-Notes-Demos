package com.revature.modifiers.nonaccessmodifiers;

// Pretend the child did not want to have any kids (sub classes) so it was marked with final
// A final class cannot be extended

public final class Child extends Parent{
    public Child(int age) {
        super(age);
    }

    // The child class has the ability to access the method cannotOverride() but it cannot override it
//    @Override
//    public void cannotOverride(){
//        // This doesn't work because the parent class marked the method as final
//    }
}
