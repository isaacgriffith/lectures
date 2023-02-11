# Sequence Diagram Exercise
Use the following class diagram and method definitions to create the sequence diagram for moving a song from the song pool to the play list.

::: columns

:::: column
\centering
\includegraphics[width=\textwidth]{images/SequenceDiagrams/examples/mixed_tape_cd.png}
::::
:::: column
\tiny
**In the MixTapeModel class:**
```java
/** Move a song from the pool to the playlist */
public boolean addToMix(int position)
```

**In the PlayList class:**
```java
/** Determine if the tape has room for a specific song. */
public boolean hasRoom(Song newSong)

/** Accessor to the available time remaining on the tape,
that is, unused space. */
public TimeDuration getRemainingTime()

/** Adds up the total time taken by the current songs in
this play list. */
public TimeDuration getTotalTime()
```
::::

:::

# Sequence Diagram Exercise
\centering
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/examples/sd_solution.eps}

# Activity Diagram Exercise
The purchasing department handles purchase requests from other departments in the company.  People in the company who initiate the original purchase request are the "customers" of the purchasing department.  A case worker within the purchasing department receives that request and monitors it until it is ordered and received. Case workers process the requests for purchasing products under $1,500, write a purchase order, and then send it to the approved vendor.  Purchase requests over $1,500 must first be sent out for a bid from the vendor that supplies the product.  When the bids return, the case worker selects one bid. Then, the case worker writes a purchase order and sends it to the approved vendor.

# Activity Diagram Exercise
\centering
\includegraphics[width=.5\textwidth]{images/ActivityDiagram/examples/ex1_solution.eps}
