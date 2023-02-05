1. Use laws of boolean algebra to show that if the premises ∀x(P(x) → Q(x)), ∀x(Q(x) → R(x)), and ¬R(a), where a is in the domain, are true, then the conclusion ¬P(a) is true.

   1. P(a) → Q(a)   {7.3}
   2. Q(a) → R(a)   {7.3}
   3. P(a) → R(a)   {implication chain}
   4. ¬P(a)         {Modus Tollens}

2. Let E denote the set of even integers and O denote the
set of odd integers. As usual, let Z denote the set of all
integers. Determine each of these sets.
a) E ∪ O
b) E ∩ O
c) Z − E
d) Z − O

3. Let A and B be sets in a finite universal set U. List the
following in order of increasing size.
a) |A|, |A ∪ B|, |A ∩ B|, |U|, |∅|

4. Let f and g be functions from {1, 2, 3, 4} to {a, b, c, d}
and from {a, b, c, d} to {1, 2, 3, 4}, respectively, with
f (1) = d, f (2) = c, f (3) = a, and f (4) = b, and g(a) = 2,
g(b) = 1, g(c) = 3, and g(d) = 2.
a) Is f one-to-one? Is g one-to-one?
b) Is f onto? Is g onto?
c) Does either f or g have an inverse? If so, find this in-
verse.

5. When is the empty set in the power set of a set S?

6. Conjecture a formula for the terms of the sequence that
begins 8, 14, 32, 86, 248 and find the next three terms of
your sequence.

7. Let f(n) be the function from the set of integers to the
set of integers such that f(n) = n^2 + 1. What are the
domain, codomain, and range of this function?

8. Show in at least using a truth table that the com-
pound propositions ¬p ∨ (r → ¬q) and ¬p ∨ ¬q ∨ ¬r
are equivalent.

9. Use rules of inference to show that if the premises “All
zebras have stripes” and “Mark is a zebra” are true, then
the conclusion “Mark has stripes” is true.

10. Determine which characteristics of an algorithm de-
scribed in the text (after Algorithm 1) the following pro-
cedures have and which they lack.
a) procedure double(n: positive integer)
   while n > 0
     n := 2n

11. Devise an algorithm that finds the sum of all the integers
in a list.

12. Describe a recursive algorithm for computing the sum
of n numbers in a sequence.

13. a) For which positive integers n is 11n + 17 ≤ 2^n ?
    b) Prove the conjecture you made in part (a) using math-
ematical induction.

14. The set B of all balanced strings of parentheses is defined
recursively by 𝜆 ∈ B, where 𝜆 is the empty string; (x) ∈ B,
xy ∈ B if x, y ∈ B.

    a.) Find all balanced strings of parentheses of length four or less.

    b.) Use induction to show that if x is a balanced string of
parentheses, then the number of left parentheses equals
the number of right parentheses in x.

15. Given an example (A ∪ C) ∩ (B ∪ C) = ∅
 - When C = ∅, and A and B are disjoint

<!--16. In Haskell, if you print the elements of [(a,b) | a <- [0..], b <- [0..]],
    would you ever see the element (1,2)?-->

17. What set is given by the following definition?

The set S is defined as follows:
1. 1 ∈ S
2. n ∈ S → n - n ∈ S
3. Nothing is in S unless it can be shown to be in S by a finite number of uses of the previous rules
