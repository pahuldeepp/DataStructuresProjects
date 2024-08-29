/**
 * A class representing a peg with a colour.
 * Name Pahuldeep Singh
 * Student 3153555
 * 
 */
public class Peg {
    private Colour colour; // The colour of the peg

    /**
     * Constructs a peg with no colour.
     */
    public Peg() {
        this.colour = null;
    }

    /**
     * Constructs a peg with the specified colour.
     * @param colour the colour of the peg
     */
    public Peg(Colour colour) {
        this.colour = colour;
    }

    /**
     * Returns the colour of the peg.
     * @return the colour of the peg
     */
    public  Colour getColour() {
        return this.colour;
    }

    /**
     * Sets the colour of the peg.
     * @param colour the colour of the peg
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * Checks if this peg is equal to another object.
     * Two pegs are equal if they have the same colour.
     * @param o the object to compare with this peg
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Peg other = (Peg) o;

        return this.colour.equals(other.colour);
    }
}
