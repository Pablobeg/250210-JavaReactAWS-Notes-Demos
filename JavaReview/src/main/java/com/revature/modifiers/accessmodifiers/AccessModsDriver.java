package com.revature.modifiers.accessmodifiers;

public class AccessModsDriver {

    /*
    What are access modifiers and what access modifiers are available?
    Access modifiers controls permission for accessing members or blocks of code
    Ordered from LEAST restrictive to MOST restrictive
        public - Available everywhere
        protected - Available within the same package and ALL subclasses (even those outside of the package)
        default - Available within the same package
        private - Available within the same class

     */

    public static void main(String[] args) {
        // I'm going to create a Sample object and attempt to access the fields
        Sample s = new Sample();
        s.A = "Public";
        s.B = "Protected";
        s.C = "Default";
//        s.D = "Private"; doesn't work because D is only available inside the sample Class
    }
}
