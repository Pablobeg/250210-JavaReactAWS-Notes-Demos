package com.revature.modifiers.accessmodifiers.otherpackage;

import com.revature.modifiers.accessmodifiers.Sample;

public class OtherPackageSubclass extends Sample {

    // Notice this is a Subclass of sample inside a DIFFERENT package

    public void someMethod(){
        this.A = "Public";
        this.B = "Protected"; // This DOES WORK because we're in a subclass even though it's a diff package
        // this.C = "Default";  doesn't work because in a different package
        // this.D = "Private"; doesn't work because D is only available inside the sample Class
    }
}
