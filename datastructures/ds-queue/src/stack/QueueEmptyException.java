package stack;

public class QueueEmptyException extends RuntimeException{

    public QueueEmptyException(){
        super();
    }

    public QueueEmptyException(String msg){
        super(msg);
    }

}
