public interface mySet {
    int[] getArr();
    void add(int value);
    void add(int[] arr);
    void removeByIndex(int index);
    void removeByValue(int value);
    boolean contains(int value);
    boolean isEmpty();
    void printArr();
    int getValue(int index);
    int getIndex(int value);
    int length();
    void clear();
    boolean compare(stepanSet s2);
//    void iterate(Runnable r);
    void iterate(String operator, int value); // для каждого элемента осуществляется математическая операция
    int getSum();
    void reverse();
}
