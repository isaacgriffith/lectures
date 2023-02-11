2263 Homework 01 Grading Key

* Download each student's submission, unzip it and grade as follows

Java - 16 Points
  - 4 Points - The program was code in Java and compiled with out error
    * Verify that they used Java (1 point)
    * Verify that the program compiles without any errors (3 points)
  - 4 Points - The program executes
    * Verify that the program produces on the console a prompt starting with "> " (2 point)
    * Verify that the program accepts input on the console (2 point)
  - 8 Points - The pgoram evaluates mathematical expressions and sends output to the standard output
    * Check that the program appears to process input and return the correct results (or very close to correct) using the following test cases [input, result]:
      - ["10 + 5 / 3 + 20 * 4", 100] (4 point)
      - ["6 / 2 - 6 * -1", 3] (4 point)
      
Documentation - 4 Points
  - Each class/interface/enum/record has a JavaDoc comment describing the purpose of the type and also uses the @author tag to identify who wrote the type (1 point)
  - Each method including getters, setters, constructors has a JavaDoc comment directly preceding it, which includes the following (in the provided order): (2 points)
    * A brief description of what the method does
    * If the method has parameters, then for each parameter there is a properly formatted @param tag
    * If the method returns a value, then there is a properly formatted @return tag
    * If the method throws an exception, then there is a properly formatted @throws tag
  - Methods are not excessively documented with comments throughout the code (use the JavaDoc comment or break up the method into multiple methods) (1 point)
  
  
3321 Homework 01 Grading Key

1. Consider the following software system: A University Course Catalog System
   
   * Identify the stakeholders of this system (both internal and external)
   
     Could include any of the following: System Developers, Professors, Students, Adminstration, Registrar, Guidance Counselor's, etc.
     
   * Select at least two stakeholders (as general groups) and describe both their interests and concerns for such a system
   
     Full credit as long as they identified two from their list and provided reasonable interests/concerns for the system
     
2. Compare and contrast the component and structured methods and their general characteristics:

   * As part of your narrative, describe the relationship between the general notions of methods and practices
   
     - Any reasonable answer is accepted here
   
   * Using this relationship as a basis: provide examples of practices found in specific instances of these methods.
   
     - Any reasonable answer is accepted here
   
   * Use these practices and their characteristics as the foundation for the comparison/contrast between the general categories of component and structured methods.
   
     - Any reasonable answer is accepted here
   
3. You will be working in teams this semester on your project. Using your previous experience combined with what you are learning this semester: discuss teamwork while answering the following questions:

   * When forming a team is there an expectation of a baseline set of capabilities for each team member?
     
     - Something similar to: Depending upon the role each member plays in the team different capabilities will be needed, furthermore, skills within each capability will be needed in order for the team to be successful in its endeavor. Thus, there is a baseline expectation (in general) even for interns in that they are capable of writing code, executing tests, and able to follow the basic method and practices used by the team.
     
   * If so, what are these capabilities, and how does this background affect the nature of how the team's practices (i.e., more explicitly or more tacitly) are defined?
     
     - See the prior answer. However, the lower the level of capability in the baseline the more explicitly defined the practices must be.
   
   * How do each team member's capabilities affect the dynamics of the team as a whole?
    
     - Teams with member's with lower levels of capability require more time spent in training and mentorship between junior and senior engineers. However, teams will higher levels of capability will allow for team members to function more independently with less oversight required from management.
   
   * How do the team's capabilities affect the dynamics of the software engineering endeavor?
   
     - Teams with higher levels of capability tend to be able to be more productive and to be capable of operating the endeavor 
   
   * NOTE: I would consider couching this narrative within the context of an example.

4. Consider the concept of requirements: Identify how requirements play a mediating role between software engineers, stakeholders, and the system to be built. As you are considering this also discuss the requirements alpha and how the alpha states are related to the role that requirements plays.

     Something similar to: Requirements are literally the intermediary between the stakeholders and developers representing what the stakeholders expect of the system encoded into a means which software engineers can understand. This is seen in the Requirement Alpha and its relationships. The alpha focuses the Opportunity Alpha which describes stakeholder value and encodes their demands into actionable items by which scope and constrain the software engineers work. All of this is defined by the states of the Requirements Alpha: Conceived, Bounded, Coherent, Acceptable, Addressed, and Fulfilled.

5. Consider just the Software System alpha. Identify the activity spaces which affect this alpha and describe how each of these would push progress forward and transition the alpha from one state to another.

   - The key activity spaces which are as follows:
     * Shape the System and Understand the Requirements both should help to fulfill the requirments of Architecture Selected State
     * Shape the System and Implement the System should help to fulfill the Demonstrable State
     * Implement the System, Test the System, and Deploy the System should provde the ability fulfill the requirements of the Usable State
     * Deploy the System should help to fulfill the requirements of the Ready State
     * Deploy the System and Operate the System should provide the ability to fulfill the Operational State requirements
     * Operate the System and Stop the Work should provide the ability to fulfill the Retired State requirements

6. Identify what the expectations of software engineering theory are, and once identified present at least one argument for why theory is needed in software engineering.

   - Part 1:

	Something similar to: In short, a software engineering theory should be able to describe the nature of software engineering and be able to predict the outcome of software engineering decisions as related to the goal of software engineering (to produce a working software product which provides value to customers).
   
   - Part 2:
	 
	 As long as their argument for software engineering theory is rational it should count.

7. Consider the following practices discussed in CS 2263:
   * Automated Build with Gradle
   * Unit Testing and Test-Driven Development (TDD)
   * Spec Testing and Behavior-Driven Development (BDD)

Select two of these and Essentialize them, providing the following:
   * A model showing the relationships between the elements
   * Cards that describe the Alphas, Alpha States, Work Products, Activities, and Patterns provided in the model
   * Show the combined layout (for both practices you selected) of where the activities go in the Standard Activity Spaces
   
   Regardless of the two they selected. They would need two models showing the relationships between essence elements, as high-level overview of the practice.
   
   Then for each Work Product, Sub-Alpha, Alpha State, Activity, and Pattern that they have defined for their practice descriptions, they would need to provide a card for this. Note only those things that are new and not part of the Essence Kernel need to be provided. The cards should conform to what is expected. That is,
   
    * An alpha card should provide the name of the alpha, a brief description, and the list of states.
    * Each alpha state card should provide the name of the alpha, a brief description of the state, and   a checklist of items that must be completed before the state can be achieved.
    * Each Activity should provide the activity name, then the initial state of any affected alphas, A Activity Space icon indicating where the activity falls into, within the activity space should be stars representing the compentencies involved and their level, and below the activity space should be the outcome of the activity including changes in alpha states and work products.
    * Work Product cards should have the name, a brief description, and the levels of detail for the work product as trapezoids (solid for required and dashed for optional).
    * Patterns representing roles should include the name of the role/pattern, a brief description, and a list of the primary duties of the role.
    
    All of this is required for each practice that is described
    
    

