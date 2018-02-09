package nl.movep.sequence;

public class Sequence {

    private double value;
    private boolean empty;
    private Sequence next;

    private Sequence(double v, Sequence n, boolean e) {
        super();
        value = v;
        next = n;
        empty = e;
    }

    public Sequence() {
        this(0, null, true);
    }

    public Sequence(double v) {
        this(v, new Sequence(), false);
    }

    public Sequence(double v, Sequence n) {
        this(v, n, false);
    }

    public boolean isEmpty() {
        return empty;
    }

    public Sequence add(double val) {
        return new Sequence(val, this);
    }

    public Sequence addAll(double[] values) {
        Sequence seq = this;
        for ( double value : values ) {
            seq = seq.add(value);
        }
        return seq;
    }

    public static Sequence create(double[] values) {
        return (new Sequence()).addAll(values);
    }

    public double head() throws EmptySequenceException {
        if ( !empty ) {
            return value;
        }
        throw new EmptySequenceException();
    } 

    public Sequence tail() throws EmptySequenceException {
        if ( !empty ) {
            return next;
        }
        throw new EmptySequenceException();
    }

    /**
     * Return the size of the sequence.
     * @return the size.
     **/
    public int size() {
        return size(this);
    }

    /**
     * Return the size of the sequence.
     * @param seq the sequence.
     * @return the size.
     **/
    public int size(Sequence seq) {
        try {
            return 1 + size(seq.tail());
        } catch (EmptySequenceException e) {
            return 0;
        }
    }

    public String toString() {
        if ( empty ) {
            return "empty";
        }
        return value + ", " + next.toString();
    }
}
