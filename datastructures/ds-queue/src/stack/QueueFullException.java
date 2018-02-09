package stack;

public class QueueFullException extends RuntimeException{

    public QueueFullException(){
        super();
    }

    public QueueFullException(String msg){
        super(msg);
    }

}
