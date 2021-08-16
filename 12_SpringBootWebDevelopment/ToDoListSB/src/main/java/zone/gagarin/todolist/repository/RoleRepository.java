package zone.gagarin.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zone.gagarin.todolist.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
