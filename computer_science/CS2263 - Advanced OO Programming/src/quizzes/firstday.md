1. What will be the output of the following code?

```java
import java.util.Arrays;
import java.util.Comparator;

public class CompartorTest {
    public static void main(String args[])
    {
        String[] ar = {"c", "d", "b", "a", "e"};
        InnerClass in = new Innerclass();
        Arrays.parallelSort(ar, in);
        for (String str : ar)
            System.out.println(str + "");
        System.out.println(Arrays.binarySearch(ar, "b"));
    }
    
    static class InnerClass implements Comparator<String> {
        public int compare(String s1, String s2) {
            return s2.compareTo(s1);
        }
    }
}
```

a.) e
    d
    c
    a
    -1
    
b.) a
    b
    c
    0
    e
    d

c.) d
    b
    c
    e
    a
    1
    
d.) e
    b
    a
    d
    c
    
2. What will be the output of the following code?

```java
import java.util.LinkedHashSet;
import java.uitl.Set;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        Set s = new LInkedHashSet();
        s.add("1");
        s.add(1);
        s.add(3);
        s.add(2);
        System.out.println(2);
    }
}
```

a.) [1, 1, 2, 3]
b.) [1, 2, 2, 3]
c.) [1, 1, 3, 2]
d.) [1, 2, 3]

3. What will be the output of the following code?

```java
import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        m(list);
        
        public static void m(List<Number> list) {
            System.out.println(list);
        }
    }
}
```

a.) [2, 3]
b.) Runtime Exception
c.) Compile time Exception
d.) None of the above

4. What describes an algorithm performs in best, average or worst case scenarios?

a.) Big-B
b.) Big-O
c.) Big-Data
d.) Big-N

5. State the search time complexity of an ordered array.

a.) O(n)
b.) O(1)
c.) O(log n)
d.) O(n-1)

6. The benefits of Object Orientation are: (choose two)

a.) Inheritance
b.) Flexibility
c.) Maintainability
d.) Polymorphism

7. What is the output of the following code?

```java
class Hotel {

    public int bookings = 2;
    
    public void book() {
        bookings++;
    }
}

public class SuperHotel extends Hotel {
    public void book() {
        bookings--;
    }
    
    public void book(int size) {
        book();
        super.book();
        bookings += size;
    }
    
    public static void main(String args[]) {
        SuperHotel shotel = new SuperHotel();
        shotel.book(2);
        System.out.println(Shotel.bookings);
    }
}
```

a.) Compile error
b.) 2
c.) 4
d.) No Output

8. True or False: HAS-A relationships are based on inheritance.

a.) True
b.) False

9. How can we correct the given code? (choose two)

```java
import java.io.IOException;

class Example {
    public float Twin(float x, float y) throws IOException {
        return 0;
    }
}

class SubExample extends Example {
    float Twin(float x, float y) {
        return 0;
    }
}
```

a.) No need for correction
b.) By changing the method's argumetn name
c.) By removing overriden method's access specifier
d.) By adding access specifier "public" to the overriding method


10. In Java the actual method executed is determined by the type of the object and not the type of the reference.

a.) True
b.) False

11. The methods in class object are (choose 4)

a.) clone()
b.) notify()
c.) concat()
d.) wait()
e.) equals()
f.) compare()

12. Array of collections of superclass references can be used to access a mixture of superclass and subclass objects?

a.) True
b.) False

13. A class can **inherit** instance variables and methods from a more abstract **superclass**

a.) True
b.) False

14. At run-time, a Java program is nothing more than objects "talking" to _________.

a.) Other objects
b.) Other methods
c.) Other classes
d.) Other binders

15. If you do not have access to the source code for a class, but you want to change the way a method of that class works, then could you use subclassing to extend the "bad" class and override the method with your own better code?

a.) True
b.) False

16. A method defined in a superclass is redefined in a subclass with an identical method signature is called _____________.

a.) Method overloading
b.) Method overriding
c.) Dynamic binding
d.) Late binding

17. Interfaces are fast as it requres extra indirection to find corresponding methods in the actual class.

a.) True
b.) False

18. The inheriting class cannot override the definition of existing methods by providing its own implementation.

a.) True
b.) False

19.) The ability to make changes in your implementation code without breaking the code of others who use your code is a key benefit of ____________

a.) Extensibility
b.) Polymorphism
c.) Inheritance
d.) Encapsulation

20.) Every class in Java is a subclass of class ___________

a.) Inheritance
b.) Object
c.) Exception
d.) ArrayList

21.) What is an Object?

