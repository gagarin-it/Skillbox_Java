package zone.gagarin.todolist.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zone.gagarin.todolist.entity.Subtask;
import zone.gagarin.todolist.entity.Task;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask,Long> {

  List<Subtask> findAllByTask(Task task);
}
