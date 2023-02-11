# Number Theory

1. Convert (1101 1001 0101 1011)_2 to octal and hexadecimal representations (#5 pg 325)

   Ans: (154,533)_8 
   Ans: (D95B)_16

2. Convert (7206)_8 and (A0EB)_16 to binary representation (#6 pg 325)

   Ans: (7206)_8 => (111 010 000 110)_2
   Ans: (A0EB)_16 => (1010 0000 1110 1011)_16

3. Use the Euclidean algorithm to find the gcd of 10,223 and 33,341 (#25 pg 326)

   Ans: 1

# Counting

1. Number of bit srings of length ten that either begin with 101 or end with 010 (#5 pg 462)

   Ans: 240

2. Use the generalized pigeon hole principle to show that among any 91 integers, there are at least ten that end with the same digit (#7.b pg 462)

3. How many ways are there to choose 6 items from 10 distinct itmes when (#1 pg 463)
   - the items in the coices are ordered and repetition is not allowed? 151,200
   - the items in the choices are ordereed and repetition is allowed? 1,000,000
   - the items in the choices are unordered and repetition is not allowed? 210
   - the items in the choices are unordered and repetition is allowed? 5005
   
4. Find n if (#23 from page 464)
   - C(n, 2) = 45 => n = 10
   - C(n, 5) = C(n, 2) => n = 8
   
5. How many cards must be chosen from a standard deck of 52 cards to guarantee that at least two of the four aces are chosen? (#15.a pg 464)

   Ans: 50
   
6. How many cards must be choosen from a standard deck of 52 cards to guarantee that there are at least two cards of each of two different kinds?

   Ans: 17

# Discrete Probability

1. What is the probability that six consecutive integers will be chosen as the winning numbers in a lottery where each number chosen is an integer between 1 and 40 (inclusive)? (#1 supplementary, pg 521)

   Ans: 1/109,668

2. What is the probability that a 13-card bridge hand contains seven spades and siz clubs? (#5.c page 522)

   Ans: 2,944,656/C(52,13)

# Relations

1. Find the reflexive, symmetric and transitive closures of the relation [(1,2), (2,3), (2,4), (3,1)] on the set {1, 2, 3, 4} (#8.d pg 667)

   Ans: (1,2), (2,1),
        (1,4), (4,1),
        (2,3), (3,2),
        (2,1), (1,2),
        (2,4), (4,2),
        (3,1), (1,3),
        (3,4), (4,3),
        (1,1), (2,2), (3,3), (4,4)

4. Answer these questions for the poset ({3,5,9,15,24,45}, |) (#33 pg 665)

   a.) Find the maximal elements? 24, 45
   b.) find the minimal elements? 3,5
   c.) Is there a greatest element? No
   d.) Is there a least element? No
   e.) Find all upper bounds of {3,5}? 15, 45
   f.) Find the least upper bound of {3,5}, if it exists? 15
   g.) Find the lower bounds of {15,45}? 15, 5, 3
   h.) Find the greatest lower bound of {15,45}, if it exists? 15
   
5. Find an ordereing of the tasks of a software project if the Hasse diagram for the tasks of the project is as shown: (#67 pg 665)

   Ans: Determine user needs < Write function requirements < Set up test sites < develop system requirements < Write documentation < Develop module A < Develop module B < Develop module C < Integrate modules < \alpha test < \beta test < Completion

# Graphs

1. Determine whether the following two graphs are isomorphic (#3 pg 773)

   Ans: Yes

  
5. Determine whether the given graph has a Hamilton circuit. (#31 pg 740)

   Ans: Hamilton Circuit: a, b, c, d, e, a

6. Find the length of the shortest path between a and z in the given weighted graph (#3 on pg 751)

   Ans: Length: 16, Path: a,c,d,e,g,z

# Trees

1. Given the the following expression tree for ((x - 3) + ((x / 4) + (x - y) * 3)). (#11.b and #11.c pg 842)

   a.) What is the pre-order traversal? 
   b.) What is the post-order traversal? 
   c.) What is the in-order traversal? ((x - 3) + ((x / 4) + (x - y) * 3))
   
2. Using Huffman coding algorithm find an optimal code for these symbols and frequencies: A: 0.2, B: 0.1, C: 0.3, D: 0.4 (#13 pg 842)

3. Find a minimum spanning tree of the following graphs (#44 pg 845)

   a) (b, c), (b, d), (b, a), (b, f), (f, e)
   b) (b, g), (g, d), (g, f), (b, c), (f, e), (a, b)

4. Answer these questions about the rooted tree illustrated (#3 pg 791)

   a) Which vertex is the root? a
   b) Which vertices are internal? a, b, c, d, f, h, j, q, t
   c) Which vertices are leaves? e, g, i, k, l, m, n, o, p, r, s, u
   d) Which vertices are children of j? q, r
   e) Which vertex is the parent of h? c
   f) Which vertices are siblings of o? p
   g) Which vertices are ancestors of m? f, b, a
   h) Which vertices are descendants of b? e, f, l, m, n
   i) height of this tree? 6
   j) size of this tree? 21
   k) Is this a full tree? No



