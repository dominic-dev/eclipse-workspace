package stack;

public class StackFullException extends RuntimeException{

    public StackFullException(){
        super();
    }

    public StackFullException(String msg){
        super(msg);
    }

}
