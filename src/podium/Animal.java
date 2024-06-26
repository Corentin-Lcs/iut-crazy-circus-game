package podium;

import color.Color;

/**
 * Enumeration of animals.
 * @author Corentin L. / Seweryn C.
 */

public enum Animal {
    /**
     * Lion
     * @see Color.ANSI
     */
    LION(Color.ANSI.YELLOW),
    
    /**
     * Elephant
     * @see Color.ANSI
     */
    ELEPHANT(Color.ANSI.GREY),

    /**
     * Bear
     * @see Color.ANSI
     */
    BEAR(Color.ANSI.WHITE);

    /**
     * Constant for the number of animals
     */
    public static final int NUMBER_OF_ANIMALS = Animal.values().length;

    /**
     * Color of the animal (used for display)
     * @see Color.ANSI
     */
    private final Color.ANSI color;

    /**
     * Constructor of the class
     * @param color Color of the animal
     */
    Animal(Color.ANSI color) {
        this.color = color;
    }

    /**
     * Getter for the color of the animal
     * @return Color of the animal
     */
    public Color.ANSI getColor() {
        return color;
    }

    /**
     * String representation of the animal
     * @return String representation of the animal
     */
    @Override
    public String toString() {
        switch (this) {
        case LION:
            return "LION";
        case ELEPHANT:
            return "ELEPHANT";
        case BEAR:
            return "OURS";
        default:
            return "";
        }
    }
}