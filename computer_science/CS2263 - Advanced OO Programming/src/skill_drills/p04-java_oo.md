# Java OO Practicum

## Part 1 - Setup

1. Create a new **public** repository on GitHub called "java-practicum"
2. Clone this repo on your local machine
3. In the repo's root directory initialize a new gradle project.
   - the language should be Java
   - select Java Application
   - set the base package name to be "edu.isu.cs2263.javaskill"
4. You can delete both the "App.java" and "AppTest.java" files
5. Commit and push

## Part 2 - LongInteger

1. Create a new Interface in package `edu.isu.cs2263.javaskill` called `MyNumber` which defines the following contract:
   - `readIn` which returns `void` and takes no parameters
     * Reads in the number from keyboard input. We assume only digits will be entered
   - `add` which returns a new `MyNumber` and takes a single `int` as a parameter
     * Adds the provided `int` to the underlying primitive representation
   - `add` which returns a new `MyNumber` and takes a single `MyNumber` as a parameter.
     * Adds the provided `MyNumber` to the underlying primitive representation
2. Create a new class in package `edu.isu.cs2263.javaskill` called `LongInteger` which implements `MyNumber` and represents an integer of up to 50 digitrs. In addition to the above contract (replacing `MyNumber`s with `LongIntegers`) you will need to provide the following:
   - A constructor which takes no parameters and sets the underlying primitive representation to 0.
   - A constructor which takes as a parameter an array of ints. This sets the value to that represented by the array.
   - A constructor which takes a single integer as a parameter to which the underlying representation is to be set.
   - A `toString()` method which returns a representation of the `LongInteger` as a `String`
3. Only one true constructor should be defined while the others simply call that one defined constructor.

**Hint**: I would store the `LongInteger` as an array of ints, since the maximum size of an `int` or a `long` is not even close to 50 digits in length

## Part 3 - Conclusion

1. Once you have completed your implementation, commit all of your changes, push them to GitHub
2. Next tag your repo at version `v1.0` and push the new tag

## Submission

* Submit the URL for your repo to moodle by no later than January 31, 2021 at 11:00 pm.
