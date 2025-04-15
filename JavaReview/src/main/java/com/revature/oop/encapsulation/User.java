package com.revature.oop.encapsulation;

public class User {

    private String email;

    private String password;

    private int age;

    public User(String email, String password, int age) {
        this.email = email;
        this.password = password;
        this.age = age;
    }

    // Getters
    // Methods that return the values from the instance fields
    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public int getAge(){
        return this.age;
    }

    // Setters
    // These are methods that set the value for the variable, we can control directly if they get updated or not

    public void setEmail(String email){
//        this.email = email;
        if (email.contains("@")){
            this.email = email;
            // this will only update if the email provided contains an @
        }
    }

    public void setAge(int age){
        if (age > 0){
            this.age = age;
            // This will only allow updates for correct ages
        }
    }

    public void setPassword(String password){
        if (password.length() < 8){
            return;
        }

        // We need to check if it contains an uppercase and a lowercase
        boolean hasLowercase = false;
        boolean hasUppercase = false;

        for (char c: password.toCharArray()){
            if (Character.isLowerCase(c)){
                hasLowercase = true;
            } else if (Character.isUpperCase(c)){
                hasUppercase = true;
            }
        }

        if (hasLowercase && hasUppercase){
            this.password = password;
        }
    }
}
