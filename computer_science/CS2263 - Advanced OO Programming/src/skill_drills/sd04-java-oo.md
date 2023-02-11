# Java OO Skill Drill

## Part 1 - Setup

1. Create a new GitHub repository
2. Clone the repo on your computer
3. Initialize the repo with gitflow
4. Start a new feature and initialize a gradle project
   - Use `edu.isu.cs2263.javaskill` as the base package name
5. Finish the feature
6. Start a new feature

## Part 2 - Todo

1. Create the interface `Shape`
2. Create the abstract class `AbstractShape` which implements `Shape`
3. Create the following classes which extend `AbstractShape`:
   - Abstract class `Shape2D`
   - Abstract class `Shape3D`
4. Create the following 2D Shapes:
   - `Circle`
   - `Rectangle`
   - `Square`
   - `Triangle`
5. Create the following 3D Shapes:
   - `Sphere`
   - `Prism`
   - `Cube`
   - `Pyramid`
6. Add a `getArea` and a `getVolume` method to `Shape` both of which return a `double` and take no parameters
7. Implement `getVolume` in `Shape2D` to always return 0.0
8. Implement a `toString` method in `AbstractShape` which returns the name of the shape's correct class (lookup `java.lang.Class` in the Java API to find the right method), every object knows its class by calling `this.getClass()`
9. Add appropriate constructors for each class. Use multiple constructors.
10. If a shape is a subtype of another be sure to show that through inheritance, also don't forget to call the `super` constructor
11. Finish the feature

## Part 3

1. When finished push all your changes to origin
2. Start and finish a release called `v1.0`
3. Push all branches and tags
3. Submit your repo url

## Submission

* Submit your repo url to moodle in the submission textbox by no later than January 31, 2021 at 11:00 pm
