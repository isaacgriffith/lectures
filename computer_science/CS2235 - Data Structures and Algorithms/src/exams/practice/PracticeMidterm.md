---
course: "CSCI 2235"
exam: Practice Midterm Exam
date: "October 15, 2019"
time: 75 Minutes
fontsize: 12pt
...

\question[4]
Suppose you have a stack (initially  empty) with standard \verb|push(int e)|, \verb|pop()|, and \verb|peek()| methods. What are the values in the stack after the following operations were executed: \verb|pop()|, \verb|push(5)|, \verb|push(3)|, \verb|peek()|, \verb|push(7)|, \verb|pop()|, \verb|push(2)|, \verb|pop()|, \verb|pop()|

\begin{choices}
 \choice null
 \choice 2
 \CorrectChoice 5
 \choice 3, 5
\end{choices}

\question[4]
Which of the following is a true statement about interfaces in Java?
\begin{choices}
 \CorrectChoice They enable the structuring of classes into a hierarchy.
 \CorrectChoice They provide a list of methods guaranteed to be in any class that implements it.
 \choice They process ActionEvents to enable MouseListeners and GUI interactivity.
 \CorrectChoice They are instantiated to provide flexibility with run-time object selection.
\end{choices}

\question[4]
What is the reason for using Generic Classes when building Classes?

\begin{choices}
 \choice Generic Classes avoid stack overflow errors on recursive calls.
 \choice Generic Classes enable operations to occur for different data types.
 \choice They help ensure code will function on one single data type.
 \choice They identify and enforce specific execution parameters.
\end{choices}

\question[4]
What is a major limitation of using an array to implement a stack?

\begin{choices}
 \choice Node creation is complicated because they will be stored inside the array.
 \choice Directly indexing into the array will slow operations when searching a stack.
 \choice Insertions into and deletions from the array need to involve a lot of shifting.
 \choice Either the array needs to be resized, or the stack needs to have a fixed size.
\end{choices}

\question[4]
If you can possibly use recursion, you should. I.e., recursive solutions are ALWAYS better than iterative solutions.

\begin{choices}
 \choice TRUE
 \choice FALSE
\end{choices}

\question[4]
How should one fix a NullPointerException?

\begin{choices}
 \choice Go to Isaac, he'll fix it.
 \choice Go to the line with the error and look at the method that is being called in that line.
 \choice Go to the line with the error and identify the object that doesn't exist but should.
 \choice Go to the line with the error and see if the recursive call is structured properly.
\end{choices}

\question[4]
What is likely happening when you get a StackOverflowException?

\begin{choices}
 \choice You probably have a recursive function that is not stopping.
 \choice You probably are accessing a linked list without checking if \verb|head == null|.
 \choice You probably missed creating a new instance of whatever class threw the exception.
 \choice You probably have a variable that was never initialized.
\end{choices}

\question[4]
I am building an app that tracks the weather in Bozeman. People will be delivered the current day's weather. They may want to go back and forward a couple days in case they didn't check it recently. They may also want to check the weather at arbitrary days in the past. What should I use to store my weather data?

\begin{choices}
 \choice Circularly Linked List
 \choice Doubly Linked List
 \choice Linked List
 \choice Array
\end{choices}

\question[4]
My company is subject to government oversight. As such, I need to keep records detailing the internal financial review I do every month. I want to store them in chronological order (this month, then last month, then the month before, ...). It is very, very unlikely that I will be audited, so I am not concerned about needing to search through my records very often. What should I use to store my records?

\begin{choices}
 \choice Circularly Linked List
 \choice Doubly Linked List
 \choice Linked List
 \choice Array
\end{choices}

\question[4]
I am climbing a wicked new route on some remote Alaskan peak.  Being the weight weenies we are, my partners and I only brought one spoon (the handle is also cut off to shave grams).  Not only does this mean that we need to share the spoon, but more importantly it means we need to take turns digging into the instant mashed potatoes.  We want to be fair about making sure everyone gets their turn, so what would be best to use to keep track of whose turn it is to eat?

\begin{choices}
 \choice Circularly Linked List
 \choice Doubly Linked List
 \choice Linked List
 \choice Array
\end{choices}

\question[4]
I am building an application that tracks patients for the emergency room.  The person at the entrance will enter patients into the system and the doctor in the back will pull from the system (and see) whoever is closest to death.  What data structure should I use to store the patients in my system?

\begin{choices}
 \choice Deque
 \choice Stack
 \choice Queue
 \choice Priority Queue
\end{choices}

