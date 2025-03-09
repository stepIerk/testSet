
import java.util.Arrays;
import java.lang.String;






public class stepanSet implements mySet {

    private int size;
    private int[] arr;

    public stepanSet(int size){
        this.size = size;
        arr = new int[size];
    }

    public stepanSet(int[] arr) {
        this.size = 0;
        this.arr = new int[size];
        for (int elem : arr) {
            add(elem);
        }
    }


    private void sortSet(){
        Arrays.sort(this.arr);
    }

    @Override
    public int[] getArr() {
        return Arrays.copyOf(arr, size);
    }

    @Override
    public void add(int value) {
        if (!contains(value)) {
            size++;
            int[] newArr = new int[size];
            System.arraycopy(arr, 0, newArr, 0, size - 1);
            newArr[size - 1] = value;
            arr = newArr;
            sortSet();
        }
    }

    @Override
    public void add(int[] arr) {
        for (int elem : arr) {
            add(elem);
        }
    }

    @Override
    public void removeByIndex(int index) {
        size--;
        int[] newArr = new int[size];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(arr, index + 1, newArr, index, size - index);
        arr = newArr;
        sortSet();
    }

    @Override
    public void removeByValue(int value) {
        if (contains(value)) {
            int index = getIndex(value);
            removeByIndex(index);
        }
    }

    @Override
    public boolean contains(int value) {
        for (int element : arr) {
            if (value == element) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void printArr(){
        System.out.print("Arr: ");
        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    @Override
    public int getValue(int index) {
        return arr[index];
    }

    @Override
    public int getIndex(int value) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        arr = new int[size];
    }

    @Override
    public boolean compare(stepanSet s2) {
        if (this.size != s2.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i] != s2.arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void iterate(String operator, int value) {
        for (int i = 0; i < size; i++) {
            switch (operator) {
                case "+":
                    arr[i] += value;
                    break;
                case "-":
                    arr[i] -= value;
                    break;
                case "*":
                    arr[i] *= value;
                    break;
                case "/":
                    arr[i] = (int) (arr[i] / value);
                    break;
                case "^":
                    arr[i] = (int) Math.pow(arr[i], value);
                    break;
                case "%":
                    arr[i] %= value;
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        return sum;
    }

    @Override
    public void reverse() {
        for(int i = 0; i < size / 2; i++){
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }
    }

//    @Override
//    public void iterate(Runnable r) {
//        for (int i = 0; i < size; i++) {
//            r.run();
//            System.out.println(arr[i]);
//        }
//    }


    public static void printTestName(String testName){
        System.out.println("_________________________");
        System.out.println(testName);
    }


    public static void main(String[] args) {
        int[] arr = {1, 56, 3, 4, 5, 5, 3, 1, 2};
        int[] addArr = {10, 20, 30};
        int[] secondArr = {1, 56, 3, 4, 5, 5, 3, 1};
        stepanSet s1 = new stepanSet(arr);
        stepanSet s2 = new stepanSet(secondArr);

        s1.printArr();

        // add
        printTestName("add: 5 ");
        s1.add(5);
        s1.printArr();

        // addArr
        printTestName("addArr: [10, 20, 30]");
        s1.add(addArr);

        s1.printArr();

        // remove
        // removeByIndex
        printTestName("remove: index = 3");
        s1.removeByIndex(3);
        s1.printArr();
        // removeByValue
        printTestName("remove: value = 1");
        s1.removeByValue(1);
        s1.printArr();

        // contains
        printTestName("contains: 5");
        System.out.println(s1.contains(5));

        // isEmpty
        printTestName("isEmpty");
        System.out.println(s1.isEmpty());

        // getValue
        printTestName("getValue: index = 3");
        System.out.println(s1.getValue(3));

        // getIndex
        printTestName("getIndex: value = 5");
        System.out.println(s1.getIndex(5));

        // length
        printTestName("length");
        System.out.println(s1.length());
        s1.printArr();


        // compare
        printTestName("compare");
        stepanSet s3 = s1;

        System.out.println(s1.compare(s2));
        System.out.println(s1.compare(s3));

        // iterate
        printTestName("iterate:");
        System.out.print("Before iterate: ");
        s1.printArr();
        System.out.println("+10");
        s1.iterate("+", 10);
        s1.printArr();
        System.out.println("-10");
        s1.iterate("-", 10);
        s1.printArr();
        System.out.println("*2");
        s1.iterate("*", 2);
        s1.printArr();

        // getSum
        printTestName("getSum");
        System.out.println(s1.getSum());

        // reverse
        printTestName("reverse");
        s1.reverse();
        s1.printArr();

        // clear
        printTestName("clear");
        s1.clear();
        s1.printArr();
    }

}
