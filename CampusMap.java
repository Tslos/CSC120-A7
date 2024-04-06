
//import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Scanner;

//import javax.management.RuntimeErrorException;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * 
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * 
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " ("
                    + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    // Might come back to this later - my first pass at attempting to make this
    // interactive
    /*
     * public void interact() {
     * Scanner sc = new Scanner(System.in);
     * System.out.
     * println("Welcome to campus! Enter the building number you wish to enter");
     * this.toString();
     * int command = sc.nextInt() - 1;
     * sc.nextLine();
     * while (command != -99) {
     * Building currentBuilding = this.buildings.get(command);
     * currentBuilding.showOptions();
     * System.out.println("What would you like to do?");
     * String action = sc.nextLine();
     * sc.nextLine();
     * Method method = Building.class.getDeclaredMethod(action);
     * method.invoke(this, null);
     * }
     * 
     * 
     * 
     * sc.close();
     * }
     */

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        // my buildings added below
        myMap.addBuilding(
                new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 1, 1000, 1000, 1000, 1000));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 5, true));
        myMap.addBuilding(
                new House("Gillett House", "47 Elm Street, Northampton, MA 01063", 5,
                        new ArrayList<String>(Arrays.asList("Nina Wattenberg", "Elm Markert",
                                "Tillie Slosser", "Taylor Agena", "Em Swindell", "Ava Silverman", "Alex Theiss")),
                        true, true));
        myMap.addBuilding(new Building("Sabin-Reed", "44 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Josten", "122 Green Street", 3, false));
        myMap.addBuilding(new Building("Lyman Plant House", "16 College Ln, Northampton, MA 01063", 2));
        myMap.addBuilding(new Building("Sage Hall", "144 Green St, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Boathouse", "21 College Ln, Northampton, MA 01063", 1));
        myMap.addBuilding(new Building("Seelye Hall", "Seelye Hall, 2 Seelye Dr, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Olin Fitness Center",
                "Ainsworth Gym and Olin Fitness Center, 102 Lower College Ln, Northampton, MA 01060", 5));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Ct, Northampton, MA 01060", 4));
        myMap.addBuilding(new Building("Mcconnell Hall", "01063, 2 Tyler Ct, Northampton, MA 01060", 5));
        System.out.println(myMap);

    }

}
