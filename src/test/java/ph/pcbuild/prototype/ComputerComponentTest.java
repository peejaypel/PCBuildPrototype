package ph.pcbuild.prototype;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ComputerComponentTest {
    @Test
    void out_of_stock(){
        ComputerComponent C1 = new ComputerComponent (1, "SET", "ASUS", "ROG Full Build", "Shopee", 38700, 2);

        User U1 = new User(1,"John", "Doe");
        User U2 = new User(2,"Susan", "Ray");
        User U3 = new User(3,"Cole", "Mi");

        U1.addToCart(C1);
        U2.addToCart(C1);
        assertThrows(OutOfStockException.class, () -> U3.addToCart(C1));


    }
    @Test
    void add_to_cart_successful(){
        ComputerComponent C1 = new ComputerComponent (1, "SET", "ASUS", "ROG STRIX Full Build", "Shopee", 52500, 2);

        User U1 = new User(1,"Near", "Far");
        U1.addToCart(C1);
        assertEquals(1,C1.getQuantity());

    }
}
