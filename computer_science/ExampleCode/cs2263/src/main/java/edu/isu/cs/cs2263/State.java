package edu.isu.cs.cs2263;

public class State implements Comparable<State> {

    private String name;

    public State(String name) {
        this.name = name;
    }

    public int compareTo(State state) {
        return name.compareTo(state.name);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof State) {
            State state = (State) object;
            return compareTo(state) == 0;
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("State{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
