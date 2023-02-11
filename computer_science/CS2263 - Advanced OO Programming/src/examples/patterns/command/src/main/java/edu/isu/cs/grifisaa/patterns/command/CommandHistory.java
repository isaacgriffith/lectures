import java.util.Stack;

public class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        if (c instanceof UndoCommand)
          return;
        history.push(c);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
