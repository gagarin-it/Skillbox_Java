package zone.gagarin.todolist.service;

import zone.gagarin.todolist.entity.User;

public interface UserService {
  void save(User user);

  User findByUsername(String username);

}
