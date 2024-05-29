package Session;

public class MyArrayList <E>{
    

    static final int initialCapacity = 2;
    E[] data = (E[]) new Object[initialCapacity];
    int size = 0;

    public MyArrayList(){

    }

    void checkIndex(int index){
        if(index < 0 && index > data.length){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    void ensureCapacity(int index){
        if(size >= data.length){
            System.out.println("Max capacity detected! Doubling the size before inserting a new element");
            E[] newData = (E[])(new Object[size * 2]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    //Add a new element to the specified index
    public void add(int index, E e){
        checkIndex(index);
        ensureCapacity(index);


        //Move the elements to the right
        for(int i = size - 1; i >= index; i--)
            data[i+1] = data[i];

        //Insert a new element to data[index]
        data[index] = e;

        //Increase the size by 1
        size++;
    }
}
