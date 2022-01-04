package ph.pcbuild.prototype;

import java.util.Collection;

import static ph.pcbuild.prototype.DATA.*;

public class ComputerComponentRepository {
    public ComputerComponent findBy(int itemId) {
        return findAll().stream().filter(component -> component.getItemId() == itemId).findFirst().orElse(C1);
    }

    public Collection<ComputerComponent> findAll() { return COMPUTER_COMPONENTS;}
}
