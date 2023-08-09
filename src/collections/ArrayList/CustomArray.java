package collections.ArrayList;

public class CustomArray<T> {
    private static final int initial_cap = 10;
    private int size;
    private Object[] elements;

    public CustomArray(){
        elements = new Object[initial_cap];
        size = 0;
    }

    public static void main(String[] args) {
        CustomArray<String> ca = new CustomArray<>();
        ca.add("Rahul");
        ca.add("HOME");
        System.out.printf("size"+ " " + ca.getSie());
        System.out.println(ca.get(0));
        System.out.println(ca.get(1));
    }

    private T get(int item) {
        return (T) elements[item];
    }

    private int getSie() {
        return size;
    }

    private void add(T item) {
        if (size == elements.length){
            expandCapicity();
        }
       elements[size] = item;
        size++;
    }

    private void expandCapicity() {
        int newCapicity = elements.length * 2;
        Object[] newElement = new Object[newCapicity];
        elements = newElement;

    }
}
