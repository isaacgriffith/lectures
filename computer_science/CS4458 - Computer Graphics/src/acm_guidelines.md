# Knowledge Areas

## GV/Fundamental Concepts

**Lecture Topics**

* Media applications including UI, audio/video editing, game engines, CAD, visualization, and VR
* Digitization of analog data, resolution, and the limits of human perception, e.g., pixels for visual display, dots for laser printers, and samples for audio
* Use of standard APIs for the construction of UIs and display of standard media formats
* Standard media formats including lossless and lossy formats
* Additive and subtractive color models (CMYK and RGB) and why those provide a range of colors
* Tradeoffs between storing data and re-computing data as embodied by vector and raster representations of images
* Animation as a sequence of still images
* Double buffering

**Learning Outcomes**

1. Identify common uses of digital presentation to humans (e.g., computer graphics, sound). [F]
2. Explain in general terms how analog signals can be reasonably represented by discrete samples, for example, how images can be represented by pixels. [F]
3. Explain how the limits of human perception affect choices about the digital representation of analog signals. [F]
4. Construct a simple UI using a standard API. [U]
5. Describe the differences between lossy and lossless image compression techniques, for example as reflected in common graphics image file formats such as JPG, PNG, MP3, MP4, and GIF. [F]
6. Describe color models and their use in graphcis display devices. [F]
7. Describe the tradeoffs between storing information vs. storing enough information to reproduce the information, as in the difference between vector and raster rendering. [F]
8. Describe the basic process of producing continuous motion from a sequence of discrete frames (sometimes called "flicker fusion"). [F]
9. Describe how double-buffering can remove flicker from animation. [F]

## GV/Basic rendering

**Lecture Topics**

* Rendering in nature, e.g., the emission and scattering of light and its relation to numerical integration.
* Forward and backward rendering (i.e., ray-casting and rasterization)
* Polygonal representation
* Basic radiometry, similar triangles, and projection model
* Affine and coordinate system transformations
* Ray tracing
* Visibility and occlusion, including solutions to this problem such as depth buffering, Painter's algorithm, and ray tracing
* The forward and backward rendering equation
* Simple triangle rasterization
* Rendering with a shader-based API
* Texture mapping, including minification and magnification (e.g., trilinear MIP-mapping)
* Application of spatial data structures to rendering
* Sampling and anti-aliasing
* Scene graphs and the graphics pipeline

**Learning Outcomes**

1. Discuss the light transport problem and its relation to numerical integration i.e., light is emitted, scatters around the scene, and is meaured by the eye. [F]
2. Describe the basic graphics pipeline and how forward and backward rendering factor in this. [F]
3. Create a program to display 3D models of simple graphics images. [U]
4. Derive linear perspective from similar triangles by converting points (x, y, z) to points (x/z, y/z, 1). [U]
5. Obtain 2D and 3D points by applying affine tranformations. [U]
6. Apply 3D coordinate system and the changes required to extend 2D transformation operations to handle transformations in 3D. [U]
7. Contrast forward and backward rendering. [A]
8. Explain the concept and applications of texture mapping, sampling, and anti-aliasing. [F]
9. Explain the ray tracing/rasterization duality for the visibility problem. [F]
10. Implement simple procedures that perform transformation and clipping operations on simple 2D images. [U]
11. Implement a simple real-time render using a rasterization API (e.g., OpenGL) using vertex buffers and shaders. [U]
12. Compare and contrast the different rendering techniques [A]
13. Computer space requirements based on resolution and color coding. [A]
14. Computer time requirements based on refresh rates, rasterization techniques. [A]

## GV/Geometric Modeling

**Lecture Topics**

* Basic geometric operations such as intersection calculation and proximity tests
* Volumes, voxels, and point-based representations
* Parametric polynomial curves and surfaces
* Implicit representation of curves and surfaces
* Appriximation techniques such as polynomial curves, Bezier curves, spline curves and surfaces, and non-uniform rational basis (NURB) splines, and level set method
* Surface representation techniques including tessellation, mesh representation, mesh fairing, and mesh generation techniques such as Delaunay triangularation, marching cubes
* Spatial subdivision techniques
* Procedural models such as fractals, generative modeling, and L-systems
* Graftals, cross referenced with programming languages (grammars to generated pictures)
* Elastically deformable and freeform deformable models
* Subdivision surfaces
* Multiresolution modeling
* Reconstruction
* Constructive Solid Geometry (CSG) representation

