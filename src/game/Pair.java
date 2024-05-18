package game;

/**
 * Generic pair class.
 * @author Corentin L. / Seweryn C.
 * @param <T> Type for both values of the pair
 */

public class Pair<T> {
    /** First value of the pair */
    private final T first;

    /** Second value of the pair */
    private final T second;

    /**
     * Constructor for Pair class
     * @param first Value
     * @param second Values
     */
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Getter for first element of Pair
     * @return First element of Pair
     */
    public T getFirst() {
        return first;
    }

    /**
     * Getter for second element of Pairs
     * @return Second element of Pair
     */
    public T getSecond() {
        return second;
    }
}