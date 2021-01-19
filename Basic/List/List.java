import java.util.ArrayList;
import java.util.Collections;

public class List implements Cloneable {
    private int capacity;
    private ArrayList<Integer> array;

    public List() {
        this(100);
    }

    public List(int capacity) {
        this.array = new ArrayList<Integer>(capacity);
    }

    public int size() {
        return array.size();
    }

    public void erase(int index) throws ZeroLenException {
        if (array.isEmpty()) {
            throw new ZeroLenException();
        }
        array.remove(index);
    }

    public void insert(int value, int index) {
        if (index >= 0 && index <= array.size()) {
            array.add(index, value);
        } else {
            System.out.println("There is no index: %d. Value is added to the and of list.");
            array.add(value);
        }
    }

    public int find(int value) {
        return array.indexOf(value);
    }

    public void push_back(int value) {
        array.add(value);
    }

    public int pop_back() throws ZeroLenException {
        if (array.isEmpty()) {
            throw new ZeroLenException();
        }
        return array.remove(array.size()-1);
    }

    public void sort() {
        Collections.sort(array);
    }

    public int getValue(int index) {
        return array.get(index);
    }
    public void show() {
        int limit = size() - 1;
        System.out.print("(");
        for ( int index = 0; index < limit; index++ ) {
            System.out.print(getValue(index) + ", ");
        }
        System.out.print(getValue(limit));
        System.out.println(")");
    }

    public List clone() throws CloneNotSupportedException {
        return (List) super.clone();
    }
}