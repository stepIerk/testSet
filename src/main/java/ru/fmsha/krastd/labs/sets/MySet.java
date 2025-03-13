package ru.fmsha.krastd.labs.sets;


import java.util.OptionalDouble;
import java.util.OptionalInt;

public interface MySet extends Iterable<Integer> {
    boolean isEmpty();

    void add(int value);

    void addAll(int[] arr);

    boolean remove(int value);

    boolean contains(int value);

    int getSize();

    void clear();

    OptionalInt getMax();

    OptionalInt getMin();

    OptionalDouble getAvg();
}
