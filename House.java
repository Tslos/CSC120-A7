import java.util.ArrayList;
import java.util.Arrays;

public class House extends Building {

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Constructor for the House Class
   * 
   * @param name          Name of the house - passed to the super class Building()
   * @param address       Address of the house - passed to the super class
   *                      Building()
   * @param nFloors       Number of floors the house has - passed to the super
   *                      class Building()
   * @param residents     the arraylist of the residents
   * @param hasDiningRoom Boolean - does the house have a dining hall?
   */
  public House(String name, String address, int nFloors, ArrayList<String> residents, boolean hasDiningRoom,
      boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = residents;
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  public String toString() {
    String desc = super.toString();
    // source for inline if statement:
    // https://www.delftstack.com/howto/java/one-line-if-statement-java/
    String elev = this.hasElevator ? "has an elevator" : "does not have an elevator";
    String dining = this.hasDiningRoom ? "has a dining hall" : "does not have a dining hall";
    return "Residence Hall: " + desc + ". It " + elev + " and " + dining + ".";
  }

  /**
   * Returns whether or not a House has a dining hall.
   * 
   * @return Boolean - does the house have a dining hall?
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Returns whether or not a House has an elevator
   * 
   * @return Boolean - does the house have an elevator?
   */
  public boolean hasElevator() {
    return this.hasElevator;
  }

  /**
   * Returns the number of residents that currently live in a House()
   * 
   * @return the size of the residential arraylist (number of residents)
   */
  public int nResidents() {
    return this.residents.size();
  }

  /**
   * Moves a new resident into a House()
   * 
   * @param name the name of the resident to be moved in.
   */
  public void moveIn(String name) {
    this.residents.add(name);
  }

  /**
   * OVERLOADED - Moves multiple residents into a House()
   * 
   * @param name the ArrayList<String> of residents to be moved in.
   */
  public void moveIn(ArrayList<String> names) {
    this.residents.addAll(names);
  }

  /**
   * Moves a new resident out of a House(). Checks if the person lives in the
   * house before executing.
   * 
   * @param name the name of the resident to be moved out.
   */
  public String moveOut(String name) {
    if (this.isResident(name)) {
      this.residents.remove(name);
      return name + " has moved out.";
    } else {
      return name + " could not move out because they do not live in " + this.name + ".";
    }

  }

  /**
   * OVERLOADED - Moves multiple residents out of a House(). Checks if the people
   * live in the
   * house before executing.
   * 
   * @param name the name of the resident to be moved out.
   */
  public String moveOut(ArrayList<String> names) {
    String results = "The following students have been asked to move out: \n";
    for (String name : names) {
      results = results + name + ": " + moveOut(name) + "\n";
    }
    return results;

  }

  /**
   * Returns if a given name is a current resident
   * 
   * @param person The name to check residential status.
   * @return
   */
  public boolean isResident(String person) {
    return this.residents.contains(person);
  }

  /**
   * Prints all class methods for the user.
   */
  public void showOptions() {
    // NOT using super.showOptions() here because sometimes I want to remove the
    // goToFloor() text
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
    if (this.hasElevator) {
      System.out.println("+ goToFloor()");
    }
    System.out.println(" + hasDiningRoom() \n + nResidents()\n + moveIn()\n + moveOut()\n + isResident()");
  }

  public static void main(String[] args) {
    // Make some residents
    ArrayList<String> gillettResidents = new ArrayList<String>(Arrays.asList("Nina Wattenberg", "Elm Markert",
        "Tillie Slosser", "Taylor Agena", "Em Swindell", "Ava Silverman", "Alex Theiss"));
    // Make my house
    House gillett = new House("Gillett House", "47 Elm Street", 5, gillettResidents, true, true);
    System.out.println(gillett);
    // How many residents does it have?
    System.out.println("Gillett has " + gillett.nResidents() + " residents.");
    // Am I a resident?
    System.out.println(gillett.isResident("Tillie Slosser"));
    // The president is graduating this year - move her out.
    System.out.println(gillett.moveOut("Nina Wattenberg"));
    // Try to move her out a second time to test the "person not a resident"
    // scenario
    System.out.println(gillett.moveOut("Nina Wattenberg"));

    // Try moving out all of gillett house
    // System.out.println(gillett.moveOut(gillettResidents));
    System.out.println(gillett.moveOut(new ArrayList<String>(Arrays.asList("Nina Wattenberg", "Elm Markert",
        "Tillie Slosser", "Taylor Agena", "testy test test"))));
  }

}