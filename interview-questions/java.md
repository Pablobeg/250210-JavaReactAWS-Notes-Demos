# QC Questions that may be asked on the Quality Audit

## Java Basics
* What is Java? / Why Java?
 
* What is JRE / JDK / JVM?
  
* What is an object / class?
 
* What is the root class from which every class extends?

* What are the primitive data types in Java?
 
* Where are Strings stored?
  
* Explain stack vs heap?
  
* What are annotations?
  
* How can you force garbage collection in Java?
  
* Why are strings immutable in java?
  
* What is the difference between `String`, `StringBuilder`, and `StringBuffer`?
  
* What are the access modifiers in Java? Explain them.
  
* What are the non-access modifiers in Java?
 
* What is the difference between `static` and `final` variables?
  
* What are the default values for all data types in Java?
  
* What is a wrapper class?
  
* What is autoboxing / unboxing?
  
* If two objects are equal, do they have the same hashcode? If not equal?

* What data types are supported in switch statements?
  
* Can we access static/non-static variables from static/non-static methods (see example)?
```java
public class A {
  public static int x = 1;
  public int y = 2;

  public static void doStuff() {
    System.out.println(y);
  }

  public void doMoreStuff() {
    System.out.println(x);
  }
}
```
<br>
  
* What methods are available in the Object class?
  
* What is the difference between `==` and `.equals()`?
 
* What is an enhanced for loop?
 
  
  <br>
  
## OOP
* What are the 4 pillars of OOP / Explain each?
 
* Is this allowed? Is this an example of method overloading or overriding?

```java
public abstract class Super {
  public abstract Collection getCollection();
}

public abstract class Sub extends Super {
  public abstract List getCollection();
}
```

* What is the difference between an abstract class and an interface?
  
* What are the implicit modifiers for interface variables?
  
* What is the difference between method overloading and overriding?
  
* Can you overload / override a main method? static method? a private method? a default method? a protected method?
  
* Difference between extends and implements?
  
* What are enumerations (enums)?
 
* First line of constructor?
  
* Can you instantiate this class? Why or why not?

```java
public class Hello {}
```

<br>

## Collections / Generics
* What are collections in Java?

* What are the interfaces in the Collections API?
  
* What is the difference between a `Set` and a `List`?
  
* What is the difference between a `Array` and an `ArrayList`?
  
* What is the difference between HashTable and HashMap?
  
* Are Maps in the Collections API?
  
* What happens here?
```java
List<String> mylist = new ArrayList<>();
mylist.add("hello");
mylist.add(new Person()); // what happens?
```

* What are generics? What is the diamond operator (`<>`)?


<br>

## Exceptions
* What is the difference between `final`, `.finalize()`, and `finally`?

* `throw` vs `throws` vs `Throwable`? 

* Do you need a catch block? Can have more than 1? Order of them?

* What is base class of all exceptions?
  
* List some checked and unchecked exceptions?

* Is this an example of a checked or unchecked exception?

```java
public class MyException extends RuntimeException {}
```

<br>

## Threads
1. What is multi-threading?
    
2. In what ways can you create a thread?
  

3. Lifecycle of a thread
    
4. What is deadlock?
    

5. What is synchronized keyword?
    

6. Explain the [Producer/Consumer Problem](https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/).

7. What does `.wait()` do to a thread? `.notify()`? [Resource](https://www.baeldung.com/java-wait-notify)

<br>

## Advanced Java
- What are lambdas and why are they useful in Java?

- What is a **functional interface**? Name a few included in the JRE:

- What is the difference between the `Comparator` and `Comparable` Interface?
  

## Reflection
- What is Reflection? What package does it come from in the JRE?

- What is Introspection?

## REST: Representational State Transfer
- What is [REST](https://www.codecademy.com/articles/what-is-rest)?

REST, or REpresentational State Transfer, is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other. REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server.

- What makes an API RESTful?
  - *i.e **What are the 6 constraints of REST?***
  - Uniform Interface
  - Client-Server
  - Stateless
  - Cacheable
  - Layered System
  - Code on Demand (Optional)

- What is the [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)?

A model (developed by Leonard Richardson) that breaks down the principal elements of a REST approach into three steps. These introduce resources, http verbs, and hypermedia controls.

<br>



  