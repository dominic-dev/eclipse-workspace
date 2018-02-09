package stack;

import java.util.Arrays;

public class Stack<E> {

    private final int EMPTY = 0;
    private E[] content;
    private int pointer = EMPTY;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        content = (E[]) new Object[size];
        this.size = size;    
    }

    /**
     * Return the object at the top of the stack, and remove it from the array.
     * @return the object at the top of the stack.
     * @throws StackEmptyException
     **/
    public E pop() throws StackEmptyException {
        if(empty()){
            throw new StackEmptyException("The stack is empty");
        }
        return (E) content[--pointer];
    }

    /**
     * @return the last inserted value from the array
     * @throws StackEmptyException
     **/
    public E peek() throws StackEmptyException {
         if(empty()){
            throw new StackEmptyException("The stack is empty");
        }
        return (E) content[pointer - 1];
    }

    /**
     * Add an item to the array.
     * @throws StackFullException
     **/
    public void push(E e) throws StackFullException {
         if(full()){
            throw new StackFullException("The stack is full.");
        }
        content[pointer++] = e;
    }

    /**
     * @return true if and only if the stack is empty.
     **/
    public boolean empty(){
        return pointer == EMPTY;
    }

    /**
     * @return true if and only if the stack is full.
     **/
    public boolean full(){
        return pointer == size;
    }

    @Override
    public String toString(){
        return Arrays.toString(content);
    }


}
