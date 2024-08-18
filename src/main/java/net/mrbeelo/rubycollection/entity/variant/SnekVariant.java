package net.mrbeelo.rubycollection.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum SnekVariant {
    GREEN(0),
    RED(1);

    private static final SnekVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(
            SnekVariant::getId)).toArray(SnekVariant[]::new);
    private final int id;

    SnekVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SnekVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
