package ph.pcbuild.prototype;

import java.util.Collection;

import static ph.pcbuild.prototype.DATA.*;

public class ComputerComponentRepository {
    public ComputerComponent findBy(int itemId) {
        return findAll().stream().filter(component -> component.getItemId() == itemId).findFirst()
                .orElseThrow(() -> new CartException("Missing Item Id"));
    }

    public void addToShop(ComputerComponent component){
        COMPUTER_COMPONENTS.add(component);
    }

    public Collection<ComputerComponent> findAll() { return COMPUTER_COMPONENTS;}
}
