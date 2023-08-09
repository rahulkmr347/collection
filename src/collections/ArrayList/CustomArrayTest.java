package collections.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class CustomArrayTest<T> {

    private static final int initial_capicity = 10;
    private int size;
    private Object[] elements;

    private CustomArrayTest(){
        elements = new Object[size];
        size = 0;
    }

    private void increaseCapicity() {
         int newCapicity = elements.length * 2;
         Object[] newElement = new Object[newCapicity];
         elements = newElement;

    }

    public static void main(String[] args) {
        CustomArrayTest<String> ca = new CustomArrayTest<>();
        ca.add("RAHUL");

    }

    private void add(T rahul) {
        if (size == elements.length){
            increaseCapicity();
        }
        elements[size] = rahul;
        size++;
    }
}
