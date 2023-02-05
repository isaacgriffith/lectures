package cofoja;

public class CofojaStackMain {

    public static void main(String[] args) {
        CofojaStack<String> s = new CofojaStack<String>();
        s.push("one");
        s.pop();
        s.push("two");
        s.push("three");
        s.pop();
        s.pop();
        s.pop(); // throws PreconditionError (instead of NoSuchElementException)
    }

}
