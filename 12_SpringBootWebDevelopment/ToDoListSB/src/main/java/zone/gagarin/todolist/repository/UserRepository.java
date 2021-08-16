package zone.gagarin.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zone.gagarin.todolist.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
  User findByUsername(String username);

}
