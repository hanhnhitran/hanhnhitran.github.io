
/**
 * The FileReader class provides static methods for reading data from a file and constructing a GalacticMap object.
 * It reads a text file containing information about spaceships and their attributes, and initializes a GalacticMap
 * based on the data read from the file.
 *
 * @author Parisa Daeijavad
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {

    /**
     * Reads data from a specified file and constructs a GalacticMap object based on
     * the information read.
     *
     * @param fileName the name of the file to read from
     * @return a GalacticMap object initialized with data read from the file
     * @throws RuntimeException if the file specified by fileName is not found or if
     *                          an error occurs while reading the file
     *
     */

    public static GalacticMap readFromFile(String fileName) {
        final String tempo = fileName;
        File temp = new File(tempo);
        Scanner myScanner = new Scanner(System.in);
        try {
            myScanner = new Scanner(temp);
        } catch (IOException e) {
            System.out.println("File not found " + fileName);
        }
        int sz = 0;
        try {
            sz = myScanner.nextInt();
        } catch (NumberFormatException e) {
            System.out.println("Invalid file format: Missing map \r\n" + "size.");
        }
        GalacticMap mp = new GalacticMap(sz);
        myScanner.nextLine();
        while (myScanner.hasNextLine()) {
            String type = "", ID = "";
            try {
                type = myScanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data format: Missing spaceship attributes.");
            }
            try {
                ID = myScanner.next();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data format: Missing spaceship attributes.");
            }
            int x = 0, y = 0;
            try {
                x = myScanner.nextInt();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data format: Missing spaceship attributes.");
            }
            try {
                y = myScanner.nextInt();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid data format: Missing spaceship attributes.");
            }
            if (type == "FIGHTER") {
                int damage = 0;
                try {
                    damage = myScanner.nextInt();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid data format: Missing spaceship attributes.");
                }
                //Spaceship temp_spaceship = new FighterShip(ID, x, y, damage);
                //temp_spaceship.get_dam();
//                mp.placeSpaceship(temp_spaceship);
                // FighterShip temp_spaceship2 = mp.grid[x][y];
//                mp.grid[x][y].get_dam();
            } else if (type == "EXPLORER") {
                int explore = 0;
                try {
                    explore = myScanner.nextInt();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid data format: Missing spaceship attributes.");
                }
                ExplorerShip temp_spaceship = new ExplorerShip(ID, x, y, explore);
                mp.placeSpaceship(temp_spaceship);
            } else if (type == "CARGOSHIP") {
                int cap = 0, cur = 0, tarx = 0, tary = 0;
                try {
                    cap = myScanner.nextInt();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid data format: Missing spaceship attributes.");
                }
                try {
                    cur = myScanner.nextInt();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid data format: Missing spaceship attributes.");
                }
                try {
                    tarx = myScanner.nextInt();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid data format: Missing spaceship attributes.");
                }
                try {
                    tary = myScanner.nextInt();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid data format: Missing spaceship attributes.");
                }
                CargoShip temp_spaceship = new CargoShip(ID, x, y, cap, cur, tarx, tary);
                mp.placeSpaceship(temp_spaceship);
            } else {
                throw new IllegalArgumentException("Invalid spaceship type: " + type);
            }
            if (mp.getSpaceshipAt(x, y) != null) {
                throw new IllegalArgumentException("Wrong input file! the position is filled with another item!");
            }
            if (x < 0 || y < 0 || x >= sz || y >= sz) {
                throw new ArrayIndexOutOfBoundsException("Wrong input file! position is outside of the map!");
            }
        }
        return mp;
        // Your code goes here ....
        // hint: you need to call placeSpaceship method....
    }
}
