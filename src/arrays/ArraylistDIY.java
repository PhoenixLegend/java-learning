package arrays;

import charactor.Hero;

/**
 * DIY an ArrayList collection
 * 2019/9/3
 */
public class ArraylistDIY {
    /**
     * value is to storage objects
     * size is this list length
     */
    private Object[] value;
    private int size;

    public ArraylistDIY() {
        //value = new Object[16];
        this(16);
        //just call another constructor
    }

    public ArraylistDIY(int size) {
        value = new Object[size];
    }
    public int size(){
        return size;
    }

    public void add(Object object) {
        // size is started with 0 of course
        value[size] = object;
        size++;
        // check weather list is full
        if (size >= value.length) {
            // or you can use System.arraycopy()
            Object[] new_value = new Object[size * 2];
            // in formal codes, i misunderstand the value of i to i <= size which is out of index boundary.
            for (int i = 0; i < size; i++) {
                new_value[i] = value[i];
            }
            value = new_value;
        }
    }

    public Object get(int index) {
        rangecheck(index);
        return value[index];

    }

    private void rangecheck(int index) {
        if (index < 0 || index > size - 1) // [0,size-1]
            try {
                throw new Exception();
                // manually throw an exception and shutdown the program
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    /**
     * init variables
     * boolean        false
     *
     * char              '/uoooo'(null)
     *
     * byte              (byte)0
     *
     * short             (short)0
     *
     * int                  0
     *
     * long               0L
     *
     * float               0.0f
     *
     * double           0.0d
     */
}
