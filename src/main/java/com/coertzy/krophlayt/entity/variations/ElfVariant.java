package com.coertzy.krophlayt.entity.variations;

import java.util.Arrays;
import java.util.Comparator;

public enum ElfVariant {
    DEFAULT(0),
    ONE (1),
    TWO (2),
    THREE(3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    TEN (10),
    ELEVEN (11);

    private static final ElfVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ElfVariant::getId)).toArray(ElfVariant[]::new);
    private final int id;

    ElfVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ElfVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
