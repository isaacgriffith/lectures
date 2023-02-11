package edu.isu.cs.grifisaa.patterns.singleton;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public abstract class AbstractChocolateBoiler implements ChocolateBoiler {

    @Getter
    private boolean empty;
    @Getter
    private boolean boiled;

    protected AbstractChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled())
            empty = true;
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }
}