a.) An object is a class instance
b.) An object can have null reference
c.) An object can be an array
d.) If there is insufficient space to allocate new object an OutOfMemoryError will be thrown
e.) All

22.) Which statement(s) is true about the following program?

```java
public class Program {

    public static void main(String[] args) {
        String firstName = "Program";
        String lastName = "Simply";
        String FullName = firstName + lastName;
        String courseProvider = FullName;
    }
}
```

a.) The statement `courseProvider == FullName` will evaluate to `true`
b.) The statement `courseProvider.equals(FullName)` will evaluate to `true`
c.) The statement `courseProvider.equals(courseProvider == firstName + lastName)` will evaluate to `true`
d.) The statement `courseProvider.equals(courseProvider == firstName + lastName)` will evaluate to `false`
e.) Options a, b, and d

23.) What is a constructor?

a.) another name for an instance variable
b.) the return type of a method
c.) the method that creates an object, or instance, of the class
d.) the instantiation of an object

24.) What does it mean when a method is static?

a.) it modifies or mutates an object
b.) it applies to the entire class, not just one object or instance
c.) it is private
d.) it is overloaded

25.) What is the result of the following expression when `x` is `3583`? `(x / 10) % 10`

a.) 3
b.) 83
c.) 8
d.) 300

26.) `GradStudent` extends class `Student`. Which of these is **NOT** valid?

a.) `Student s = new Student()`
b.) `GradStudent g = new Student()`
c.) `Student s = new GradStudent()`
d.) `GradSTudent g = new GradStudent()`

27.) A precise step-by-step procedure that solves a problem or achieves a goal is ...

a.) a method
b.) a class
c.) an algorithm
d.) an interface

28.) _____________ means the method  has no return value

a.) void
b.) concatenation
c.) static
d.) string

29.) _____________ variable is avariable defined in a class

a.) reference
b.) modulous
c.) instance
d.) void

30.) The following code has class `ClassB` which inherits from `ClassA`, study the code carefully and the correct option about the output of the program.

```java
package edu.isu.cs2263;

class ClassA {
    public ClassA(int x) {
        this.x = x;
    } protected int x;
}

public class ClassB extends ClassA {
    public ClassB(int x, int x2, int y) {
        super(x);
        x = x2;
        this.y = y;
    } private ClassB(int x, int y) {
        super(x);
        this.x = x;
        this.y = y;
    }

    private int x;

    private int y;

    public static void main(String[] args) {
        ClassA a = new ClassA(10);

        ClassB b = new ClassB(20, 10);

        a = b;
        System.out.println(a.x + " " + b.y);
    }
}
```

a.) 10 10
b.) 10 20
c.) 20 20
d.) 20 10
e.) None

31. Which of the following is not part of OOP?

a.) Type checking
b.) Multitasking
c.) Polymorphism
d.) Information hiding

32. Can objects of an abstract class be instantiated?

a.) True
b.) False

33. The process by which one object can acquire the properties of another object:

a.) Encapsulation
b.) Inheritance
c.) Polymorphism

34. An object that has more than one form is referred to as:

a.) Inheritance
b.) Interface
c.) Abstract class
d.) Polymorphism

35. Information Hiding can also be termed as

a.) Data hiding
b.) Encapsulation
c.) Inheritance

36. Pick the term that relates to polymorphism

a.) Dynamic binding
b.) Dynamic allocation
c.) Static typing
d.) Static allocation

37. Two or more methods with the same name in the same class with different arguments are called:

a.) Method overriding
b.) Method overloading

38. The keywork which is used to access the method or member variables from the superclass:

a.) `super`
b.) `using`
c.) `is_a`
d.) `has_a`

39. An ____________ cannot provide any code at all, it can only provide method signatures

a.) Abstract class
b.) Interface

40. What modifiers are allowd for methods in an interface?

a.) `public`
b.) `private`
c.) `abstract`

41. Static methods cannot be accessed directly from the class level

a.) True
b.) False

42. An ____________ (or property) is a variable defined within a class to store a value.

43. _____________: "Hiding" properties and methods of a class from the "outside world" by making these private

a.) Encapsulation
b.) Polymorphism
c.) Inheritance
d.) Instantiation

44. A ____________ method or property can be accessed from outside the class

45. A ____________ method or property cannot be accessed from outside the class

46. A ____ class, also called child class or derived class, inherits the methods and attributes from its parent class.

47. ___________ class: also called parent class or base class

48. A ______________ is a public method used to retrieve the content of a private property

49. A ______________ is a public method used to set/overwrite the content of a private property

50. A ______________ is a function defined with a class to implement a behavior
