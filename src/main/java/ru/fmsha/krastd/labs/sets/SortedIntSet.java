package ru.fmsha.krastd.labs.sets;

import java.util.Arrays;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;



import static java.util.Arrays.sort;

public class SortedIntSet implements MySet {
    private int size;
    private int[] arr;

    public SortedIntSet(int size) {
        this.size = 0;
        arr = new int[size];
    }

    public SortedIntSet(int[] arr) {
        this.size = 0;
        this.arr = new int[arr.length];
        for (int elem : arr) {
            add(elem);
        }
    }

    @Override
    public void add(int value) {
        if (contains(value)) {
            return;
        }
        if (size >= arr.length) {
            increaseSize();
        }
        arr[size++] = value;
        sort(arr, 0, size);
    }

    private void increaseSize() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    @Override
    public void addAll(int[] arr) {
        for (int elem : arr) {
            add(elem);
        }
    }

    @Override
    public boolean remove(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.arraycopy(arr, i + 1, arr, i, size - i);
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(int value) {
        return Arrays.binarySearch(arr, 0, size, value) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }


    @Override
    public OptionalInt getMax() {
        if (isEmpty()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(arr[size - 1]);
    }

    @Override
    public OptionalInt getMin() {
        if (isEmpty()) {
            return OptionalInt.empty();
        }
        return OptionalInt.of(arr[0]);
    }

    @Override
    public OptionalDouble getAvg() {
        if (isEmpty()) {
            return OptionalDouble.empty();
        }
        int sum = 0;
        for (int elem : arr) {
            sum += elem;
        }
        double result = (double) sum / size;
        return OptionalDouble.of(result);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new SortedIntSetIterator();
    }

    private class SortedIntSetIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new IllegalStateException();
            }
            return arr[currentIndex++];
        }
    }

    public boolean equals(SortedIntSet that) {
        return size == that.size &&
                Arrays.compare(arr, 0, size, that.arr, 0, that.size) == 0;
    }
}
