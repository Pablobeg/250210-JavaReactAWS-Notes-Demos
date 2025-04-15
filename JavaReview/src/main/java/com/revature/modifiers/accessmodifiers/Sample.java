package com.revature.modifiers.accessmodifiers;

public class Sample {

    // Access modifiers can belong to all class members and the class itself
    public String A;
    protected String B;
    String C;
    private String D;

    public void someMethod(){
        this.A = "Public";
        this.B = "Protected";
        this.C = "Default";
        this.D = "Private";
    }
}
