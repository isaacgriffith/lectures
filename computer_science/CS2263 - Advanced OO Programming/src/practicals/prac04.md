---
course: CSCI 2263
title: "HW 04 - "
assigned: ""
due: " @ 23:00h"
...

# Assignment {-}

In lecture, we discussed a number of software principles, including Encapsulate What Varies, DRY, LSP, OCP, ISP, and SRP. Identify in each of the following cases which if any of these principles are violated and if so, (a) justify your reasoning as to why that principle applies in a sentence or two, and (b) outline how the code can be corrected (words is fine for the latter if it is clear, or you can give revised code).

Note, there may be more than one principle violated. In the case of more than one, explain each principle; but, don't identify a design principle without very good cause.

For more on the design principles refer to the lecture notes and Chapter 8 of the recommended text, HFOOA&D.

    (10 points)

    This class is a snippet from a console-based 2D board game implementation (think e.g. Chess or Checkers)

    class Game {
        private Piece[][] board;
        public void move() {
            /* Read user input */
            Point source = readCoordinateFromInput();
            Point dest = readCoordinateFromInput();
            /* Does the source square have a piece? Is the desination empty? */
            if (board[source.x][source.y] == null || board[dest.x][dest.y] != null)
                throw new IllegalMoveException();
            /* ... More rules here .. */
            /* Print out the current state of the board */
            printBoard();
        }

        private Point readCoordinateFromInput() {
            /* Read input from the terminal and convert to a point */
        }
        private void printBoard() {
            /* Printing code here */
        }
    }

    (10 points)

    Here is another board game example, this time just code for the board and there are both 2D and 3D boards.


    public class Square  {
        int value;
    }
    public class Board {

        private Square[][] squares;
        public void updateSquare(int x, int y, Square aSquare) {
            squares[x][y] = aSquare;
        }

        public Square getSquare(int x, int y) {
            return squares[x][y];
        }

        // ... more methods
    }

    public class ThreeDBoard extends Board {

        private Square[][][] squares;
        public void updateSquare(int x, int y, int z, Square aSquare) {
            squares[x][y][z] = aSquare;
        }

        public Square getSquare(int x, int y, int z) {
            return squares[x][y][z];
        }

        // ... more methods
    }

    (10 points)

    This code fragment configures a series of routes for a Javalin server.


    Javalin.create()
           .routes(() -> {
                 path("step0", () -> { post(myController.stepCode[0]); });
                 path("step1", () -> { post(myController.stepCode[1]); });
                 path("step2", () -> { post(myController.stepCode[2]); });
                 path("step3", () -> { post(myController.stepCode[3]); });
                 path("step4", () -> { post(myController.stepCode[4]); });
                 path("step5", () -> { post(myController.stepCode[5]); });
             })

    (10 points)

    This code defines an API for interacting with a batch computing cluster.


    public interface ClusterManager {
        public int getJobCount();
        public List<JobId> getActiveJobIds();
        public JobId startJob(Job job);
        public double getJobProgress(JobId id);
        public void waitForJobToFinish(JobId id);
        public void pauseJob(JobId id);
        public void resumeJob(JobId id);
        public List<MachineId> getMachineIds();
        public MachineId getMachineIdForJob(JobId id);
        public List<JobId> getJobsOnMachine(MachineId id);
        public double getClusterLoadPercentage();
        public DiagnosticReport runClusterDiagnostics();
        public void restartCluster();
    }

    (10 points)

    This code snippet supports two different databases for some simple operations.

     things)
        {
            for (Object item : things)
            {
                if(item instanceof SqLiteDB)
                {
                    sqLiteSave((SqLiteDB) item);
                }
                    else if(item instanceof PostgresDB)
                {
                    postgresSave((PostgresDB) item);
                }
                logger.info("DB updated");
            }
        }
        private void sqLiteSave(SqLiteDB db) {
        // ... special code for SQLite save
        }
        private void postgresSave(PostgresDB db) {
        // ... special code for Postgres save
        }
    }

    (10 points)

    This is a code fragment for a multi-sensor HVAC (heating / air conditioning) system display

    class HVACController {
        // ...
        void updateDisplay () {
            double tenInsideTemps = 0;
            double tenOutsideTemps = 0.0;
            // implemented in/out temp so far,
            // still have in/out humidity and 2nd floor temps to go
            for(int i=0; i<10; i++){
                tenInsideTemps = tenInsideTemps + insideSensor.getTemp();
                tenOutsideTemps = tenOutsideTemps + outsideSensor.getTemp();
                TimeUnit.SECONDS.sleep(1); // ten readings to average
            }
            double aveInsideTemp = tenInsideTemps / 10;
            double aveOutsideTemp = tenOutsideTemps / 10;
            display.setInsideTemp(aveInsideTemp);
            display.setOutsideTemp(aveOutsideTemp);
        }
    }

    (10 points)

    This is code for a simple customer accounts system.

    public class Customer {
        private String firstName;
        private String lastName;
        private String custNumber;
        private double balance = 0;
        // ... getters and setters too
    }

    public class Transaction {
        private Date date;
        private String description;
        private double amount;
        // ... getters and setters too
    }

    public class Account {
        private String acctId;
        private Customer customer;
        private Transaction[] transactions;

        public void deposit(double amount) { // ...
        }

        public void withdraw(double amount) { // ...
        }

        public double getBal() { // ...
        }

        public String getAcctId() { // ...
        }

        public void printStatement() { // ... print out all transactions
        }
    }



# Submission {-}
