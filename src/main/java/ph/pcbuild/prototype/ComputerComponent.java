package ph.pcbuild.prototype;

import static org.apache.commons.lang3.Validate.*;

public class ComputerComponent {
    private final int itemID;
    private final String shop;
    private final String component;
    private final String brand;
    private final String model;
    private float price;


    public ComputerComponent(int itemID, String shop, String component, String brand, String model, float price) {
        notBlank(shop);
        notBlank(component);
        notBlank(brand);
        notBlank(model);
        this.itemID = itemID;
        this.shop = shop;
        this.component = component;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return "item#" + itemID + " " + shop + " " + component + "\n" +
                brand + " " + model + " " + price;
    }

    public boolean equalComponentPart(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ComputerComponent other = (ComputerComponent) obj;
        return component == other.component;
    }
}
