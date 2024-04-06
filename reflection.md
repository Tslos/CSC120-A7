Use this file to record your reflection on this assignment.

Note about `goToFloor()`: It seemed like to override the method for `Library()` and `House()`, I would end up repeating decent chunks of code. I wanted to minimize lines of code written, so instead of overriding within the subclasses, I added the attribute `hasElevator` to the `Building()` class (set to false automatically in the constructor) and edited `goToFloor()` to check if a user was trying to travel more than one floor at a time without having access to an elevator. This way, I didn't end up needing to override `goToFloor()` in `Library()` and `House()` because the elevator check was built into their parent. Because most `Cafe()`s don't have seconds floors that customers can go to, I didn't change `Cafe.hasElevator ` from the default `false`. `House()`s already took in a parameter to determine if it has an elevator. `Library()` was changed to take a `hasElevator` argument in its constructor. 

- Which methods did you decide to `overload`, and why?

**Cafe:**

I overloaded the constructor to have a default, address-only, and address+name-only constructors, as well as a default `sellCoffee()` method that took no arguments. These were all done in the name of convenience for quick-testing.  

**House:**
I overloaded the `moveIn()` and `moveOut()` methods to take an `ArrayList<String>` of residents, instead of one at a time. This would be useful for the beginning and end of academic years, when many students need to move in / out all at once

**Library:** 

I overloaded the `addTitle()`, `removeTitle()`, `checkOut()`, and `returnBook()` methods to take `ArrayList<String>`s. It would be very inconvenient to have to start a new checkout / return session for every individual book if you wanted to check them out in batches. Similarly, libraries rarely purchase / remove books one at a time, rather doing it in batches as they get the funding / do a cleanout.  

- What worked, what didn't, what advice would you give someone taking this course in the future?

Overloading the methods was pretty quick for the `Library()` and `House()` classes - I mostly just had to make a loop and then call the original function. For some reason during the coding of this, I had a very odd error in which none of my Java would compile (without directing me towards the `PROBLEMS` tab of the terminal like usual), and no problems would appear unless I restarted my VSCode session - and even then, the problems were cryptic (`Preview features enabled at an invalid source release level 21, preview can be enabled only at source level 22`) and would disappear as soon as I clicked on them. I ended up clearing the Java server workspace, which did the trick, but I still have no idea what happened there. I would advise making sure that your methods are well-organized, because with all the overloading it can get confusing to remember what you have already overloaded and what you have not. 