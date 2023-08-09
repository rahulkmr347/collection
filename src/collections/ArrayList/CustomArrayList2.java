package collections.ArrayList;

public class CustomArrayList2<T> {
    private static final int Initial_Capicity = 10;
    private Object[] elements;
    private int size;

    private CustomArrayList2(){
        elements = new Object[Initial_Capicity];
        size = 0;
    }

    public static void main(String[] args) {
        CustomArrayList2<String> ca = new CustomArrayList2<>();
        ca.add("Hellozzz");
        ca.add("Rahul");
        System.out.println(ca.get(0));
        System.out.println(ca.get(1));
    }

    private T get(int index) {
        return (T) elements[index];
    }

    private void add(T item) {
        if (size == elements.length){
            increaseCapicity();
        }
        elements[size] = item;
        size++;
    }

    private void increaseCapicity() {
        int newCapicity = elements.length * 2;
        Object[] newElements = new Object[newCapicity];
        elements = newElements;
    }
}
