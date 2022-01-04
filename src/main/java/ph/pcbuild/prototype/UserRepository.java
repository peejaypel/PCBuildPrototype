package ph.pcbuild.prototype;

import java.util.Collection;
import static ph.pcbuild.prototype.DATA.*;

public class UserRepository {
    public User findBy(int userId) {
        return findAll().stream().filter(user -> user.getUserId() == userId).findFirst().orElse(JAMES);
    }

    public Collection<User> findAll() { return USERS;}
}
