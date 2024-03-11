import java.util.HashSet;
import java.util.Random;

/**
 * The GalacticMap class represents the grid-based map of the galactic space.
 * It stores information about the positions of spaceships and provides methods
 * for managing the entities within the map.
 *
 * <p>
 * This class contains functionality to add fighters, retrieve a list of
 * reported spaceships,
 * and check three game winning conditions for the galactic space.
 * </p>
 *
 * @author Parisa Daeijavad
 */

public class GalacticMap {
    private Spaceship[][] grid; // 2D array representing the grid of the galactic map
    private int fighterNumber = 0; // Counter for the number of fighters in the map
    private HashSet<Spaceship> reportList = new HashSet<Spaceship>(); // Set to store reported fighter spaceships

    /**
     * Constructs a GalacticMap object with the specified size.
     *
     * @param size The size of the grid for the galactic map.
     */
    public GalacticMap(int size) {
        this.grid = new Spaceship[size][size];
    }

    /**
     * Adds a fighter spaceship to the report list.
     *
     * @param fighter The fighter spaceship to add to the report list.
     */
    public void AddReportedFighter(FighterShip fighter) {
        reportList.add(fighter);
    }

    /**
     * Adds one to the count of fighters in the GalacticMap.
     */
    public void addOneFighter() {
        fighterNumber++;
    }

    /**
     * Retrieves the spaceship at the specified coordinates in the GalacticMap.
     *
     * @param x The x-coordinate of the position to retrieve the spaceship.
     * @param y The y-coordinate of the position to retrieve the spaceship.
     * @return The spaceship at the specified coordinates.
     */
    public Spaceship getSpaceshipAt(int x, int y) {
        return this.grid[x][y];
    }

    /**
     * Retrieves a random spaceship from the GalacticMap.
     *
     * @return A random spaceship from the GalacticMap.
     */
    public Spaceship getRandomSpaceship() {
        Random random = new Random();
        Spaceship randomSpaceship = null;

        // Keep generating random coordinates until a non-null grid cell is found
        while (randomSpaceship == null) {
            int randomX = random.nextInt(grid.length);
            int randomY = random.nextInt(grid[0].length);
            randomSpaceship = grid[randomX][randomY];
        }

        return randomSpaceship;
    }

    /**
     * Returns a string representation of the GalacticMap.
     *
     * ...............
     *
     */
    @Override
    public String toString() {
        int x = grid.length, y = grid[0].length;
        String ans = "";
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                ans += "[";
                if ((grid[i][j].getID()).length() == 0)
                    for (int k = 0; k < 9; k++)
                        ans += (char) 0;
                else {
                    ans += (char) 0;
                    ans += grid[i][j].getName2();
                    ans += (char) 0;
                }
                ans += "]";
            }
            ans += "\n";
        }
        return ans;
    }

    /**
     * Removes the spaceship at the specified coordinates in the GalacticMap.
     *
     * @param x The x-coordinate of the position to remove the spaceship.
     * @param y The y-coordinate of the position to remove the spaceship.
     */
    public void removeSpaceshipAt(int x, int y) {
        this.grid[x][y] = null;
    }

    /**
     * Moves the specified spaceship to the new coordinates in the GalacticMap.
     *
     * ........
     *
     */
    public void moveSpaceshipTo(Spaceship spaceship, int newX, int newY) {
        if (!isValidMove(newX, newY))
            return;
        if (isCollision(newX, newY))
            return;
        int x = grid.length, y = grid[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == null)
                    continue;
                if (grid[i][j].getID() == spaceship.getID()) {
                    this.grid[i][j] = null;
                }
            }
        }
        // for(int i = 0)
        this.grid[newX][newY] = spaceship;
        if (spaceship.getType() == SpaceshipType.CARGOSHIP) {
            // spaceship.

            if (newX == spaceship.getTargetX()) {
                // do something
            }
        }
        // ....
    }

    /**
     * Checks if the specified coordinates represent a valid move within the
     * GalacticMap grid.
     *
     * ............
     *
     */
    private boolean isValidMove(int newX, int newY) {
        // Check if the new position is within the grid boundaries
        int x = grid.length, y = grid[0].length;
        if (newX < 0 || newY < 0 || newX >= x || newY >= y)
            return false;
        return true;
    }

    /**
     * Checks if the specified coordinates represent a collision with another
     * spaceship.
     *
     * .......
     *
     */
    private boolean isCollision(int newX, int newY) {
        // Check if the new position is occupied by another spaceship
        assert (isValidMove(newX, newY));
        if (grid[newX][newY] == null)
            return true;
        return false;
    }

    /**
     * Places the specified spaceship, that is read from the file, in the
     * GalacticMap.
     *
     * .............
     *
     */
    public void placeSpaceship(Spaceship spaceship) {
        // Place the spaceship in its position
        grid[spaceship.getX()][spaceship.getY()] = spaceship;
    }

    public void placeSpaceship(FighterShip spaceship) {
        grid[spaceship.getX()][spaceship.getY()] = spaceship;
    }

    /**
     * Checks if all cargoes have reached their destinations.
     *
     * ..............
     *
     */
    public boolean allCargoesReachedDestination() {
        // ...
        // Check if all cargoes have reached their destination
        // ...
        int tol = 0;
        // for(int i = 0; i < )
    }

    /**
     * Checks if all explorers and cargoes have been removed by fighters.
     *
     * ............
     *
     */
    public boolean allExplorersAndCargoesRemoved() {

    }

    /**
     * Checks if all fighters have been reported by explorers.
     *
     * ................
     *
     */
    public boolean allFightersReported() {
        // Check if explorers have interacted/reported all fighters

    }
}
