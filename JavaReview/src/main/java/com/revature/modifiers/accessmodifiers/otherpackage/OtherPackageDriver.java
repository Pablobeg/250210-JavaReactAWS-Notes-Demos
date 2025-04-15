package com.revature.modifiers.accessmodifiers.otherpackage;

import com.revature.modifiers.accessmodifiers.Sample;

public class OtherPackageDriver {

    public static void main(String[] args) {
        // This is another class inside a different package, let's see what we can access
        Sample s = new Sample();

        s.A = "Public";
        // s.B = "Protected"; doesn't work because this is not a subclass
        // s.C = "Default"; doesn't work because we are in a separate package
         // s.D = "Private"; doesn't work because D is only available inside the sample Class
    }
}
