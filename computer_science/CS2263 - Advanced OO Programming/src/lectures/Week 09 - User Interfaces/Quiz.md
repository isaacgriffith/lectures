# Refactoring

1. What is the purpose of refactoring?

2. What do code smells tell us about our code?

# JavaDoc

2. Which JavaDoc annotation indicates that a method may throw an exception

# Style

3. Why do we style our code?

# Lombok

4. What is the purpose of Project Lombok?

5. What does the lombok `@Data` annotation do?

# Inheritance

6. Which of the following is typically a good use of inheritance?

- Using a subclass to restrict the behavior of the superclass
- Using a subclass to hide features of the superclass
- ^ Using subclasses to partition objects of the superclass
- ^ Using subclasses to increase the functionality of the superclass

7. Why might deep hierarchies be a bad idea?

- They allow for a very nuanced and specialized set of subclasses
- ^ Increases logical and psychological complexity
- Violates the OCP
- Violates the LSP

8. Which of the following is not an attitude towards cloning that a class may take?

- Fully supporting cloning
- Does not support cloning
- ^ Publicly supports cloning but does not allow subclasses to support cloning
- Conditionally support cloning

9. Each of the factory patterns (Simple Factory, Factory Method, and Abstract Factory) each provide a means by which both the DIP and SDP can be realized in our system.

- ^ True
- False

10. The purpose of the Visitor Pattern is to support a volatile element hierarchy by allowing the addition of new operations without modifying the elements themselves.

- True
- ^ False

# Defensive Coding

11. Which of the following is not a benefit of exception handling over other error handling approaches

- Return values are not tied up
- Does not require extra parameters
- ^ Error handling code is mixed in with normal code
- You can't ignore exceptions

12. If we do not encapsulate our fields, then we open our system up to the potential for corruption.

- ^ True
- False

13. An invariant is an assumption about the types of input that a method takes in.

- True
- ^ False

14. Assertions and Cofoja are both Design by Contract approaches

- ^ True
- False

15. If I have full control over the code calling a method I should

- ^ Use assertions or DbC methods to validate the parameters
- Use exception handling to handle inappropriate input
- I should use both assertions and exception handling
- I should use nither assertions or exception handling
