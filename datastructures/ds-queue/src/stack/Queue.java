package stack;

import java.util.Arrays;

public class Queue<E> {

    private E[] content;
    public int start = 0;
    public int end = 0;
    private int count = 0;
    private int size;

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        content = (E[]) new Object[size];
        this.size = size;    
    }

    /**
     * Return the object at the top of the stack, and remove it from the array.
     * @return the object at the top of the stack.
     **/
    public E poll() {
        if(empty()){
            return null;
        }
        E result = content[start];
        start = ++start % size;
        count--;
        return result;
    }

    /**
     * @return the last inserted value from the array
     **/
    public E peek() {
         if(empty()){
             return null;
        }
        return (E) content[start];
    }

    /**
     * Add an item to the array.
     * @return true if and only if the item is succesfully added to the queue.
     **/
    public boolean offer(E e) {
        if(full()){
             return false;
        }
        content[end] = e;
        end = ++end % size;
        count++;
        return true;
    }

    /**
     * @return true if and only if the stack is empty.
     **/
    public boolean empty(){
        return count == 0;
    }

    /**
     * @return true if and only if the stack is full.
     **/
    public boolean full(){
        return count == size;
    }

    @Override
    public String toString(){
        return Arrays.toString(content);
    }


}
