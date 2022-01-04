package ph.pcbuild.prototype;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.apache.commons.lang3.Validate.*;

public class User {
    private final int userId;
    private final String firstName;
    private final String lastName;
    private List<ComputerComponent> cart;

    User(int userId, String firstName, String lastName){
        isTrue(userId >= 0, "userId should be non-negative, was: " + userId);
        notBlank(firstName);
        notBlank(lastName);
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addToCart(ComputerComponent component){
        notNull(component);
        component.lock();
        // make sure only one thread at a time
        try{
            component.decrementQuantity();
            cart.add(component);
        } finally {
            component.unlock();
        }
    }

    void removeFromCart(ComputerComponent component){
        notNull(component);
        component.lock();
        try{
            if(cart.remove(component)){
                component.incrementQuantity();
            }
        } finally {
            component.unlock();
        }
    }

    public int getUserId(){ return userId;}

    public Collection<ComputerComponent> getCart() {
        return new ArrayList<>(cart);
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
