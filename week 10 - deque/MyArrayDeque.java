import java.util.Arrays;
public class MyArrayDeque implements DirectAccessDeque {
    String[] arr;
    int INITIAL_SIZE = 2;
    int current_max_size;
    int front;
    int back;
    int size;

    /**
     * CONSTRUCTOR
     */
    public MyArrayDeque() {
        arr = new String[INITIAL_SIZE];
        current_max_size = INITIAL_SIZE;
        front = current_max_size - 1;
        back = 0;
        size = 0;
    }

    @Override
    public void addFirst(String elt) {
        if (front == back) {
            // TODO double array size when front==back
            int newMaxSize = arr.length * 2;
            String [] tempArr = new String[newMaxSize];
            // copy same "back" elements
            for (int i = 0; i < back; ++i) {
                tempArr[i] = arr[i];
            }
            // copy same "front" elts
            int newFront = newMaxSize - (current_max_size - front);
            int trav = current_max_size - front;
            for (int i = 0; i < trav; ++i) {
                tempArr[newFront + i] = arr[front + i];
            }
            arr = Arrays.copyOf(tempArr, tempArr.length);
            current_max_size = newMaxSize;
            front = newFront;
        }
        arr[front] = elt;
        --front;
        ++size;
    }

    @Override
    public void addLast(String elt) {
        if (front == back) {
            // TODO double array size when front==back
            int newMaxSize = arr.length * 2;
            String [] tempArr = new String[newMaxSize];
            // copy same "back" elements
            for (int i = 0; i < back; ++i) {
                tempArr[i] = arr[i];
            }
            // copy same "front" elts
            int newFront = newMaxSize - (current_max_size - front);
            int trav = current_max_size - front;
            for (int i = 0; i < trav; ++i) {
                tempArr[newFront + i] = arr[front + i];
            }
            arr = Arrays.copyOf(tempArr, tempArr.length);
            current_max_size = newMaxSize;
            front = newFront;
        }
        arr[back] = elt;
        ++back;
        ++size;
    }

    @Override
    public String removeFirst() {
        String temp = arr[front];
        ++front;
        --size;
        return temp;
    }

    @Override
    public String removeLast() {
        String temp = arr[back];
        --back;
        --size;
        return null;
    }

    @Override
    public String getFirst() {
        return arr[front];
    }

    @Override
    public String getLast() {
        return arr[back];
    }

    @Override
    public String get(int index) {
        //TODO fix this one index = (front + index) - (curmaxsize-1)
        int convertedIndex = front + index;
        if (convertedIndex > current_max_size - 1) {
            convertedIndex = (front + index) - (current_max_size - 1);
        }
        return arr[convertedIndex];
    }

    @Override
    public int size() {
        return size;
    }

}
