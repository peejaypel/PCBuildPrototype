package ph.pcbuild.prototype;

import java.util.*;

import static org.apache.commons.lang3.Validate.*;

public class User {
    private final int userId;
    private final String firstName;
    private final String lastName;
    private HashMap<ComputerComponent, Integer> cart = new HashMap<>();

    User(int userId, String firstName, String lastName){
        isTrue(userId >= 0, "userId should be non-negative, was: " + userId);
        notBlank(firstName);
        notBlank(lastName);
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUserId(){ return userId;}


    public void addToCart(ComputerComponent component){
        notNull(component);
        component.lock();
        // make sure only one thread at a time
        try{
            component.decrementQuantity();
            Integer quantity =
                    cart.get(component) == null? 1 : cart.get(component) + 1;
            cart.put(component, quantity);
        } finally {
            component.unlock();
        }
    }

    public void removeFromCart(ComputerComponent component){
        notNull(component);
        component.lock();
        try{
            int quantity = cart.get(component);
            for(int i = 0; i < quantity; i++){
                component.incrementQuantity();
                //return all product to shop
            }
            //then remove from cart
            cart.remove(component);
        } finally {
            component.unlock();
        }
    }

    public HashMap<ComputerComponent, Integer> getCart() {
        return new HashMap<>(cart);
    }

    @Override
    public String toString() {
        return "User #" + userId + " " + firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