\question[4]
I am packing 15 clowns into a small car (I don't ask what you do in your personal time).  There is only one door and the plan is to pack them all in, then drive somewhere and unload them all.  What data structure should I use to keep track of the order clowns enter and leave the car?

\begin{choices}
 \choice Deque
 \choice Stack
 \choice Queue
 \choice Priority Queue
\end{choices}

\question[4]
Rumor has it that the iPhone 7.3s 9G XYZ is about to hit stores.  Apple has noticed in the past that their customers are an odd bunch.  They will wait in lines until the end of time, unless they are the last person in the line, then they may leave the line.  Clearly people will leave from the front also as they are granted the privilege of handing over \$500.  What should Apple use to model the lines?

\begin{choices}
 \choice Deque
 \choice Stack
 \choice Queue
 \choice Priority Queue
\end{choices}

\question[4]
I have decided to follow my dream of becoming a TV Chef.  Everyone knows that this means that I need to have all my ingredients prepped before I start cooking.  The way I do that is to go through the recipe one line at a time (in order), and prep the ingredients as I will add them (chop the onion, then measure the chicken stock,...).  After that is done, I will then roll the camera and use the ingredients in the order they were prepared.  What sort of data structure should I use to represent my line of ingredients?

\begin{choices}
 \choice Deque
 \choice Stack
 \choice Queue
 \choice Priority Queue
\end{choices}

\question[4]
What most accurately describes a linked list?

\begin{choices}
 \choice An array of Nodes that contain values. They can be visited in order by going through the array.
 \choice Entities that consist of pointers to other entities in a circular fashion.
 \choice A Node that has some sort of data payload as well as methods that let you insert and remove that data.
 \choice A sequence of objects containing a value and pointer to the next object, as well as a pointer to the first object.
\end{choices}

\question[4]
How could you implement a priority queue using what you know now?

\begin{choices}
 \choice Use a stack.  Push low priority items first so they are at the bottom, the popping will remove the top (high priority).
 \choice Create an object with value and priority parameters, then use a regular linked list.  Insert in order to enqueue and remove from the front to dequeue.
 \choice Use a doubly linked list, but enqueue by adding to the front and dequeue by removing from the rear.  Priorities can be ignored because it is doubly linked.
 \choice Use a regular ArrayList implementation of a queue.  The priority will be then correspond to the spot in the array to place the value (i.e. a priority 1 item would could into spot 1).
\end{choices}

\question[4]
Suppose you wanted to simulate how long it takes a mailman to deliver all the letters in his truck.  Suppose he delivers a random number of letters per minute (between 3 and 7).  What would be the most reasonable approach?

\begin{choices}
 \choice Set up a simple program that will register the System.nanoTime() each time you hit enter.  Fill a mailman's truck up with the correct number of letters.  Hit enter, follow him around until he is finished (ensuring his delivery rate is between 3 and 7 per minute) and hit enter.  The time it took is the difference of those two values.
 \choice Use a while loop to keep running while the time used is below some threshold.  Inside the while loop, deduct an appropriate random number of letters from the truck.  If the truck empties before the time is up, rerun with a smaller threshold.  If the truck is full after the time is up, rerun with a larger threshold.
 \choice Use a while loop to keep running while the truck isn't empty.  Inside the while loop get an appropriate random number of letters and deduct that from the letters in the truck.  Return the number of times the while loop executed (number of minutes it took).
 \choice Use a for loop to keep track of the number of minutes used.  Inside the for loop, if the truck isn't empty, remove an appropriate random number of letters from the truck.  When the time is expired, return the number of letters left in the truck.
\end{choices}

\question[4]
Which growth function would be best for an algorithm to have for very large values of $n$?

\begin{choices}
 \choice $f(n) = 100 * n^{2.2}$
 \choice $f(n) = log(n) * n^{2}$
 \choice $f(n) = .5 * n^{2}$
 \choice $f(n) = 1.001^{n}$
\end{choices}

\question[4]
What is an appealing property special to linked lists (when compared to arrays)?

\begin{choices}
 \choice Swapping nodes is easier than swapping spots in an array.
 \choice Searching through them is fast.
 \choice It is easy to determine what the next value is.
 \choice Easy to resize.
\end{choices}

\question[4]
Linear search can work on unsorted data, but binary search must be done on sorted data.

\begin{choices}
 \choice TRUE
 \choice FALSE
\end{choices}

\question[4]
Suppose I had a queue that was initially empty and I performed a total of 18 offer operations, 7 first operations, and 4 poll operations.  Suppose 2 of the poll operations and 3 of the first operations returned null values.  How many items are in the queue?

\begin{choices}
 \choice 0
 \choice 13
 \choice 14
 \choice 16
\end{choices}

\newpage

\question[4]
For the following method, identify the tightest big-oh running time.

\begin{lstlisting}
public int m1FindLargest(int[] array) {
    if (array.length != 0) {
        int value = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > value) {
                value = array[i];
            }
        }
        return value;
    }
    return -1;
}
\end{lstlisting}

\begin{choices}
 \choice $O(n!)$
 \CorrectChoice $O(n)$
 \choice $O(\log n)$
 \choice $O(n^2)$
\end{choices}

\question[4]
What is the worst case running time to search for a value in a binary tree?

\begin{choices}
\choice $O(n^2)$
\choice $O(1)$
\choice $O(n)$
\CorrectChoice $O(\log n)$
\end{choices}

\question[4]
Suppose I have a binary tree that looks like the image below.  What is the correct ordering of values returned with a post order traversal of this binary tree?

\begin{center}
 \includegraphics{images/midterm/Tree.png}
\end{center}


\begin{choices}
\choice 11, 15, 13, 38, 27, 25, 22, 19
\choice 19, 13, 11, 15, 22, 25, 27, 38
\choice 11, 13, 15, 19, 22, 27, 25, 38
\choice 11, 15, 13, 27, 38, 25, 22, 19
\end{choices}

\newpage

\question[4]
Which of the following is true of selection sort?

\begin{choices}
\choice It runs surprisingly fast on large arrays.
\choice As soon as an element is placed, it is in its final spot.
\choice It does not require any local variables to sort.
\choice It does not need to wait for all the data to be collected before it can begin sorting.
\end{choices}
