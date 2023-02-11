Password: 9219

1. (5pts) Use one of the following terms to fill in each blank below. If in doubt, use the **closest matching** term.

+-----------------+----------------+
| Availability    | Scalability    |
+:===============:+:==============:+
| Maintainability | Security       |
+-----------------+----------------+
| Performance     | Time-to-Market |
+-----------------+----------------+
| Reliability     | Usability      |
+-----------------+----------------+

   1. ________________ of software is less important than in the past.
   2. This course focuses on increasing ___________ and ____________.
   3. ________________ means the software can be run anytime from anywhere.
   4. ________________ refers to the ability to add more users.

2. (5 pts.)  Consider the following java method

```java
   private boolean isValid(int X, int Y) {
       if (X * Y > 25) // Should be X + Y
           return true;
       else
           return false;
   }
```

A test for this method has two integer values, one for X and one for Y. Suppose the fault is that the multiplication operator should have been addition.

1. Give a test that causes the fault to result in a failure.


2. Give a test that **does not** cause the fault to result in a failure.