**Learning Outcomes**

1. Represent curves and surfaces using both implicit and parametric forms. [U]
2. Create simple polyhedral models by surface tessellation. [U]
3. Generate a mesh representation from an implicit surface. [U]
4. Generate a fractal model or terrain using a procedural method. [U]
5. Generate a mesh from data points acquired with a laser scanner. [U]
6. Construct CSG models from simple primitives, such as cubes and quadric surfaces [U]
7. Contrast modeling approaches with respect to space and time complexity and quality of image [A]

## GV/Advanced Rendering

**Lecture Topics**

* Solutions and approximations to the rendering equation, for example:
  - Distirbution ray tracing and path tracing
  - Photon mapping
  - Bidirectional path tracing
  - Reyes (micropolygon) rendering
  - Metropolis light transport
* Time (motion blur), lens position (focus), and continuous frequency (color) and their impact on rendering
* Shadow mapping
* Occlusion culling
* Bidirectional Scattering Distribution function (BSDF) theory and microfacets
* Subsurface Scattering
* Area light sources
* Hierarchical depth buffering
* The Light Field, image-based rendering
* Non-photorealistic rendering
* GPU architecture
* Human visual systems including adaptation to light, sensitivity to noise, and flicker fusion

**Learning Outcomes**

1. Demonstrate how an algorithm estimates a solution to the rendering equation [A]
2. Prove the properties of a rendering algorithm, e.g., complete, consistent and unbiased [A]
3. Analyze the bandwidth and computation demands of a simple algorithm [A]
4. Implement a non-trivial shading algorithm (e.g., toon shading, cascaded shadow maps) under a rasterization API. [U]
5. Discuss how a particular artistic technique might be implemented in a renderer. [F]
6. Explain how to recognize the graphics techniques used to create a particular image. [F]
7. Implement any of the specified graphics techniques using a primitive graphics system at the individual pixel level. [U]
8. Implement a ray tracer for scenes using a simple (e.g., Phong model) BRDF plus reflection and refraction. [Usage]

## GV/Computer Animation

**Lecture Topics**

* Forward and inverse kinematics
* Collision detection and response
* Procedural animation using noise, rules (boids/crowds), and particle systems
* Skinning algorithms
* Physics based motions including rigid body dynamics, physical particle systems, mass-spring networks for cloth and flesh and hair
* Key-frame animation
* Splines
* Data structures for rotations, such as quaternions
* Camera animation
* Motion capture

**Learning Outcomes**

1. Compute the location and orientation of model parts using a forward kinematic approach. [U]
2. Compute the orientation of articulated parts of a model from a location and orientation using an inverse kinematic approach. [U]
3. Describe the tradeoffs in different representations of rotations [A]
4. Implement the spline interpolation method for producing in-between positions and orientations [U]
5. Implement algorithms for physical modeling of particle dynamics using simple Newtonian mechanics, for example Witkin & Kass, snakes and worms, symplectic Euler, Stormer/Verlet, or midpoint Euler methods [U]
6. Discuss the basic ideas behind some methods for fluid dynamics for modeling ballistic trajectories, for example for splashes, dust, fire, or smoke [F]
7. Use common animation software to construct simple organic forms using metaball and skeleton [U]

## GV/Visualization

**Lecture Topics**

* Visualization of 2D/3D scalar fields: color mapping, isosurfaces
* Direct volume data rendering: ray-casting, transfer functions, segmentation
* Visualization of:
  - Vector fields and flow data
  - Time-varying data
  - High-dimensional data: dimension reduction, parallel coordinates
  - Non-spatial data: multi-variate, tree/graph structured, text
* Perceptual and cognitive foundations that drive visual abstractions
* Visualization design
* Evaluation of visualization methods
* Applications of visualization

**Learning Outcomes**

1. Describe the basic algorithms for scalar and vector visualization [F]
2. Describe the tradeoffs of visualization algorithms in terms of accuracy and performance [A]
3. Propose a suitable visualization design for a particular combination of data characteristics and application tasks [A]
4. Analyze the effectiveness of a given visualization for a particular task [A]
5. Design a process to evaluate the utility of a visualization algorithm or system [A]
6. Recognize a variety of applications of visualization including representations of scientific, medical, and mathematical data; flow visualization; and spatial analysis [F]
