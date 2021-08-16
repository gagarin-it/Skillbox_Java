package zone.gagarin.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zone.gagarin.todolist.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
