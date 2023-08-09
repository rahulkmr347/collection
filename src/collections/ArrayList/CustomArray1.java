package collections.ArrayList;

public class CustomArray1<T> {
    private static final int INITIAL_CAPICITY = 10;
    Object[] elements;
    private int size;

    public CustomArray1(){
        elements = new Object[INITIAL_CAPICITY];
        size = 0;
    }

    public static void main(String[] args) {
        CustomArray1<String> ca = new CustomArray1();
        ca.add("HELLO");
       // System.out.println(ca.size());
        ca.add("Rahul");
        //System.out.println(ca.size());
        System.out.println(ca.get(0));
        System.out.println(ca.get(1));
    }

    private T get(int index) {
        return (T) elements[index];
    }

    private void add(T item) {
        if (size == elements.length){
            expandCapicity();
        }
        elements[size] = item;
        size++;
    }

    private void expandCapicity() {
        int increasedCapicity = elements.length * 2;
        Object[] newElements = new Object[increasedCapicity];
        elements = newElements;
    }

    private int size(){
        return size;
    }

}
