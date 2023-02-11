# Learning Outcomes {-}

## The following outcomes will be evaluated via homework assignments and exams {-}

### GV/Fundamental Concepts {-}

- Identify common uses of digital presentation to humans (e.g., computer graphics, sound). [F]
- Explain in general terms how analog signals can be reasonably represented by discrete samples, for example, how images can be represented by pixels. [F]
- Explain how the limits of human perception affect choices about the digital representation of analog signals. [F]
- Describe the differences between lossy and lossless image compression techniques, for example as reflected in common graphics image file formats such as JPG, PNG, MP3, MP4, and GIF. [F]
- Describe color models and their use in graphics display devices. [F]
- Describe the tradeoffs between storing information vs. storing enough information to reproduce the information, as in the difference between vector and raster rendering. [F]
- Describe the basic process of producing continuous motion from a sequence of discrete frames (sometimes called "flicker fusion"). [F]
- Describe how double-buffering can remove flicker from animation. [F]

### GV/Basic rendering {-}

- Discuss the light transport problem and its relation to numerical integration i.e., light is emitted, scatters around the scene, and is measured by the eye. [F]
- Describe the basic graphics pipeline and how forward and backward rendering factor in this. [F]
- Contrast forward and backward rendering. [A]
- Explain the concept and applications of texture mapping, sampling, and anti-aliasing. [F]
- Explain the ray tracing/rasterization duality for the visibility problem. [F]
- Compare and contrast the different rendering techniques [A]
- Computer space requirements based on resolution and color coding. [A]
- Computer time requirements based on refresh rates, rasterization techniques. [A]

### GV/Geometric Modeling {-}

- Contrast modeling approaches with respect to space and time complexity and quality of image [A]

### GV/Advanced Rendering {-}

- Demonstrate how an algorithm estimates a solution to the rendering equation [A]
- Prove the properties of a rendering algorithm, e.g., complete, consistent and unbiased [A]
- Analyze the bandwidth and computation demands of a simple algorithm [A]
- Discuss how a particular artistic technique might be implemented in a renderer. [F]
- Explain how to recognize the graphics techniques used to create a particular image. [F]

### GV/Computer Animation {-}

- Describe the tradeoffs in different representations of rotations [A]
- Discuss the basic ideas behind some methods for fluid dynamics for modeling ballistic trajectories, for example for splashes, dust, fire, or smoke [F]

### GV/Visualization {-}

- Describe the basic algorithms for scalar and vector visualization [F]
- Describe the tradeoffs of visualization algorithms in terms of accuracy and performance [A]
- Propose a suitable visualization design for a particular combination of data characteristics and application tasks [A]
- Analyze the effectiveness of a given visualization for a particular task [A]
- Design a process to evaluate the utility of a visualization algorithm or system [A]
- Recognize a variety of applications of visualization including representations of scientific, medical, and mathematical data; flow visualization; and spatial analysis [F]

## The following outcomes will be evaluated via homework assignments and the course project {-}

### GV/Fundamental Concepts {-}

- Construct a simple UI using a standard API. [U]

### GV/Basic rendering {-}

- Create a program to display 3D models of simple graphics images. [U]
- Derive linear perspective from similar triangles by converting points (x, y, z) to points (x/z, y/z, 1). [U]
- Obtain 2D and 3D points by applying affine transformations. [U]
- Apply 3D coordinate system and the changes required to extend 2D transformation operations to handle transformations in 3D. [U]
- Implement simple procedures that perform transformation and clipping operations on simple 2D images. [U]
- Implement a simple real-time render using a rasterization API (e.g., OpenGL) using vertex buffers and shaders. [U]

### GV/Geometric Modeling {-}

- Represent curves and surfaces using both implicit and parametric forms. [U]
- Create simple polyhedral models by surface tessellation. [U]
- Generate a mesh representation from an implicit surface. [U]
- Generate a fractal model or terrain using a procedural method. [U]
- Generate a mesh from data points acquired with a laser scanner. [U]
- Construct CSG models from simple primitives, such as cubes and quadric surfaces [U]

### GV/Advanced Rendering {-}

- Implement a non-trivial shading algorithm (e.g., toon shading, cascaded shadow maps) under a rasterization API. [U]
- Implement any of the specified graphics techniques using a primitive graphics system at the individual pixel level. [U]
- Implement a ray tracer for scenes using a simple (e.g., Phong model) BRDF plus reflection and refraction. [U]

### GV/Computer Animation {-}

- Compute the location and orientation of model parts using a forward kinematic approach. [U]
- Compute the orientation of articulated parts of a model from a location and orientation using an inverse kinematic approach. [U]
- Implement the spline interpolation method for producing in-between positions and orientations [U]
- Implement algorithms for physical modeling of particle dynamics using simple Newtonian mechanics, for example Witkin & Kass, snakes and worms, symplectic Euler, Stormer/Verlet, or midpoint Euler methods [U]
- Use common animation software to construct simple organic forms using metaball and skeleton [U]
