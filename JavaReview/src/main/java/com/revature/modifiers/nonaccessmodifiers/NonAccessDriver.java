package com.revature.modifiers.nonaccessmodifiers;

public class NonAccessDriver {

    /*
    Non Access Modifiers?
    What are they and what examples do we have?
    All modifiers that do not directly affect access are non-access modifiers
    - static
        - Brings things to the class scope
        - Applicable to methods and variables
    - final
        - Used to denote the end of some chain or a constant value
        - Applicable to variables, methods, and classes
    - abstract
        - Used to delay implementation or instantiation
        - Applicable to classes and methods
     */

    public static void main(String[] args) {
        // Goal for right now is to set up the employee id automatically
        Employee e1 = new Employee("John");
        Employee e2 = new Employee("Jane");
        Employee e3 = new Employee("Robert");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        // We can directly access the value from the static variable by using the class
//        System.out.println(Employee.empIdCounter);
        Employee e4 = new Employee("Jim");
        System.out.println(e4);

        System.out.println("-------------------------");
//        System.out.println(e1.empIdCounter);
//        System.out.println(e2.empIdCounter);
//        System.out.println(e3.empIdCounter);
//        System.out.println(e4.empIdCounter);
        e1.introduceCompany();
        e2.introduceCompany();
        e3.introduceCompany();
        e4.introduceCompany();

        // If I update the value for the company name it should change it for EVERY object
        Employee.companyName = "Infosys";

        e1.introduceCompany();
        e2.introduceCompany();
        e3.introduceCompany();
        e4.introduceCompany();

        // I can call static methods without ANY instances
        Employee.setCompanyName("Multivision llc");

    }
}
