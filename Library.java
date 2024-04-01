/* This is a stub for the Library class */

import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

import javax.naming.InvalidNameException;
import javax.naming.LimitExceededException;

public class Library extends Building {

  private Hashtable<String, Boolean> collection;

  /**
   * Constructor for the Library Class. This class is an extension of the
   * Building() Class
   * 
   * @param name    the name of the library building to construct, passed to the
   *                parent class
   * @param address the address of the building, passed to the parent class
   * @param nFloors the number of floors the building has
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Add a title to the library's collection. If the title already exists, this
   * function prints a statement warning the user.
   * 
   * @param title the book to add
   */
  public void addTitle(String title) {
    try {
      // If the book is already in the collection, start search for lowest unique copy
      // number
      if (this.containsTitle(title)) {
        for (int i = 1; i < 200; i++) {
          // If the current iteration of for loop is not a current copy, re-assign title
          // to include copy info
          if (!this.containsTitle(title + ", copy " + i)) {
            title = title + ", copy " + i;
            break;
          }
          // If on the last iteration, throw an error to let user know that there are too
          // many books with that title
          if (i == 199) {
            throw new LimitExceededException();
          }
        } // exit for loop
      } // exit check for existing copy
      // add the title (may have been edited to include copy num!)
      this.collection.put(title, true);
      System.out.println("TITLE ADDED: " + title);
    } catch (Exception e) {
      System.out.println(
          "Error in adding " + title + ". There are too many copies of this book, please add a different title.");
    }
  }

  /**
   * Removes a title from the collection (as opposed to checking it out)
   * 
   * @param title the title that is to be removed
   * @return the removed title
   */
  public String removeTitle(String title) {
    try {
      if (this.containsTitle(title)) {
        this.collection.remove(title, true);
        return (title);
      } else {
        throw new InvalidNameException("The title \"" + title + "\" is not in the library, and cannot be removed.");
      }
    } catch (Exception e) {
      System.out.println(e);
      return (title);
    }
  }

  /**
   * Checks a title out of the collection (as opposed to removing it entirely)
   * 
   * @param title the title to be checked out
   */
  public void checkOut(String title) {
    try {
      if (this.containsTitle(title)) {
        this.collection.replace(title, false);
      } else {
        throw new InvalidNameException("The title \"" + title + "\" is not in the library, and cannot be checked out.");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Returns a book to the library (as opposed to adding a new copy)
   * 
   * @param title the title to be returned
   */
  public void returnBook(String title) {
    try {
      if (this.containsTitle(title)) {
        this.collection.replace(title, true);
      } else {
        throw new InvalidNameException("The title \"" + title + "\" is not in the library, and cannot be returned.");
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Returns true if the title appears as a key in the Libary's collection, false
   * otherwise
   * 
   * @param title the title in question
   * @return a true or false value based on if the title is present in the
   *         collection
   */
  public boolean containsTitle(String title) {
    return (this.collection.containsKey(title));
  }

  /**
   * Returns true if the title is currently available, false otherwise. Throws and
   * catches an error if the title is not in the collection at all.
   * 
   * @param title the title in question
   * @return a true or false value based on if the title is currently availible
   */
  public boolean isAvailable(String title) {
    try {
      if (containsTitle(title)) {
        return (this.collection.getOrDefault(title, false));
      } else {
        throw new InvalidNameException(
            "The title \"" + title + "\" is not in the library, therefore it is not available.");
      }
    } catch (Exception e) {
      System.out.println(e);
      return (false);
    }
  }

  /**
   * prints out the entire collection in an easy-to-read way (including checkout
   * status)
   */
  public void printCollection() {
    // source for Treemap inspiration:
    // https://www.javacodeexamples.com/sort-hashtable-by-keys-in-java-example/3165
    Map<String, Boolean> sortedCollection = new TreeMap<String, Boolean>(this.collection);
    System.out.println("\n------Welcome to " + this.name + " Library. Here is our selection:------");
    sortedCollection.forEach(
        (title, checkoutStatus) -> {
          String checkoutStr = checkoutStatus ? "available" : "checked out";
          System.out.println("\tThe book " + title + " is " + checkoutStr);
        });
  }

  // ------------------------ END A6 CODE ------------------------
  public void showOptions() {
    // NOT using super.showOptions() here because sometimes I want to remove the goToFloor() text
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()");
    if (this.hasElevator) { System.out.println("+ goToFloor(n)");}
    System.out.println(" + addTitle(title) \n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)");
}

public void goToFloor(int floorNum) {
  if (!this.hasElevator) {
      throw new RuntimeException("This building does not have an elevator. Please take the stairs by using the `goUp()` or `goDown()` methods");
  }
  super.goToFloor(floorNum);
}



  public static void main(String[] args) {
    Library josten = new Library("Josten", "122 Green Street", 3);
    josten.addTitle("Music Theory I by B. Toven");
    josten.addTitle("Music Theory I by B. Toven");
    josten.addTitle("Rock 'n Roll Classics by Elle Vess.");
    josten.addTitle("Whaling Songs of the Northeast Atlantic, 1840-1970 by C. Shantiés");

    josten.checkOut("Music Theory I by B. Toven");
    josten.printCollection();

    josten.returnBook("Music Theory I by B. Toven");
    josten.returnBook("Cats and The Ice Age");
    josten.printCollection();
  }

}