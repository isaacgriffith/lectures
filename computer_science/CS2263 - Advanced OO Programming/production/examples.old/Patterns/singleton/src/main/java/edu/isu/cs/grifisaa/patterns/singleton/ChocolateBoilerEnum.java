package edu.isu.cs.grifisaa.patterns.singleton;

import lombok.Getter;

public enum ChocolateBoilerEnum {

    INSTANCE;

    @Getter
    private boolean empty;

    @Getter
    private boolean boiling;


}
