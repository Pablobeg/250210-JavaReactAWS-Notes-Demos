package com.revature.oop.inheritance;

public class Child extends Parent{

    // Since this class extends the parent class we have access to the fields and methods from that class
    public void anotherMethod(){
        this.field1 = "Field 1";
        this.field2 = 1;

        someMethod();
    }
}
