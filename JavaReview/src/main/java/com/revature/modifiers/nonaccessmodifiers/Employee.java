package com.revature.modifiers.nonaccessmodifiers;

public class Employee {

    // Imagine this class is used to create new Employees for our db or application or whatever
    int empId;

    String name;

    // If I want to keep track of the current id that I can use for my employeess I need a value that is SHARED
    // across all instances of my employees
    // SOLUTION: USE A STATIC VARIABLE
    private static int empIdCounter = 1;

    // ALL EMPLOYEES WORK FOR THE SAME COMPANY SO THE NAME IS STATIC MEANING IT BELONGS TO THE CLASS
    static String companyName = "Revature";

    public Employee(String name){
        this.name=name;
        this.empId = empIdCounter++;
    }

    // Instance method
    public void introduceCompany(){
        System.out.println("My name is " + this.name + " and I work for " + companyName);
    }

    // Instance methods and variables can access the static members of their classes which no issues
    // Static members can only call on other static members
    public static void setCompanyName(String name){
        // This method is static meaning it should be called as Employee.setCompanyName(name)
        // This method is STATIC so it can access static members
        companyName = name;
        // BUT WE CANNOT ACCESS INSTANCE MEMBERS
//        this.name = name;

        // WHY?
        // Because a static method and static variable exist once the class is created but they do not need an instance
        // to run
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                '}';
    }
}
