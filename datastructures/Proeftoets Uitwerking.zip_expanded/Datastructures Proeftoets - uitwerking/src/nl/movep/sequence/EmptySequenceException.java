package nl.movep.sequence;

public class EmptySequenceException extends Exception {
  
  private static final long serialVersionUID = 2455779210873035276L;

  public EmptySequenceException() {
    super();
  }
  
  public EmptySequenceException(String msg) {
    super(msg);
  }
}
