package ph.pcbuild.prototype;

import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

import static org.apache.commons.lang3.Validate.*;

public class ComputerComponent {
    private final int itemId;
    private final String shop;
    private final String component;
    private final String brand;
    private final String model;
    private float price;
    private int quantity;
    private final ReentrantLock lock = new ReentrantLock();



    public ComputerComponent(int itemId, String shop, String component, String brand, String model, float price, int quantity) {
        notBlank(shop);
        notBlank(component);
        notBlank(brand);
        notBlank(model);
        this.itemId = itemId;
        this.shop = shop;
        this.component = component;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemId(){
        return itemId;
    }

    @Override
    public String toString() {
        return "item#" + itemId + " " + shop + " " + component + "\n" +
                brand + " " + model + " " + price + ": " + quantity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        ComputerComponent other = (ComputerComponent) object;
        return this.itemId == other.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    public boolean equalComponentPart(ComputerComponent component) {
        if (this == component)
            return true;
        if (component == null)
            return false;
        ComputerComponent other = component;
        return this.component.equalsIgnoreCase(other.component);
    }

    void incrementQuantity() { quantity++; }

    void decrementQuantity() {
        quantity--;
    }

    /** Locks this object's ReentrantLock **/
    void lock() { lock.lock(); }

    /** Unlock this object's ReentrantLock **/
    void unlock() {
        lock.unlock();
    }
}
