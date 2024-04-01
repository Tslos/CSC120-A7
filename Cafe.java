/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int maxCoffeeOunces; 
    private int nSugarPackets;
    private int maxSugarPackets; 
    private int nCreams; 
    private int maxCreams; 
    private int nCups; 
    private int maxCups; 

    /**
     * Constructor for a Café
     * 
     * @param name          The name of the café - passed to the super class
     *                      Building()
     * @param address       The address of the café - passed to the super class
     *                      Building()
     * @param nFloors       The number of floors in the café - passed to the super
     *                      class Building()
     * @param nCoffeeOunces The max/starting number of coffee ounces the café has in inventory
     * @param nSugarPackets The max/starting number of sugar packets the café has in inventory
     * @param nCreams       The max/starting number of creams the café has in inventory
     * @param nCups         The max/starting number of cups the café has in inventory
     */
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams,
            int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        // set max levels for restock reference
        this.maxCoffeeOunces = nCoffeeOunces;
        this.maxSugarPackets = nSugarPackets;
        this.maxCreams = nCreams;
        this.maxCups = nCups;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * decreases the Cafe's inventory according to the passed arguments.
     * Additionally, decreases nCups by 1.
     * 
     * @param size          Size of coffe serving: how much to decrease
     *                      nCoffeeOunces by
     * @param nSugarPackets How much to decrease nSugarPackets by
     * @param nCreams       How much to decrease nCreams by
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        try {
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
            System.out.println("☕☕☕ Here's your hot coffee! ☕☕☕");
            System.out.println("\t\t" + nSugarPackets + " ◽\n\t\t" + nCreams + " 🥛\n");
            // Check if things need restocking before getting another order - "too low"
            // values are kind of randomly chosen, but hopefully picked so that no one ever
            // orders a coffee that would put any of them in the negative (do people order
            // 20 sugars in their coffee??)
            if ((this.nCoffeeOunces < 100 ||
                    (this.nSugarPackets < 20) ||
                    (this.nCreams < 20) ||
                    (this.nCups < 1))) {
                throw new ArithmeticException("Not enough supplies for the next order, please restock.");
            }
        } catch (ArithmeticException e) {
            this.restock(
                    maxCoffeeOunces - nCoffeeOunces,
                    maxSugarPackets - nSugarPackets,
                    maxCreams - nCreams,
                    maxCups - nCups);
        }
    }

    /**
     * Restocks the cafe. Called from within Cafe.sellCoffee() in the event that
     * there is not enough of any item in the inventory. This function will always
     * bring the inventory to max capacity.
     * 
     * @param nCoffeeOunces number of coffee ounces to purchase
     * @param nSugarPackets number of sugar packets to purchase
     * @param nCreams       number of creams to purchase
     * @param nCups         number of cups to purchase
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
        System.out.println("~~~~~Sucessfully restocked~~~~~");
        System.out.println("\tPurchased:\n\tCoffees: " + nCoffeeOunces + "\n\tSugar Packets: " + nSugarPackets);
        System.out.println("\tCreams: " + nCreams + "\n\tCups: " + nCups + "\n");
    }
    // ------------------------ END A6 CODE ------------------------
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + restock(n,n,n,n) \n + sellCoffee(n,n,n)");
    }

    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Café", "9 Elm St, Northampton", 1, 1000, 100, 100, 100);
        for (int i = 0; i < 200; i++) {
            compass.sellCoffee(12, 3, 4);
        }
        compass.sellCoffee(12, 3, 4);
    }

}
