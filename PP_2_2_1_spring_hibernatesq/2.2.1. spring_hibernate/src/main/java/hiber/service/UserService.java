package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    void add(User user);
    List<User> getUserByCar(String model, int series);
}
