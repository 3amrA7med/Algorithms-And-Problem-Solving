package com.exercise.utils;

import java.util.Objects;

public class Pair<T> {
    T x;
    T y;

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Pair (T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?> pair = (Pair<?>) o;
        return Objects.equals(x, pair.x) && Objects.equals(y, pair.y);
    }
}
