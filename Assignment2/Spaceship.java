/**
 * The abstract class Spaceship represents a generic spaceship entity in the
 * galactic space.
 * It defines common attributes and behaviors for different types of spaceships.
 * 
 * @author Parisa Daeijavad
 */
public abstract class Spaceship {

    // attributes:

    // The unique identifier of the spaceship
    // The current coordinates of the spaceship
    // The type of the spaceship
    private SpaceshipType type;
    private String ID = "";
    private int X = -1, Y = -1;
    // private int Damage = -1, ScanRange = -1;
    // private int cargoCapacity = -1, CurrentCargo = -1, targetX = -1, targetY =
    // -1;
    // methods:

    /**
     * Constructs a Spaceship object with the specified attributes.
     *
     * @param ....
     *
     */
    // constructor goes here...
    public Spaceship(SpaceshipType s, String id, int x, int y) {
        this.X = x;
        this.Y = y;
        this.ID = id;
        this.type = s;
    }
    /*
     * targetX = tarx;
     * targetY = tary;
     * cargoCapacity = cap;
     * CurrentCargo = cur;
     */

    /**
     * Abstract method to define the movement behavior of the spaceship.
     *
     * @param ...
     */
    // move ....
    public abstract void move(GalacticMap galacticMap);

    /**
     * Abstract method to define the interaction behavior of the spaceship with
     * another spaceship.
     *
     * @param ....
     */
    public abstract void interact(GalacticMap galacticMap, Spaceship other);
    // interact ...

    // Getters and setters

    /**
     * Retrieves the unique identifier of the spaceship.
     *
     * ....
     */
    // getID
    public String getID() {
        return ID;
    }

    /**
     * Retrieves the current x-coordinate of the spaceship.
     *
     * ....
     */
    // getX
    public int getX() {
        return X;
    }

    /**
     * Retrieves the current y-coordinate of the spaceship.
     *
     * .....
     */
    // getY
    public int getY() {
        return Y;
    }

    /**
     * Retrieves the type of the spaceship.
     *
     * .....
     */
    // getType
    public SpaceshipType getType() {
        return type;
    }

    /**
     * Sets the x-coordinate of the spaceship to the specified value.
     *
     * @param ....
     */
    // setX
    public void setX(int temp) {
        X = temp;
    }

    /**
     * Sets the y-coordinate of the spaceship to the specified value.
     *
     * @param .....
     */
    // setY
    public void setY(int temp) {
        Y = temp;
    }

    /**
     * Calculates the distance between this spaceship and another spaceship.
     *
     * @param other The other spaceship to calculate the distance to.
     * @return The distance between this spaceship and the other spaceship.
     */
    public int calculateDistance(Spaceship other) {
        int deltaX = Math.abs(this.getX() - other.getX());
        int deltaY = Math.abs(this.getY() - other.getY());
        return Math.max(deltaX, deltaY);
    }

    /**
     * Retrieves the name of the spaceship.
     *
     * @return The name of the spaceship, which includes its type and ID.
     */
    public String getName() {
        return this.getType() + " " + this.getID();
    }

    public String getName2() {
        // SpaceshipType a = FIGHTER;
        char temp;
        if (type == SpaceshipType.FIGHTER)
            temp = 'F';
        else if (type == SpaceshipType.EXPLORER)
            temp = 'E';
        else
            temp = 'C';
        return temp + "-" + this.getID();
    }
}
