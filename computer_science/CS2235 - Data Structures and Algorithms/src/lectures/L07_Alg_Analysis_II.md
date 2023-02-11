---
author:
- Isaac Griffith
title: Algorithm Analysis II
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

---
# Last Time
* We talked about the difference between experimental analysis and formal mathematical analysis.
* We found that algorithm "speed" can be conceptually viewed as counting the number of operations needed for execution.
* We discussed characterizing the relationship between input size and speed using a growth function.
* We looked at the cost of seven different growth functions and saw that there were significant differences in the long term cost of each one.

# Today
* We will talk about an idea for classifying different growth functions into categories.

* We will talk about a more efficient way of determining the growth function for algorithms.

* Examples.

# General Observations

1. Any growth function is in big-oh of its fastest growing component. (e.g. $\log n + n$ is in $O(n)$)

2. We can ignore constant values.

3. We want our bound as tight as possible. Clearly $2n$ is in $O(n^{120}), but that doesn't really help us as much as saying it is in $O(n)$.

# Revisit LinearSearch
We saw last time that LinearSearch takes at most $4n+3$ operations, making its running time in $O(n)$.

There is an easier way to see this though. All we have to do is identify blocks of constant time operations and count the number of times we do those. (boils down to counting loops).

```java
public static boolean linearSearch(int[] a, int val) {
    for (int i = 0; i < a.length; i++) {
        if (array[i] == val) {
            return true;
        }
    }
}
```

# Analysis Example 1
```java
public static void print(String[] names, String[] birthdays) {
    for (int i = 0; i < names.length; i++) {
        System.out.println(names[i]);
    }
    System.out.println();
    for (int i = 0; i < birthdays.length; i++) {
        System.out.println(birthdays[j]);
    }
}
```

# Analysis Example 1
```java
public static void print(String[] names, String[] birthdays) {
    for (int i = 0; i < names.length; i++) {
cn      System.out.println(names[i]);
    }
    System.out.println();
    for (int i = 0; i < birthdays.length; i++) {
        System.out.println(birthdays[j]);
    }
}
```

# Analysis Example 1
```java
public static void print(String[] names, String[] birthdays) {
    for (int i = 0; i < names.length; i++) {
cn      System.out.println(names[i]);
    }
n   System.out.println();
    for (int i = 0; i < birthdays.length; i++) {
        System.out.println(birthdays[j]);
    }
}
```

**What is the running time?**

# Analysis Example 1
```java
public static void print(String[] names, String[] birthdays) {
    for (int i = 0; i < names.length; i++) {
cn      System.out.println(names[i]);
    }
n   System.out.println();
    for (int i = 0; i < birthdays.length; i++) {
cn      System.out.println(birthdays[j]);
    }
}
```

**What is the running time?**

# Analysis Example 1
```java
public static void print(String[] names, String[] birthdays) {
    for (int i = 0; i < names.length; i++) {
cn      System.out.println(names[i]);
    }
n   System.out.println();
    for (int i = 0; i < birthdays.length; i++) {
cn      System.out.println(birthdays[j]);
    }
}
```

**What is the running time? $cn + c + cn = 2cn + 1$**

# Analysis Example 2
```java
public static void multTable(int max) {
    for (int i = 0; i <= max; i++) {
        for (int j = 0; j <= max; j++) {
            System.out.println(i * j);
        }
    }
}
```

**What is the running time?**

# Analysis Example 2

```java
public static void multTable(int max) {
    for (int i = 0; i <= max; i++) {
        for (int j = 0; j <= max; j++) {
cn          System.out.println(i * j);
        }
    }
}
```

**What is the running time?**

# Analysis Example 2

```java
public static void multTable(int max) {
cn  for (int i = 0; i <= max; i++) {
        for (int j = 0; j <= max; j++) {
cn          System.out.println(i * j);
        }
    }
}
```

**What is the running time?**

# Analysis Example 2

```java
public static void multTable(int max) {
cn  for (int i = 0; i <= max; i++) {
        for (int j = 0; j <= max; j++) {
cn          System.out.println(i * j);
        }
    }
}
```

**What is the running time? $cn(cn) = cn^2$ is in $O(n^2)$**

# Analysis Example 3


# BinarySearch

```java
public static boolean binarySearch(int[] a, int val) {
    return bSH(a, val, 0, a.length - 1);
}
public static boolean bSH(int[] a, int val, int low, int high) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (value == array[mid]) return true;
        else if (value < array[mid]) return bSH(array, value, low, mid - 1);
        else return bSH(array, value, mid + 1, high);
    }
}
```

# BinarySearch

```java
public static boolean binarySearch(int[] a, int val) {
    return bSH(a, val, 0, a.length - 1);
} // <-- constant time, so we will ignore it
public static boolean bSH(int[] a, int val, int low, int high) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (value == array[mid]) return true;
        else if (value < array[mid])
            return bSH(array, value, low, mid - 1);
        else return bSH(array, value, mid + 1, high);
    }
}
```

# BinarySearch

```java
public static boolean bSH(int[] a, int val, int low, int high) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (value == array[mid]) return true;
        else if (value < array[mid])
            return bSH(array, value, low, mid - 1);
        else return bSH(array, value, mid + 1, high);
    }
}
```

**What is the cost of running through bSH once, not including the recursive call?**

# BinarySearch

```java
public static boolean bSH(int[] a, int val, int low, int high) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (value == array[mid]) return true;
        else if (value < array[mid])
            return bSH(array, value, low, mid - 1);
        else return bSH(array, value, mid + 1, high);
    }
}
```

**What is the cost of running through bSH once, not including the recursive call? Constant**

# BinarySearch

```java
public static boolean bSH(int[] a, int val, int low, int high) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (value == array[mid]) return true;
        else if (value < array[mid])
            return bSH(array, value, low, mid - 1);
        else return bSH(array, value, mid + 1, high);
    }
}
```

**What is the worst case scenario?**

# BinarySearch

```java
public static boolean bSH(int[] a, int val, int low, int high) {
    if (low <= high) {
        int mid = (low + high) / 2;
        if (value == array[mid]) return true;
        else if (value < array[mid])
            return bSH(array, value, low, mid - 1);
        else return bSH(array, value, mid + 1, high);
    }
}
```

**What is the worst case scenario? If we have to go all the way until the low and high only denote one spot.**

# BinarySearch

Suppose `a.length = 64`, how many times will `bSH()` be called?
\pause
```
Iteration 1 will reduce the size from 64 to 32
Iteration 2 will reduce the size from 32 to 16
Iteration 3 will reduce the size from 16 to 8
Iteration 4 will reduce the size from 8 to 4
Iteration 5 will reduce the size from 4 to 2
Iteration 6 will reduce the size from 2 to 1
```
\pause
So, we need 6 iterations at most to complete the method. Also, $64 = 2^6$

# BinarySearch

Suppose `a.length = 64`, how many times will `bSH()` be called?

```
Iteration 1 will reduce the size from 64 to 32
Iteration 2 will reduce the size from 32 to 16
Iteration 3 will reduce the size from 16 to 8
Iteration 4 will reduce the size from 8 to 4
Iteration 5 will reduce the size from 4 to 2
Iteration 6 will reduce the size from 2 to 1
```

You can confirm that this holds in general, so $n = 2^k$ where $n$ is the size of the array and $k$ is the number of iterations needed to complete.

Thus, $k = \log n$ and the running time of Binary Search is $O(\log n)$

# For Next Time
