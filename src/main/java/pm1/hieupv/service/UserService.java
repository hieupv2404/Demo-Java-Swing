package pm1.hieupv.service;

import pm1.hieupv.model.User;

public interface UserService {
    boolean findUserForLogin(User user);
}
