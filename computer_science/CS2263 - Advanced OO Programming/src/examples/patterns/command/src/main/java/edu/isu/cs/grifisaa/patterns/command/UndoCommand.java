public class UndoCommand extends Command {

  public UndoCommand(Editor editor) { super(editor); }

  public boolean execute() {
    if (editor.getHistory().isEmpty()) return false;

    Command command = editor.getHistory().pop();
    if (command != null) {
        command.undo();
    }

    return true;
  }

  public void undo() {

  }
}
