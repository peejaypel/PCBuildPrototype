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
    final static ComputerComponent C1 = new ComputerComponent(1, "RAM", "Kingston", "8GB DDR4 2400Mhz", "Shopee", 1870, 25);
    final static ComputerComponent C2 = new ComputerComponent(2, "RAM", "Kingston", "8GB DDR4 2400Mhz", "Lazada", 2000, 25);
    final static ComputerComponent C3 = new ComputerComponent(3, "CPU", "Intel", "i3 8100", "Shopee", 5650, 25);
    final static ComputerComponent C4 = new ComputerComponent(4, "CPU", "Intel", "AMD A8-6600", "Shopee", 1275, 25);
    final static ComputerComponent C5 = new ComputerComponent(5, "CPU", "Intel", "Core i7 4790K", "Shopee", 6670, 25);
    final static ComputerComponent C6 = new ComputerComponent(6, "Motherboard", "Asus", " TUF GAMING B550-PLUS", "Shopee", 7970, 25);
    final static ComputerComponent C7 = new ComputerComponent(7, "Motherboard", "Gigabyte", "B450M AORUS ELITE", "Shopee", 5265, 25);
    final static ComputerComponent C8 = new ComputerComponent(8, "Motherboard", "MSI", "MAG B550M", "Shopee", 7500, 25);
    final static ComputerComponent C9 = new ComputerComponent(9, "HDD", "Toshiba", "1TB HDD 3.5in Internal", "Shopee", 2075, 25);
    final static ComputerComponent C10 = new ComputerComponent(10, "HDD", "Seagate", "1TB SkyHawk 3.5", "Shopee", 2290, 25);
    final static ComputerComponent C11 = new ComputerComponent(11, "HDD", "Seagate", "2TB SkyHawk 3.5", "Shopee", 3200, 25);
    final static ComputerComponent C12 = new ComputerComponent(12, "PSU", "Gigabyte", "P550B 550W", "Shopee", 2535, 25);
    final static ComputerComponent C13 = new ComputerComponent(13, "PSU", "Corsair", "CV750", "Shopee", 3799, 25);
    final static ComputerComponent C14 = new ComputerComponent(14, "PSU", "Cooler Master", "MWE Gold - II", "Shopee", 5999, 25);
    final static Collection<ComputerComponent> COMPUTER_COMPONENTS = new ArrayList<>(List.of(C1, C2, C3, C4, C5, C6, C7, C8, C9));

    //Users
    final static User JAMES = new User(1, "James", "Bond");
    final static User BOB = new User(2, "Bob", "Sponge");
    final static User WARD = new User(3, "Ward", "Squid");
    final static Collection<User> USERS = new HashSet<>(List.of(JAMES, BOB, WARD));

}
