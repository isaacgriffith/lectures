* Label the following statements about **error state** as being either **True** or **False**.

  - Debugging can be described as finding the first error state  (c) True
  - Error states are visible to end-users  (c) False
  - If the program never reaches a faulty statement, an error state cannot be created (c) True
  - Programmers can use print statements to find error states  (c) True
  

* You have been hired to taste-test in a Skittles factory. (Skittles are fruit-flavored candy.) The factory produces several types of Skittles: **Cherry (red), Lemon (yellow), Lime (green), Green Apple (green), Strawberry (red), Berry punch (violet)**, and **Raspberry (blue)**.

  - If your coverage criterion says to taste each Skittle **flavor** how many test requirements do you have?  (c) 7
  - If your coverage criterion says to taste each Skittle **color** how many test requirements do you have?  (c) 5
  - Which of the following is correct?
    
    (c) The **flavor criterion** subsumes the **color criterion**
    (n) Neither subsumes the other
    (n) The **color criterion** subsumes the **flavor criterion**
    
  - If you can't find any green colored Skittles, this is a ________ problem.
  
    (c) Observability
    (n) Controllability
    
  - If you can't find any yellow color Skittles, what is the maximum coverage level you can achieve for the **color criterion**? Note answer using percentage.  (c) 80 %
    
* Answer the following about test criteria with either a **True** or **False**. An **advantage** of criteria-based test design is:

  - ... we have an engineering rule for when we are finished testing  (c) True
  - ... it makes it easy to establish traceability from software artifacts to tests.  (c) True

* Answer the following questions for the graph:

  ```
  N = {1, 2, 3, 4, 5, 6, 7}
  N0 = {1, 2}
  Nf = {6, 7}
  E = {(1, 3), (2, 3), (3, 4), (3, 5), (4, 3), (4, 6), (5, 3), (5, 7)}
  ```
  
  - is **[1, 3, 4, 3, 5, 3]** a test path?  (c) False
  - is **[1, 3, 4, 3, 5, 7]** a test path?  (c) True
  - is **[1, 3, 4, 6, 3, 5, 7]** a test path?  (c) False
  - Which of the following is the complete list of test requirements for EPC given the graph described?
   
    (c) {[1, 3, 4], [2, 3, 4], [1, 3, 5], [2, 3, 5], [3, 4, 3], [3, 5, 3], [3, 4, 6], [3, 5, 7], [4, 3, 4], [4, 3, 5], [5, 3, 5], [5, 3, 4]}
    (n) {[1, 3, 4], [2, 3, 4], [1, 3, 5], [2, 3, 5], [3, 4, 3], [3, 5, 3], [3, 4, 6], [3, 5, 7], [4, 3, 4], [5, 3, 5]}
    (n) {(1, 3), (2, 3), (3, 4), (3, 5), (4, 3), (4, 6), (5, 3), (5, 7)}
    
  - Which of the following is a list of the complete test requirements for PPC
  
    (c) {[1, 3, 4, 6], [1, 3, 5, 7], [2, 3, 4, 6], [2, 3, 5, 7], [4, 3, 5, 7], [5, 3, 4, 6], [3, 4, 3], [3, 5, 3], [4, 3, 4], [5, 3, 5]}
    (n) {[1, 3, 4, 6], [1, 3, 5, 7], [2, 3, 4, 6], [2, 3, 5, 7], [4, 3, 5, 7], [5, 3, 4, 6]}
    (n) Neither
    
  - Does the following set of test paths, T, cover all of the test requirements for both EPC and PPC (without sidetrips or detours)?
  
    `T = {[1,3,4,3,4,6], [2,3,5,3,5,7], [2,3,4,3,4,3,5,7], [1,3,5,3,4,6]}`
    
    (n) True
    (c) False
  
  - Does the following set of test paths, T, cover all of the test requirements for both EPC and PPC if we include sidetrips and detours?

    `T = {[1,3,4,3,4,6], [2,3,5,3,5,7], [2,3,4,3,4,3,5,7], [1,3,5,3,4,6]}`
    
    (n) True
    (c) False
    
* Answer the following questions for the graph:

  ```
  N = {1, 2, 3, 4, 5, 6, 7, 8, 9}
  N0 = {1, 2}
  Nf = {8, 9}
  E = {(1, 3), (2, 3), (3, 4), (3, 5), (3, 6), (4, 7), (4, 8), (5, 8), (6, 9), (7, 4)}
  ```
  
  Label the following paths as either a **test path**, a **prime path**, **both**, or **neither**
  
  - Path `[1, 3, 5, 8]`  (c) Both
  - Path `[1, 3, 4, 7, 4, 8]`  (c) Test Path
  - Path `[7, 4, 8]`  (c) Prime Path
  - Path `[4, 7, 4, 8]`  (c) Neither
  - Path `[2, 3, 6, 9]`  (c) Both
  - Write the edge-pair coverage requirements for this graph.
  
* Draw the control flow graph for the following method. Treat the two method calls as simple statements, that is, you do not need their CFGs or source. To simplify grading, use the line numbers for node numbers. For example, the node that represents the "return" statement should be node 14. You will not need all the numbers. Attach your drawing as an image (PNG, JPG, BMP, or SVG)

```java
1. private static int isSpecial(int M)
2. {
3.    int sum = 0;
4.    for(int i=2; i < M; i++){
5.       if (M%i == 0)
6.          sum = sum + i;
7.       if (i >= M/2)
8.          break;
9.    }
10.    if(sum > M)
11.       setAbundant(M, true);
12.    if (sum == 0)
13.       setPrime(M, true);
14.    return sum;
15. }  // end isSpecial()
```

For the logic predicate p = ((A ∨ B) ∧ C), give truth assignments that:

a.) Compute the value of p for each truth assignment in the table. Then mark a pair (two!) truth assignments that:
b.) Satisfy clause coverage but not predicate coverage
c.) Satisfy predicate coverage but not clause coverage
Give your answers by writing into the table below. For parts (b) and (c) you will mark two and only two cells under CC and two under PC.


 Q	 A	 B	 C	 P	 CC	 PC
 	 	 	 	 	 !(PC) 	 !(CC) 
 1.	 T	 T	 T	 T 		
 2.	 T	 T	 F	 F		
 3.	 T	 F	 T	 T		
 4. 	 T	 F	 F	 F		
 5. 	 F	 T	 T	 T		
 6. 	 F	 T	 F	 F		
 7.	 F	 F 	 T	 F		
 8.	 F	 F	 F	 F		
