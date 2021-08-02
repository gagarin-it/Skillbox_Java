package zone.gagarin.todolist.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zone.gagarin.todolist.entity.Subtask;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask,Integer> {

}
