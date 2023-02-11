# GV/Fundamental Concepts
1. Identify common uses of digital presentation to humans (e.g., computer graphics, sound). [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

2. Explain in general terms how analog signals can be reasonably represented by discrete samples, for example, how images can be represented by pixels. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

3. Explain how the limits of human perception affect choices about the digital representation of analog signals. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

4. Construct a simple UI using a standard API. [U]
  - Lecture:
  - Programming Assignment:
  - Activity:
  - Quiz:

5. Describe the differences between lossy and lossless image compression techniques, for example as reflected in common graphics image file formats such as JPG, PNG, MP3, MP4, and GIF. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

6. Describe color models and their use in graphics display devices. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

7. Describe the tradeoffs between storing information vs. storing enough information to reproduce the information, as in the difference between vector and raster rendering. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

8. Describe the basic process of producing continuous motion from a sequence of discrete frames (sometimes called "flicker fusion"). [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

9. Describe how double-buffering can remove flicker from animation. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

# GV/Basic Rendering

1. Discuss the light transport problem and its relation to numerical integration i.e., light is emitted, scatters around the scene, and is measured by the eye. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

2. Describe the basic graphics pipeline and how forward and backward rendering factor in this. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

3. Create a program to display 3D models of simple graphics images. [U]
  - Lecture:
  - Programming Assignment:
  - Activity:
  - Quiz:

4. Derive linear perspective from similar triangles by converting points (x, y, z) to points (x/z, y/z, 1). [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

5. Obtain 2D and 3D points by applying affine tranformations. [U]
  - Lecture:
  - Programming Assignment:
  - Activity:
  - Quiz:

6. Apply 3D coordinate system and the changes required to extend 2D transformation operations to handle transformations in 3D. [U]
  - Lecture:
  - Programming Assignment:
  - Activity:
  - Quiz:

7. Contrast forward and backward rendering. [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

8. Explain the concept and applications of texture mapping, sampling, and anti-aliasing. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

9. Explain the ray tracing/rasterization duality for the visibility problem. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

10. Implement simple procedures that perform transformation and clipping operations on simple 2D images. [U]
  - Lecture:
  - Programming Assignment:
  - Activity:
  - Quiz:

11. Implement a simple real-time render using a rasterization API (e.g., OpenGL) using vertex buffers and shaders. [U]
  - Lecture:
  - Programming Assignment:
  - Activity:
  - Quiz:

12. Compare and contrast the different rendering techniques [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

13. Compute space requirements based on resolution and color coding. [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

14. Computer time requirements based on refresh rates, rasterization techniques. [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

# GV/Geometric Modeling

1. Represent curves and surfaces using both implicit and parametric forms. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

2. Create simple polyhedral models by surface tessellation. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

3. Generate a mesh representation from an implicit surface. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

4. Generate a fractal model or terrain using a procedural method. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

5. Generate a mesh from data points acquired with a laser scanner. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

6. Construct CSG models from simple primitives, such as cubes and quadratic surfaces [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

7. Contrast modeling approaches with respect to space and time complexity and quality of image [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

# GV/Advanced Rendering

1. Demonstrate how an algorithm estimates a solution to the rendering equation [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

2. Prove the properties of a rendering algorithm, e.g., complete, consistent and unbiased [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

3. Analyze the bandwidth and computation demands of a simple algorithm [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

4. Implement a non-trivial shading algorithm (e.g., toon shading, cascaded shadow maps) under a rasterization API. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

5. Discuss how a particular artistic technique might be implemented in a renderer. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

6. Explain how to recognize the graphics techniques used to create a particular image. [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

7. Implement any of the specified graphics techniques using a primitive graphics system at the individual pixel level. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

8. Implement a ray tracer for scenes using a simple (e.g., Phong model) BRDF plus reflection and refraction. [Usage]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

# GV/Computer Animation

1. Compute the location and orientation of model parts using a forward kinematic approach. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

2. Compute the orientation of articulated parts of a model from a location and orientation using an inverse kinematic approach. [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

3. Describe the tradeoffs in different representations of rotations [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

4. Implement the spline interpolation method for producing in-between positions and orientations [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

5. Implement algorithms for physical modeling of particle dynamics using simple Newtonian mechanics, for example Witkin & Kass, snakes and worms, symplectic Euler, Stormer/Verlet, or midpoint Euler methods [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

6. Discuss the basic ideas behind some methods for fluid dynamics for modeling ballistic trajectories, for example for splashes, dust, fire, or smoke [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

7. Use common animation software to construct simple organic forms using metaball and skeleton [U]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

# GV/Visualization

1. Describe the basic algorithms for scalar and vector visualization [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

2. Describe the tradeoffs of visualization algorithms in terms of accuracy and performance [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

3. Propose a suitable visualization design for a particular combination of data characteristics and application tasks [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

4. Analyze the effectiveness of a given visualization for a particular task [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

5. Design a process to evaluate the utility of a visualization algorithm or system [A]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:

6. Recognize a variety of applications of visualization including representations of scientific, medical, and mathematical data; flow visualization; and spatial analysis [F]
  - Lecture:
  - Homework:
  - Activity:
  - Quiz:
