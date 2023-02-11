---
author:
- Dr. Isaac Griffith
title: Graph Coverage in Practice
course: CS 3321
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand how to apply graph testing in Practice
::::
:::: {.column width=.25}
\vfill
\vspace{7.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# The Steps

1. Pick a coverage criterion and review the code
2. Using a tool to read and analyze the code
3. Generate the CFG
4. Number the CFG (optional)
5. Identify test paths
6. Design Test Cases
7. Create Tests
8. Verify

# Step 1 - Criterion Selection

* We will analyze a piece of code from the book
  - Language: Java
  - Size: 59 LOC
  - NOM: 2

* The Graph Coverage Criteria will be EPC
  - for ease of analysis

# Step 2 - The Code

\tiny
```java
public class PatternIndex
{

   public static void main (String[] argv)
   {
      if (argv.length != 2)
      {
         System.out.println
            ("java PatternIndex Subject Pattern");
         return;
      }
      String subject = argv[0];
      String pattern = argv[1];
      int n = 0;
      if ((n = patternIndex (subject, pattern)) == -1)
         System.out.println
         ("Pattern string is not a substring of the subject string");
      else
         System.out.println
         ("Pattern string begins at character " + n);
   }
```

# Step 2 - The Code

::: columns
:::: column

\tiny
```java
    /**
     * Find index of pattern in subject string
     *
     * @param subject String to search
     * @param pattern String to find
     * @return index (zero-based) of first occurrence of pattern
     *         in subject; -1 if not found
     * @throws NullPointerException if subject or pattern is null
     */
    public static int patternIndex (String subject, String pattern)
    {
       final int NOTFOUND = -1;
       int  iSub = 0, rtnIndex = NOTFOUND;
       boolean isPat  = false;
       int subjectLen = subject.length();
       int patternLen = pattern.length();

       while (isPat == false && iSub + patternLen - 1 < subjectLen)
       {
          if (subject.charAt(iSub) == pattern.charAt(0))
          {
             rtnIndex = iSub; // Starting at zero
             isPat = true;
```

::::
:::: column

\tiny
```java

             for (int iPat = 1; iPat < patternLen; iPat ++)
             {
                if (subject.charAt(iSub + iPat)
                    != pattern.charAt(iPat))
                {
                   rtnIndex = NOTFOUND;
                   isPat = false;
                   /* MB: isPat = true; */
                   break;  // out of for loop
                }
             }
          }
          iSub ++;
       }
       return (rtnIndex);
    }
}







```

::::
:::

# Step 2 - Analyzing

* For the Analysis we will use the following
  - SciTools Understand
  - [http://scitools.com](http://scitools.com)

\vskip.5em

* The tool is not free, but is free for educational use

\vskip.5em

* Can do many things but we will focus on CFG's for now

#

\titleslide{.85\textwidth}{Let's start with patternIndex()}

# Step 3 - patternIndex() Results

\centering
\includegraphics[width=.75\textwidth]{images/example/pi_cfg.png}

# Step 4 - patternIndex()

\centering
\includegraphics[width=.75\textwidth]{images/example/pi_cfg_num.png}

# Step 5 - patternIndex()

::: columns
:::: column

\begin{center}
\includegraphics[width=.75\textwidth]{images/example/pi_cfg_num.png}
\end{center}

* **Test Paths**
  1. [1, 2, 10]
  2. [1, 2, 3, 4, 2, 10]
  3. [1, 2, 3, 5, 6, 4, 2, 10]
  4. [1, 2, 3, 5, 6, 7, 8, 9, 4, 2, 10]

::::
:::: column

* **Edge Pair Paths**
  - 1 [1, 2, 3], (2) [1, 2, 10], (3) [2, 3, 4]
  - 4 [2, 3, 5], (5) [3, 5, 6], (6) [3, 4, 2]
  - 7 [4, 2, 10], (8) [4, 2, 3], (9) [5, 6, 4]
  - 10 [5, 6, 7], (11) [6, 7, 6], (12) [6, 7, 8]
  - 13 [7, 6, 7], (14) [7, 6, 4], (15) [7, 8, 9]
  - 16 [8, 9, 4], (17) [9, 4, 2], (18) [6, 4, 2]

* **Test Paths Continued**
  5. [1, 2, 3, 5, 6, 7, 6, 4, 2, 10]
  6. [1, 2, 3, 5, 6, 7, 6, 7, 8, 9, 4, 2, 10]
  7. [1, 2, 3, 5, 6, 7, 6, 4, 2, 10]

::::
:::

# Step 5 - patternIndex()

* **Test Paths**
  1. [1, 2, 10] -> 2
  2. [1, 2, 3, 4, 2, 10] -> 1, 4, 5, 7, 9, 18
  3. [1, 2, 3, 5, 6, 4, 2, 10] -> 1, 4, 5, 7, 9, 10
  4. [1, 2, 3, 5, 6, 7, 8, 9, 4, 2, 10] -> 1, 4, 5, 7, 10, 12, 15, 16, 17
  5. [1, 2, 3, 5, 6, 7, 6, 4, 2, 10] -> 1, 4, 5, 7, 10, 11, 18
  6. [1, 2, 3, 5, 6, 7, 6, 7, 8, 9, 4, 2, 10] -> 1,4, 5, 7, 10, 11, 12, 13, 15, 16, 17
  7. [1, 2, 3, 5, 6, 7, 6, 4, 2, 10] -> 1, 4, 5, 7, 10, 11, 14, 18

* Note: 4 and 5 are redundant
* So we only have 4 tests to create

# Step 6 - patternIndex()

* Test Case 1: [1, 2, 10]
  - Inputs:
    * `subject = ""`
    * `pattern = "a"`
  - Expected: `-1`
* Test Case 2: [1, 2, 3, 4, 2, 10]
  - Inputs:
    * `subject = "Too"`
    * `pattern = "How"`
  - Expected: `-1`

# Step 6 - patternIndex()

* Test Case 3: [1, 2, 3, 5, 6, 7, 6, 7, 8, 9, 4, 2, 10]
  - Inputs:
    * `subject = "Too"`
    * `pattern = "Toa"`
  - Expected: `-1`
* Test Case 4: [1, 2, 3, 5, 6, 7, 6, 4, 2, 10]
  - Inputs:
    * `subject = "Foo"`
    * `pattern = "Fo"`
  - Expected: `0`

#

\titleslide{.675\textwidth}{Step 7 \& 8 - patternIndex()}

#

\titleslide{.475\textwidth}{Now on to main()}

# Step 3 - main()

\centering
\includegraphics[width=.7\textwidth]{images/example/main_cfg.png}

# Step 4 - main()

\centering
\includegraphics[width=.7\textwidth]{images/example/main_cfg_num.png}

# Step 5 - main()

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/example/main_cfg_num.png}

::::
:::: column

* **Edge-Pair Paths**
  1. [1, 2, 5]
  2. [1, 3, 4]
  3. [2, 5, 9]
  4. [3, 4, 6]
  5. [3, 4, 7]
  6. [4, 6, 9]
  7. [4, 7, 9]

* **Test Paths**
  1. [1, 2, 5, 9]
  2. [1, 3, 4, 6, 9]
  3. [1, 3, 4, 7, 9]

::::
:::

# Step 6 - main()

* Test Case 1: [1, 2, 5, 8, 9]
  - Input: `argv = []`
  - Expected: `"java PatternIndex Subject Pattern\n"`

* Test Case 2: [1, 3, 4, 6, 9]
  - Input: `argv = ["foo", "bar"]`
  - Expected: `"Pattern string is not a substring of the subject string\n"`

* Test Case 3: [1, 3, 4, 7, 9]
  - Input: `argv = ["foobar", "oba"]`
  - Expected: `"Pattern string begins at character 2\n"`

#

\titleslide{.485\textwidth}{Step 7 \& 8 - main()}

# For Next Time

::: columns
:::: column

* Review the Reading
* Review this Lecture
* Come to Class

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
