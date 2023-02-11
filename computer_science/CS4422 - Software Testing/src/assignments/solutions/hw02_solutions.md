---
course: "CSCI 4422 | CSCI 5599"
title: HW 02 - Evolution work -- improved UI
assigned: "September 09, 2019"
due: "September 23, 2019 @ 23:00h"
fontsize: 12pt
...

# Questions (20 pts) {-}

Download and compile the small command-line Java program Calendar.java. Calendar reads two integer inputs representing a month and a year, and prints the calendar for that month.

A test for Calendar is two integer inputs and the expected output.

1. Design at least five tests. One should be a “happy path” test, that is, a test for normal behavior. The others should use exceptional inputs. Document your tests on paper with the values and the expected results.
2. Run your tests. (You can run them by hand; we will get to automation later.) Capture and submit the results of running your tests.
3. Modify Calendar.java to include input validation. When finished, your tests related to input validation should run correctly.
4. As you make the changes, keep a simple documentation log of what you do. Note which components and methods you change and which ones you no longer use. Summarize the changes in a few words. You do not need to go to the level of which variables you create or delete or how you change the control flow. I just want the highlights. This should be no more than one page.
5. Write a short assessment of the maintainability of the software. What did the original programmers do that made it hard to change the software? What did the original programmers do that made it easy to change the software? What would you do differently if you did the assignment again? One or two paragraphs should be enough.

# Key {-}

## The 5 Tests

**Test 1:**
- Inputs: `[1, 2020]`
- Expected output:
```
   S  M  T  W Th  F  S
            1  2  3  4
   5  6  7  8  9 10 11
  12 13 14 15 16 17 18
  19 20 21 22 23 24 25
  26 27 28 29 30 31
```

**Test 2:**
- Inputs: `[0, 2020]`
- Expected output:
```
0 is not a valid month! Please use a value between 1 and 12.
```

**Test 3:**
- Inputs: `[1, -1]`
- Expected output:
```
-1 is not a valid year! Please use a value greater than or equal to 0.
```

**Test 4:**
- Inputs: `[13, 2020]`
- Expected Output:
```
13 is not a valid month! Please use a value between 1 and 12.
```

**Test 5:**
- Inputs: `[0, -1]`
- Expected Output:
```
0 is not a valid month! Please use a value between 1 and 12.
-1 is not a valid year! Please use a value greater than or equal to 0.
```

## Actual Test Output

# Submission {-}

Submit six items at the beginning of class, on paper:

1. A very simple introduction or cover page with all partner names (no more than three per team) and a collaboration summary.
2. Your five tests from step 1 above.
3. Output from your five tests on the original program.
4. Output from your five tests on your modified program.
5. The simple documentation log.
6. Your maintainability assessment.

Submit one item before class, on moodle:

7. Submit source code for your modified Calendar.java on moodle under assign 2.

# Grading {-}

We will grade on several factors.

* (4 pts) Whether each item is included
* (3 pts) Whether the modified software works
* (4 pts) Clarity and thoughtfulness of the documentation log
* (4 pts) Clarity and thoughtfulness of the maintainability assessment
* (3 pts) Quality, maintainability, minimality of the changes you made to the code (this is why we need access to source files)
* (2 pts) Other factors to be determined while grading
