package ph.pcbuild.prototype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Hard Coded Data
 * Should be Moved to Test for user not to tinker on this, but will leave here because I don't want headache
 */

public class DATA {
    //Computer Components
    final static ComputerComponent C1 = new ComputerComponent(1, "RAM", "Kingston", "8GB DDR4 2400Mhz","Shopee",  1870, 25);
    final static ComputerComponent C2 = new ComputerComponent(2, "RAM", "Kingston", "8GB DDR4 2400Mhz","Lazada", 2000, 25);
    final static ComputerComponent C3 = new ComputerComponent(3, "CPU", "Intel", "i3 8100", "Shopee",5650,  25);
    final static Collection<ComputerComponent> COMPUTER_COMPONENTS = new ArrayList<>(List.of(C1, C2, C3));

    //Users
    final static User JAMES = new User(1, "James", "Bond");
    final static User BOB = new User(2, "Bob", "Sponge");
    final static User WARD = new User(3, "Ward", "Squid");
    final static Collection<User> USERS = new HashSet<>(List.of(JAMES, BOB, WARD));

}
