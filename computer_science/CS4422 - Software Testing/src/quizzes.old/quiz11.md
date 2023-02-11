Password: 5301

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

1. (3 pts.) Draw the **control flow graph** for the above method. Treat the two method calls as simple statements, that is, you do not need their CFGs or source. To simplify grading, use the line numbers for node numbers. For example, the node that represents the "*return*" statement should be node 14. You will **not** need all the numbers.





2. Answer the questions below for this graph:

  a. (5 pts.) Label the following paths as either a test path (T), a prime path (P), both (B), or neither (N).


    1. __ [1, 3, 5, 8]

    2. __ [1, 3, 4, 7, 4, 8]

    3. __ [7, 4, 8]

    4. __ [4, 7, 4, 8]

    5. __ [2, 3, 6, 9]


  b. (2 pts.) Write the edge-pair coverage requirements for this graph.
