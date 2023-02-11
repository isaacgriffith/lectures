package edu.isu.cs.cs2263.patterns.singleton;

import java.util.Objects;
import java.util.UUID;

public class WithHelper {

    private String name = "Foo";
    private String other = "Bar";
    private final UUID id;

    private WithHelper() {
        id = UUID.randomUUID();
    }

    private static final class Helper {
        private static final WithHelper INSTANCE = new WithHelper();
    }

    public static WithHelper instance() {
        return Helper.INSTANCE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WithHelper)) return false;

        WithHelper that = (WithHelper) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 31 * ((id != null ? id.hashCode() : 0)) + (id != null ? id.hashCode() : 0);
    }
}
