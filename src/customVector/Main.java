package customVector;

class CustomVector<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] data;
    private int size;

    public CustomVector() {
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if (size == data.length) {
            expandCapacity();
        }
        data[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    private void expandCapacity() {
        int newCapacity = data.length * 2;
        Object[] newData = new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
}

public class Main {
    public static void main(String[] args) {
        CustomVector<Integer> customVector = new CustomVector<>();
        customVector.add(1);
        customVector.add(2);
        customVector.add(3);

        System.out.println("Size: " + customVector.size()); // Output: Size: 3
        System.out.println("Element at index 1: " + customVector.get(1)); // Output: Element at index 1: 2
    }
}

